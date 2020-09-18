package org.gfarm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    //非对称加密方式——RSA配置——连接资源服务器和授权服务器
    @Value("${config.oauth2.privateKey}")
    private String privateKey ;
    @Value("${config.oauth2.publicKey}")
    private String publicKey;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 定义了两个客户端应用的通行证
        clients.inMemory()
                .withClient("sheep1")
                .secret(new BCryptPasswordEncoder().encode("123456"))
                .authorizedGrantTypes("authorization_code", "refresh_token","client_credentials","password","implicit")
                .scopes("read") //指定这个客户端可以访问哪些资源域，可以多个，配合资源服务器的权限设置生效
                .autoApprove(false)
                .resourceIds("gfm-web","gfm-batch") //指定这个客户端可以访问哪些资源服务器,如果不设置则该clientId可以访问所有资源服务器
                .redirectUris("http://localhost:8086/login","http://localhost:8087/login","https://www.baidu.com") //指定哪些跳转url可接受
                .and()
                .withClient("sheep2")
                .secret(new BCryptPasswordEncoder().encode("123456"))
                .authorizedGrantTypes("authorization_code", "refresh_token","client_credentials","password")
                .scopes("all")
                .autoApprove(true)
                .resourceIds("gfm-batch") //指定这个客户端可以访问哪些资源服务器
                .redirectUris("http://localhost:8087/login");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")                    //oauth/token_key是公开，不然资源服务器 来请求403
                .checkTokenAccess("isAuthenticated()")            //oauth/check_token
                .allowFormAuthenticationForClients()			  //表单认证（申请令牌）,即可以通过postman发送http请求获取token
        ;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
        DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 一天有效期
        endpoints.tokenServices(tokenServices);
        // 请求令牌路径 /oauth/token 默认只支持POST，这里增加GET
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        // 获取token的CompositeTokenGranter默认没有ResourceOwnerPasswordTokenGranter,即grant_type=password的获取token的形式
        // AuthorizationServerEndpointsConfigurer.getDefaultTokenGranters(): 此方法种添加自定义显示暴露的AuthenticationManager
        endpoints.authenticationManager(authenticationManager);
        //必须要注入 userDetailsService，否则根据refresh_token无法加载用户信息，因为grant_type=refresh_token时我们只传递了client的信息。
        endpoints.userDetailsService(userDetailsService);
    }

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("testKey");//对称加密方式

        converter.setSigningKey(privateKey);//非对称加密方式——私钥
        converter.setVerifierKey(publicKey);//非对称加密方式——公钥
        return converter;
    }

}

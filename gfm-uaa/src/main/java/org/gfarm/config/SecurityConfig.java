//package org.gfarm.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//public class SecurityConfig {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Bean
//    protected UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("codesheep").password(passwordEncoder.encode("123456")).authorities("ROLE_NORMAL,ROLE_MEDIUM").build());
//        manager.createUser(User.withUsername("codesheep1").password("123456").authorities("ROLE_NORMAL,ROLE_MEDIUM").build());
//        return manager;
//    }
//
//    @Configuration
//    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Bean
//        public DaoAuthenticationProvider authenticationProvider() {
//            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//            authenticationProvider.setUserDetailsService(userDetailsService());
//            authenticationProvider.setPasswordEncoder(passwordEncoder());
//            authenticationProvider.setHideUserNotFoundExceptions(false);
//            return authenticationProvider;
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.authenticationProvider(authenticationProvider());
//        }
//
//        /**
//         * springboot2.0 的自动配置发生略微的变更，原先的自动配置现在需要通过@Bean暴露，否则你会得到AuthenticationManager找不到的异常
//         * @return
//         * @throws Exception
//         */
//        @Override
//        @Bean
//        protected AuthenticationManager authenticationManager() throws Exception {
//            return super.authenticationManager();
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .requestMatchers().antMatchers("/oauth/**","/login/**","/logout/**")
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/oauth/**").authenticated()
//                    .and()
//                    .formLogin().permitAll()
//            ;
//        }
//    }
//
//
//    @Configuration
//    @EnableAuthorizationServer
//    public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//
//        @Autowired
//        private AuthenticationManager authenticationManager;
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            // 定义了两个客户端应用的通行证
//            clients.inMemory()
//                    .withClient("sheep1")
//                    .secret(new BCryptPasswordEncoder().encode("123456"))
//                    .authorizedGrantTypes("authorization_code", "refresh_token","client_credentials","password")
//                    .scopes("all")
//                    .autoApprove(false)
//                    .redirectUris("http://localhost:8086/login")
//                    .and()
//                    .withClient("sheep2")
//                    .secret(new BCryptPasswordEncoder().encode("123456"))
//                    .authorizedGrantTypes("authorization_code", "refresh_token","client_credentials","password")
//                    .scopes("all")
//                    .autoApprove(true)
//                    .redirectUris("http://localhost:8087/login");
//        }
//
//        @Override
//        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//            security
//                    .tokenKeyAccess("permitAll()")                    //oauth/token_key是公开
//                    .checkTokenAccess("permitAll()")                  //oauth/check_token公开
//                    .allowFormAuthenticationForClients()				//表单认证（申请令牌）
//            ;
//        }
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
//            DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
//            tokenServices.setTokenStore(endpoints.getTokenStore());
//            tokenServices.setSupportRefreshToken(true);
//            tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//            tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//            tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 一天有效期
//            endpoints.tokenServices(tokenServices);
//            // 请求令牌路径 /oauth/token 默认只支持POST，这里增加GET
//            endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
//            // 获取token的CompositeTokenGranter默认没有ResourceOwnerPasswordTokenGranter,即grant_type=password的获取token的形式
//            // AuthorizationServerEndpointsConfigurer.getDefaultTokenGranters(): 此方法种添加自定义显示暴露的AuthenticationManager
//            endpoints.authenticationManager(authenticationManager);
//            //必须要注入 userDetailsService，否则根据refresh_token无法加载用户信息，因为grant_type=refresh_token时我们只传递了client的信息。
//            endpoints.userDetailsService(userDetailsService());
//        }
//
//        @Bean
//        public TokenStore jwtTokenStore() {
//            return new JwtTokenStore(jwtAccessTokenConverter());
//        }
//
//        @Bean
//        public JwtAccessTokenConverter jwtAccessTokenConverter(){
//            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//            converter.setSigningKey("testKey");
//            return converter;
//        }
//
//    }
//
//}

package org.gfarm.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;


/**
 * @EnableOAuth2Sso 将您的服务标记为OAuth2.0客户端。即重定向到uaa服务进行鉴权
 * 这意味着它将负责将资源所有者(最终用户)重定向到用户必须输入其凭据的授权服务器。完成后，用户将被重定向回具有授权码的客户端(不要与访问代码混淆)。然后客户端通过调用授权服务器获取授权代码并将其交换为访问令牌。只有在此之后，客户端才能使用访问令牌调用资源服务器。
 * 该注释会使用grant_type=authorization_code自动处理后续的鉴权+返回token+带token访问流程
 * 如果不使用该注释，则不会自动进行，需要手动走一系列流程获取token
 *
 * 另外，如果你看一下@ EnableOAuth2Sso注释的源代码，你会看到两件有趣的事情：
 * > @ EnableOAuth2Client。这是您的服务成为OAuth 2.0客户端的地方。如果您通过OAuth2RestTemplate调用这些服务，则可以将访问令牌(在交换授权代码之后)转发到下游服务。
 * > @EnableConfigurationProperties(OAuth2SsoProperties.class)。 OAuth2SsoProperties只有一个属性String loginPath，默认为/ login。这将拦截OAuth2ClientAuthenticationProcessingFilter对/ login的浏览器请求，并将用户重定向到授权服务器。
 *
 * 参考:
 * https://www.cnblogs.com/trust-freedom/p/12002089.html#%E4%B8%80%E4%BB%8Espring-security-oauth2%E5%AE%98%E6%96%B9%E6%96%87%E6%A1%A3%E4%BA%86%E8%A7%A3enableoauth2sso%E4%BD%9C%E7%94%A8
 *
 * @EnableOAuth2Sso 注解让spring security的鉴权逻辑转移到了配置的uaa，且仅对WebSecurityConfigurerAdapter下的路径生效。
 * 由于WebSecurityConfigurerAdapter的默认优先级比ResourceServerConfigurerAdapter低，
 * 所以当想对ResourceServerConfigurerAdapter下的路径也实现@EnableOAuth2Sso提供的自动验证功能，
 * 需要提高WebSecurityConfigurerAdapter的优先级，这里加注解@Order(2)
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableOAuth2Sso
@Order(2)
public class ClientWebsecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        RequestMatcher nonResoures = new NegatedRequestMatcher(new AntPathRequestMatcher("/fuji/test/**"));

        /**
         * 对"/fuji/test/**"以外的路径进行spring security权限验证，其中对"/fuji/comrade/**","/oauth/**", "/login**", "/error**"这些路径放行
         */
        http
                .csrf().disable()//禁用CSRF,不然会影响权限校验
                .requestMatcher(nonResoures)
                .authorizeRequests(
                        request -> {
                            try {
                                request.antMatchers((HttpMethod) null,"/fuji/comrade/**","/oauth/**", "/login**", "/error**") //默认配置的请求路径只对GET方法有效,这里配置对所有HTTP方法的/fuji/comrade开头的路径放开(因为使用了@PreAuthorize注解,所以还是会提示权限问题,去掉即可实现正常访问),以及跳转OAuth 2.0的请求路径放开
                                        .permitAll()
                                        .anyRequest().authenticated()
                                        .and()
                                        .formLogin().permitAll() //配置这句代码,才会实现自动跳转登录（非uaa，是spring security本身的登录机制，这里configure方法没配置，即没有设置spring security的登录用户信息，所以登不上）
                                ;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                )
//                .anyRequest().permitAll()
        ;

        /**
         * 对所有请求路径放行
         */
//        http
//                .csrf().disable()//禁用CSRF,不然会影响权限校验
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll()
//        ;
    }

}

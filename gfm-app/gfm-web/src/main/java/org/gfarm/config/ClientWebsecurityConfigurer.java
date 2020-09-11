package org.gfarm.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * @EnableOAuth2Sso 将您的服务标记为OAuth2.0客户端。这意味着它将负责将资源所有者(最终用户)重定向到用户必须输入其凭据的授权服务器。完成后，用户将被重定向回具有授权码的客户端(不要与访问代码混淆)。然后客户端通过调用授权服务器获取授权代码并将其交换为访问令牌。只有在此之后，客户端才能使用访问令牌调用资源服务器。
 * 该注释会使用grant_type=authorization_code自动处理后续的鉴权+返回token+带token访问流程
 * 如果不使用该注释，则不会自动进行，需要手动走一系列流程获取token
 *
 * 另外，如果你看一下@ EnableOAuth2Sso注释的源代码，你会看到两件有趣的事情：
 * > @ EnableOAuth2Client。这是您的服务成为OAuth 2.0客户端的地方。如果您通过OAuth2RestTemplate调用这些服务，则可以将访问令牌(在交换授权代码之后)转发到下游服务。
 * > @EnableConfigurationProperties(OAuth2SsoProperties.class)。 OAuth2SsoProperties只有一个属性String loginPath，默认为/ login。这将拦截OAuth2ClientAuthenticationProcessingFilter对/ login的浏览器请求，并将用户重定向到授权服务器。
 *
 *
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableOAuth2Sso
public class ClientWebsecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        RequestMatcher nonResoures = new NegatedRequestMatcher(new AntPathRequestMatcher("/fuji/test/**"));

        http
                .requestMatcher(nonResoures)
                .authorizeRequests()
                .anyRequest().permitAll()
        ;
    }

}

package org.gfarm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @EnableResourceServer 注解标识该服务是一个资源服务器，以下配置表示/fuji/batch/**的路径均看作对该资源服务器的访问，需要首先从uaa获得令牌
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .requestMatchers().antMatchers("/fuji/batch/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                //对于/fuji/batch路径只有当访问者（client）拥有read scope时，才被允许
                .access("#oauth2.hasScope('read')")
                //如果不使用.access()权限控制，.authenticated()表示只要授权通过即可访问
//                .authenticated()
        ;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("gfm-batch");
    }

}

package org.gfarm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *  Spring Security为每个配置创建一个过滤器链。每个过滤器链的请求匹配器按照配置顺序进行评估。
 *  WebSecurityConfigurerAdapter 的默认顺序为100， ResourceServerConfiguration 的默认顺序为3。这意味着 ResourceServerConfiguration 的请求匹配器将首先进行评估，即满足这里的过滤器的请求会按这里的过滤器链进行处理
 *
 *  @EnableResourceServer 注释意味着您的服务(就OAuth2.0而言 – 资源服务器)需要访问令牌才能进行请求。在调用资源服务器之前，应通过OAuth 2.0客户端从授权服务器获取访问令牌。
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // 仅对访问路径 /fuji/test/** 调用此过滤器链，即只对特定的请求使用token鉴权访问
        http
                .requestMatchers().antMatchers("/fuji/test/**")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
        ;
    }
}
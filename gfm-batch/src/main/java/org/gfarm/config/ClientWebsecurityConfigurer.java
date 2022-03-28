package org.gfarm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * 资源服务器可以除了使用uaa鉴权服务器进行token进行权限控制外，也可以自己独立起一套权限控制系统
 * （对哪些路径进行权限控制，如果访问路径和uaa鉴权服务器重复，默认uaa优先，但是可以通过控制
 * WebSecurityConfigurerAdapter和ResourceServerConfigurerAdapter的启动顺序控制谁优先匹配）
 *
 * The resource server also provides a mechanism to authenticate users themselves.
 * It will be a form-based login in most cases.
 *
 * 这里没有@EnableOAuth2Sso注解，即没有使用UAA提供的鉴权服务，而是使用了spring security本身的登录机制
 */
@Configuration
@EnableWebSecurity
public class ClientWebsecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("lizhen")
                .password(passwordEncoder()
                        .encode("123456"))
                .roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        RequestMatcher nonResoures = new NegatedRequestMatcher(new AntPathRequestMatcher("/fuji/batch/**"));


        http
                //除了/fuji/batch/**以外的路径均需经过这条过滤器链
                .requestMatcher(nonResoures)
                .authorizeRequests()
                //针对/oauth/**（/oauth/get）访问和/login**（/login123）这些路径放行
                .antMatchers("/oauth/**", "/login**", "/error**")
                .permitAll()
                .and()
                .authorizeRequests()
                //剩下的路径均需登录
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll(); //配置这句代码,才会实现自动跳转登录（非uaa，是spring security本身的登录机制）
    }



}

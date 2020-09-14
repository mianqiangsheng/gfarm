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
                .formLogin().permitAll();
    }



}

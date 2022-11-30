package com.ldh.board.demo.global.security;

import com.ldh.board.demo.global.security.handler.LoginFailureHandler;
import com.ldh.board.demo.global.security.userdetail.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailService userDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.GET,"/list").permitAll()
                .antMatchers(HttpMethod.GET, "/view/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/list")
                .usernameParameter("userId")
                .failureHandler(failureHandler())
                .permitAll();

        http.logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/list")
                .invalidateHttpSession(true)
                .permitAll();

        http.headers().frameOptions().sameOrigin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public LoginFailureHandler failureHandler() {
        return new LoginFailureHandler();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

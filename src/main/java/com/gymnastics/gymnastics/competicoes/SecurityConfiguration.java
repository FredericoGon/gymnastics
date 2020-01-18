package com.gymnastics.gymnastics.competicoes;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(totAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and()
                .formLogin().loginPage("/login")
                .successHandler(new AuthenticationSuccessHandkerImpl())
                .failureUrl("/login-error")
                .authenticationDetailsSource(new AdditionalAuthenticationDetailsSource())
                .and().rememberMe()
                .authenticationSuccessHandler(new AuthenticationSuccessHandlerImpl())
                .tokenRepository()

    }
}

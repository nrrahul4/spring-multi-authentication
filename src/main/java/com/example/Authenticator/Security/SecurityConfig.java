package com.example.Authenticator.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.lang.constant.Constable;
import java.util.function.Function;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    protected static final String ENCODED_PWD = "$2a$10$KtphGNMgY4TgmW9ZiYNsI.H/2OgDniiGw8.1ia9neDS8hy8iD9h22";

    @Bean
    public PasswordEncoder bcryptEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService() throws Exception {

        UserDetails user =
                User.withUsername("Rahul")
                        .password(ENCODED_PWD).roles()
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/getSample")
                .authenticated();

        return http.build();
    }
}

package com.example.SpringBootSecurityTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //below code is for setting custom username and password using securityconfig file
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("root")
                .password("{noop}root")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}

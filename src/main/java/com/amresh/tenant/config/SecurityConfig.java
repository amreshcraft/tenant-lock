package com.amresh.tenant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // CSRF disable karna (stateless API ke liye)
                .csrf(AbstractHttpConfigurer::disable)

                // Form login disable
                .formLogin(AbstractHttpConfigurer::disable)

                // HTTP Basic disable (optional)
                .httpBasic(AbstractHttpConfigurer::disable)

                // Logout disable
                .logout(AbstractHttpConfigurer::disable)

                // Sab requests permit karo
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // ✅ "/**" = sab URLs
                )
                .build();
    }
}
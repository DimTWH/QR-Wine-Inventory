package com.QRwineinventory.qrWineInventory.configs;

import com.QRwineinventory.qrWineInventory.services.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final MyUserDetailsService myUserDetailsService;

    public SecurityConfiguration(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> {
                            try {
                                auth
                                    .requestMatchers("/inventory/user/list").hasRole("ADMIN")
                                        .requestMatchers("/inventory/wine").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/index").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/new").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/save").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/update").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/delete").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/saveNew").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/all").hasAnyRole("ADMIN", "USER")
                                    .requestMatchers("/").permitAll()
                                    .and().formLogin();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .userDetailsService(myUserDetailsService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
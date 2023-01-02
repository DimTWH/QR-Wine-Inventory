package com.QRwineinventory.qrWineInventory.configs;

import com.QRwineinventory.qrWineInventory.services.UserService;
import com.password4j.Hash;
import com.password4j.Password;
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

    private final UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
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
                                        .requestMatchers("/inventory/wine/save").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/new").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/update").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/delete").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/all").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/sell").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/sellWine").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/restock").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/inventory/wine/restockWine").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/user/profile").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                                    .requestMatchers("/user/register").permitAll()
                                    .requestMatchers("/user/registerUser").permitAll()
                                    .and().formLogin().and().csrf().disable();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .userDetailsService(userService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(withDefaults())
                .build();
    }

// ====================     Password hashing with BCRYPT     ==================

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

// ====================     Password hashing with PASSWORD4J     ==================
//    @Bean
//    String passwordEncoder(String pass) {
//        return Password.hash(pass)
//                .addPepper("QR-WineInv")
//                .addRandomSalt(32)
//                .withArgon2().getResult();
//    }
}
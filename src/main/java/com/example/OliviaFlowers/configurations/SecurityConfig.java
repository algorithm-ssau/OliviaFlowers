package com.example.OliviaFlowers.configurations;

import com.example.OliviaFlowers.secvices.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;

    }



    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/catalog/**", "/registration", "logotip2.png",
                                "inst.png", "vk.png", "/bouquet/**", "/images/**", "requestMatchers",
                                 "/bouquet_delete/**", "/add_bouquets_to_homepage", "/find_bouquet_by_name",
                                "icon_logo.png", "/catalogPostcard", "/lookAll", "/authorBouquet", "/boxBouquet",
                                "/weddingBouquet", "/filterBouquets", "/login.jpg", "/registration.jpg", "/activate/*")
                        .permitAll()
                        .anyRequest().authenticated()
                )


                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/profile")
                        .failureUrl("/login_not_success")
                        .successHandler(new CustomAuthenticationSuccessHandler())
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());


        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

}

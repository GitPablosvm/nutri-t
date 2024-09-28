package com.example.Nutrit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Desactivar CSRF (solo para pruebas)
                /*.authorizeRequests();
                .antMatchers(HttpMethod.GET, "/api/usuarios").permitAll() // Permitir acceso sin autenticación
                .antMatchers(HttpMethod.POST, "/api/usuarios").permitAll() // Permitir registro de usuarios
                .antMatchers(HttpMethod.DELETE, "/api/usuarios/**").permitAll() // Permitir eliminación de usuarios
                .anyRequest().authenticated(); // Requiere autenticación para cualquier otra solicitud*/

        return http.build();
    }
}

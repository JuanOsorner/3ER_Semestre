package com.example.familia_api.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilitar CSRF ya que es una API REST sin estado
                .csrf(csrf -> csrf.disable())
                // Definir la política de sesión como SIN ESTADO (STATELESS)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Definir las reglas de autorización para las peticiones HTTP
                .authorizeHttpRequests(auth -> auth
                        // Permitir acceso PÚBLICO a los endpoints de registro y verificación de correo
                        .requestMatchers(HttpMethod.POST, "/familiares/registro").permitAll()
                        .requestMatchers(HttpMethod.GET, "/familiares/correo/**").permitAll()
                        // Requerir autenticación para CUALQUIER OTRA petición
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
package project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration class responsible for setting up the security policies of the application.
 * It defines the access rules for endpoints, JWT filter integration, and password encryption.
 */
@Configuration
public class SecurityConfig {

    /**
     * Configures the HTTP security filter chain.
     *
     * - Disables CSRF protection (as JWT is used).
     * - Sets the session management policy to stateless.
     * - Defines access rules based on user roles and authentication.
     * - Adds the custom JWT authentication filter before Spring's default authentication filter.
     *
     * @param http the HttpSecurity object used to configure web-based security
     * @param jwtFilter the custom JWT authentication filter
     * @return the configured SecurityFilterChain
     * @throws Exception if any error occurs during configuration
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll() // new -> enable access to the H2 console
                .requestMatchers("/rooms/**").hasRole("ADMIN")
                .requestMatchers("/users/**").hasRole("ADMIN")
                .requestMatchers("/bookings/**").authenticated()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    } 
    
    /**
     * Registers a password encoder bean using BCrypt hashing algorithm.
     *
     * @return a PasswordEncoder instance using BCrypt
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

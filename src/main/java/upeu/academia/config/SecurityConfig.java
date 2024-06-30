package upeu.academia.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import upeu.academia.jwt.JwtAuthenticationFilter;

/**
 * Configuración de seguridad para la aplicación.
 *
 * @author Miguel Gonzales
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    /**
     * Configura la cadena de filtros de seguridad.
     *
     * @param http Objeto HttpSecurity para configurar la seguridad.
     * @return Cadena de filtros de seguridad configurada.
     * @throws Exception Si ocurre algún error durante la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(authorizationRequest
                -> authorizationRequest
                        // Permitir acceso a las rutas de autenticación
                        .requestMatchers("/auth/**").permitAll()
                        // Requerir autenticación para cualquier otra solicitud
                        .anyRequest().authenticated()
        );

        http.sessionManagement(sessionManager
                -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        // Proveedor de autenticación
        http.authenticationProvider(authProvider);

        // Agregar filtro JWT antes del filtro de autenticación de usuario/contraseña
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // Construir y devolver la cadena de filtros
        return http.build();
    }
}

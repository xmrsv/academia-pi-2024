package upeu.academia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configura las reglas de acceso CORS para la API REST.
 *
 * @author Miguel Gonzales
 *
 * Permite que solicitudes desde cualquier origen puedan acceder a la API
 * utilizando los métodos HTTP más comunes. Esta configuración es insegura, pero
 * me soluciona el error :)
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}

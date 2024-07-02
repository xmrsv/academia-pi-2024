package upeu.academia.auth;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Miguel Gonzales
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "El nombre de usuario es requerido")
    @Size(min = 3, max = 16, message = "El nombre de usuario debe tener entre 3 y 16 caracteres")
    String username;

    @Min(value = 3, message = "La contraseña debe tener al menos 3 caracteres")
    @NotBlank(message = "La contraseña es requerida")
    String password;

}

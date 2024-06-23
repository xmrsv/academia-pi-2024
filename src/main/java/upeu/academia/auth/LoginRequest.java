package upeu.academia.auth;

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
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    String username;
    String password;

}

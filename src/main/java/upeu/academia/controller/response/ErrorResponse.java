package upeu.academia.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Miguel Gonzales
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String field;
    private String message;
}

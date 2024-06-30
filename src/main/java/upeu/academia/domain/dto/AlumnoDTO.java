package upeu.academia.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Miguel Gonzales
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {

    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String fechaNacimiento;
    private String telefono;
    private Integer estado;

}

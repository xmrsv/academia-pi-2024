package upeu.academia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "alumnos")
@SQLDelete(sql = "UPDATE alumnos SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private Date fechaNacimiento;
    private String telefono;

    @Column(name = "fechaRegistro", nullable = false, updatable = false)
    private Timestamp fechaRegistro;     // Fecha de registro

    private Integer estado;     // 1 activo, 0 eliminado 

    // Método para evitar que fechaRegistro se actualice accidentalmente
    public void setFechaRegistro(Timestamp fechaRegistro) {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = fechaRegistro;
        }
    }

}

package upeu.academia.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;
    private String telefono;

    @Column(name = "fechaRegistro", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;     // Fecha de registro

    private Integer estado;

    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }

        if (this.estado == null) {
            this.estado = 1;
        }
    }

}

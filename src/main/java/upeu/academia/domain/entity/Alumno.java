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

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false, name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(nullable = false, name = "apellido_materno")
    private String apellidoMaterno;

    private String correo;

    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;

    private String telefono;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
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

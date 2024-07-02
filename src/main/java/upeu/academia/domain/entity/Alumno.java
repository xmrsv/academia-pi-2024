package upeu.academia.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "alumno")
@SQLDelete(sql = "UPDATE alumno SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    private String dni;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @Column(nullable = false, name = "apellido_paterno")
    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apellidoPaterno;

    @Column(nullable = false, name = "apellido_materno")
    @NotBlank(message = "El apellido materno es obligatorio")
    private String apellidoMaterno;

    @Email(message = "El correo electrónico no tiene un formato válido")
    private String correo;

    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @Pattern(regexp = "\\d{9}", message = "El teléfono debe tener 9 dígitos")
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
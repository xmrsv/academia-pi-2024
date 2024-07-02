package upeu.academia.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "entrenador")
@SQLDelete(sql = "UPDATE entrenador SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El DNI es obligatorio.")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos.")
    @Column(unique = true, nullable = false)
    private String dni;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    @Column(nullable = false)
    private String nombres;

    @NotBlank(message = "El apellido paterno es obligatorio.")
    @Size(min = 3, max = 50, message = "El apellido paterno debe tener entre 3 y 50 caracteres.")
    @Column(nullable = false, name = "apellido_paterno")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio.")
    @Size(min = 3, max = 50, message = "El apellido materno debe tener entre 3 y 50 caracteres.")
    @Column(nullable = false, name = "apellido_materno")
    private String apellidoMaterno;

    @NotBlank(message = "El correo es obligatorio.")
    @Size(min = 3, max = 50, message = "El correo debe tener entre 3 y 50 caracteres.")
    @Email(message = "El correo no es válido.")
    @Column(nullable = false)
    private String correo;


    @NotBlank(message = "El telefono es obligatorio.")
    @Size(min = 9, max = 9, message = "El telefono debe tener 9 dígitos.")
    @Column(nullable = false)
    private String telefono;

    @NotBlank(message = "La direccion es obligatoria.")
    @Size(min = 3, max = 50, message = "La direccion debe tener entre 3 y 50 caracteres.")
    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private Integer estado;

    @Column(nullable = false, updatable = false, name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToMany
    @JoinTable(
            name = "entrenador_disciplina", // nombre de la tabla intermedia que se utilizará para almacenar la relación muchos a muchos.
            joinColumns = @JoinColumn(name = "entrenador_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas;

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

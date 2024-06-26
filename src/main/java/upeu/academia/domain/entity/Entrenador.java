package upeu.academia.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "entrenadores")
@SQLDelete(sql = "UPDATE entrenadores SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Entrenador {

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

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private Integer estado;

    @Column(nullable = false, updatable = false, name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToMany
    @JoinTable(
            name = "entrenador_disciplinas", // nombre de la tabla intermedia que se utilizará para almacenar la relación muchos a muchos.
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

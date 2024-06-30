package upeu.academia.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "inscripcion")
@SQLDelete(sql = "UPDATE inscripcion SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "alumno_id")
    private Integer alumnoId;

    @Column(nullable = false, name = "responsable_id")
    private Integer responsableId;

    @Column(name = "fecha_inscripcion", nullable = false, updatable = false)
    private LocalDateTime fechaInscripcion;

    @Column(nullable = false)
    private Integer estado;

    @Column(nullable = false)
    private Integer disciplinaId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {

        if (this.fechaInscripcion == null) {
            this.fechaInscripcion = LocalDateTime.now();
        }

        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }

        if (this.estado == null) {
            this.estado = 1;
        }
    }
}

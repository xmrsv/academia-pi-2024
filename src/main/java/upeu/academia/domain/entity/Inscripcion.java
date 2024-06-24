package upeu.academia.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "inscripciones")
@SQLDelete(sql = "UPDATE inscripciones SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer alumnoId;
    private Integer responsableId;

    @Column(name = "fecha_inscripcion", nullable = false, updatable = false)
    private LocalDateTime fechaInscripcion;

    private Integer estado;
    private Integer disciplinaId;
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

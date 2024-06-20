package upeu.academia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "inscripciones")
@SQLDelete(sql = "UPDATE inscripciones SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer alumnoID;
    private Integer responsableID;

    @Column(name = "fecha_inscripcion", nullable = false, updatable = false)
    private Timestamp fecha_inscripcion;

    private Integer estado;
    private String estadoDisciplina;
    private Integer disciplinaID;

    // Método para evitar que fechaRegistro se actualice accidentalmente
    public void setFechaRegistro(Timestamp fecha_inscripcion) {
        if (this.fecha_inscripcion == null) {
            this.fecha_inscripcion = fecha_inscripcion;
        }
    }

}

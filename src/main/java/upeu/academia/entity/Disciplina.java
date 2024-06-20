package upeu.academia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "disciplinas")
@SQLDelete(sql = "UPDATE disciplinas SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Timestamp fecha_creacion;
    private BigDecimal costo;
    private Integer estado;

    @PrePersist
    protected void onCreate() {
        if (fecha_creacion == null) {
            fecha_creacion = Timestamp.from(Instant.now());
        }
    }

}

package upeu.academia.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Carlos Omar
 */
@Data
@Entity
@Table(name = "disciplina")
@SQLDelete(sql = "UPDATE disciplina SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Column(nullable = false)
    private String nombre;

    @DecimalMin(value = "0.01", message = "El costo debe ser mayor a 0.01")
    @Column(nullable = false)
    private BigDecimal costo;

    @Column(nullable = false, updatable = false, name = "fecha_creacion")
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

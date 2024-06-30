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
@Table(name = "responsable")
@SQLDelete(sql = "UPDATE responsable SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Responsable {

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
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false, name = "fecha_creacion")
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

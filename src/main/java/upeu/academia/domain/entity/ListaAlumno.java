package upeu.academia.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author Jerika Reyna
 */
@Data
@Entity
@Table(name = "lista_alumno")
@SQLDelete(sql = "UPDATE lista_alumno SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class ListaAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Alumno> alumnos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    @Column(nullable = false, name = "disciplinia_id")
    private Integer disciplinaId;

    @Column(nullable = false, name = "horario_id")
    private Integer horarioId;

    @OneToOne(cascade = CascadeType.ALL)
    private Disciplina disciplina;

    private Integer estado;

    @Column(nullable = false, name = "instalacion_id")
    private Integer instalacionId;

    @Column(nullable = false, name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Asistencia asistencia;

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

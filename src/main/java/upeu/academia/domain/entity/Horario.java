package upeu.academia.domain.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author CARLOS OMAR
 */

@Getter
@Setter
@Entity
@Table(name = "horarios")
@SQLDelete(sql = "UPDATE horarios SET estado=0 WHERE id=?")
@Where(clause = "estado= 1")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina_id;

    @ManyToOne
    @JoinColumn(name = "categorias_id", nullable = false)
    private Categoria categorias_id;

    @ManyToOne
    @JoinColumn(name = "entrenador_id", nullable = false)
    private Entrenador entrenador_id;

    private String dias;

    private LocalTime hora_inicio;

    private LocalTime hora_fin;

    private Integer limite_estudiantes;

    private Integer estado;

}
package upeu.academia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private String direccion;
    private Integer estado;

    @ManyToMany
    @JoinTable(
            name = "entrenador_disciplinas", // nombre de la tabla intermedia que se utilizará para almacenar la relación muchos a muchos.
            joinColumns = @JoinColumn(name = "entrenador_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas;

}

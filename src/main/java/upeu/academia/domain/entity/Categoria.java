package upeu.academia.domain.entity;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
@SQLDelete(sql = "UPDATE categoria SET estado=0 WHERE id=?")
@Where(clause = "estado=1")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer edad_minima;
    private Integer edad_maxima;
    private Integer estado;

}

package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.Alumno;

/**
 *
 * @author Carlos Omar
 */
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {

    Boolean existsByDni(String dni); // Verificar si existe el DNI, para validaciones

}

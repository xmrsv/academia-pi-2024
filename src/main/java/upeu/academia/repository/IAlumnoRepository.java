package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.Alumno;

/**
 *
 * @author Carlos Omar
 */
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {

}

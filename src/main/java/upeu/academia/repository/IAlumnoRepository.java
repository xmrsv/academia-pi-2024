package upeu.academia.repository;

import upeu.academia.domain.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carlos Omar
 */
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {

}

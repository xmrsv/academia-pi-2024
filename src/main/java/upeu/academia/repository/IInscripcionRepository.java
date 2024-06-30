package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.Inscripcion;

/**
 *
 * @author Carlos Omar
 */
public interface IInscripcionRepository extends JpaRepository<Inscripcion, Integer> {

}

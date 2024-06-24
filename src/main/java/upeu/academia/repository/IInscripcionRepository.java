package upeu.academia.repository;

import upeu.academia.domain.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carlos Omar
 */
public interface IInscripcionRepository extends JpaRepository<Inscripcion, Integer> {

}

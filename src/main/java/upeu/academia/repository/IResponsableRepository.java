package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.Responsable;

/**
 *
 * @author Carlos Omar
 */
public interface IResponsableRepository extends JpaRepository<Responsable, Integer> {

}

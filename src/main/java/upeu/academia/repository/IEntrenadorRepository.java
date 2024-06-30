package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.Entrenador;

/**
 *
 * @author Carlos Omar
 */
public interface IEntrenadorRepository extends JpaRepository<Entrenador, Integer> {

}

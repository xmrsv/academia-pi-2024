package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.Entrenador;

/**
 *
 * @author Carlos Omar
 */
public interface IEntrenadorRepository extends JpaRepository<Entrenador, Integer> {

    Boolean existsByDni(String dni); // Verificar si existe el DNI, para validaciones

}

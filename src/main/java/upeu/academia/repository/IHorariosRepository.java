package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upeu.academia.domain.entity.Horario;

/**
 * 
 * @author Carlos Omar
 */
public interface IHorariosRepository extends JpaRepository<Horario, Integer> {

}
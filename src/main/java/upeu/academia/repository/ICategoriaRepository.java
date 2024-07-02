package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upeu.academia.domain.entity.Categoria;

/**
 * 
 * @author Carlos Omar
 */
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}

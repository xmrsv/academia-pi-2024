package upeu.academia.service;

import java.util.List;
import java.util.Optional;

import upeu.academia.domain.entity.Categoria;

/**
 * 
 * @author Carlos Omar
 */
public interface ICategoriaService {
    List<Categoria> listarTodos();

    Optional<Categoria> obtenerPorId(Integer caregoriaId);

    void crear(Categoria categoria);

    void actualizar(Categoria categoria);

    void eliminarPorId(Integer categoriaId);
}

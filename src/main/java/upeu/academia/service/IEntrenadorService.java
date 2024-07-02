package upeu.academia.service;

import upeu.academia.domain.entity.Entrenador;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IEntrenadorService {

    List<Entrenador> listarTodos();

    Optional<Entrenador> obtenerPorId(Integer entrenadorId);

    Entrenador crear(Entrenador entrenador);

    Entrenador actualizar(Integer id, Entrenador entrenador);

    void eliminarPorId(Integer entrenadorId);
}

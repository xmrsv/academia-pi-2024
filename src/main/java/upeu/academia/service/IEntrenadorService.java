package upeu.academia.service;

import upeu.academia.entity.Entrenador;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IEntrenadorService {

    List<Entrenador> buscarTodos();

    void guardar(Entrenador entrenador);

    void editar(Entrenador entrenador);

    Optional<Entrenador> buscarPorId(Integer entrenadorId);

    void eliminarPorId(Integer entrenador);

}

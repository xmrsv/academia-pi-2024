package upeu.academia.service;

import upeu.academia.entity.Inscripcion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IInscripcionService {

    List<Inscripcion> buscarTodos();

    void guardar(Inscripcion inscripcion);

    void editar(Inscripcion inscripcion);

    Optional<Inscripcion> buscarPorId(Integer inscripcionId);

    void eliminarPorId(Integer inscripcionId);

}

package upeu.academia.service;

import upeu.academia.entity.Inscripcion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IInscripcionService {

    List<Inscripcion> listarTodos();

    Optional<Inscripcion> obtenerPorId(Integer inscripcionId);

    void crear(Inscripcion inscripcion);

    void actualizar(Inscripcion inscripcion);

    void eliminarPorId(Integer inscripcionId);

}

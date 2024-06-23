package upeu.academia.service;

import upeu.academia.entity.Alumno;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IAlumnoService {

    List<Alumno> listarTodos();

    Optional<Alumno> obtenerPorId(Integer alumnoId);

    void crear(Alumno alumno);

    void actualizar(Alumno alumno);

    void eliminarPorId(Integer alumnoId);

}

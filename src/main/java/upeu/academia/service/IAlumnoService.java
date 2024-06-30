package upeu.academia.service;

import upeu.academia.domain.entity.Alumno;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IAlumnoService {

    List<Alumno> listarTodos();

    Optional<Alumno> obtenerPorId(Integer alumnoId);

    Alumno crear(Alumno alumno);

    Alumno actualizar(Alumno alumno);

    void eliminarPorId(Integer alumnoId) throws Exception;

}

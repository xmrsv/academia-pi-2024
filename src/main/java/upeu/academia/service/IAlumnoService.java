package upeu.academia.service;

import upeu.academia.entity.Alumno;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IAlumnoService {

    List<Alumno> buscarTodos();

    void guardar(Alumno alumno);

    void editar(Alumno alumno);

    Optional<Alumno> buscarPorId(Integer alumnoId);

    void eliminarPorId(Integer alumnoId);

}

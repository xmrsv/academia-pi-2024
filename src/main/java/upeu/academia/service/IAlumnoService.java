package upeu.academia.service;

import upeu.academia.domain.entity.Alumno;

import java.util.List;

/**
 *
 * @author Carlos Omar
 */
public interface IAlumnoService {

    List<Alumno> listarTodos();

    Alumno obtenerPorId(Integer alumnoId);

    Alumno crear(Alumno alumno);

    Alumno actualizar(Integer id, Alumno alumno);

    void eliminarPorId(Integer alumnoId); // Eliminamos 'throws Exception'
}
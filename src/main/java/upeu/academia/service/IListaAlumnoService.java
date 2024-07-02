package upeu.academia.service;

import upeu.academia.domain.entity.ListaAlumno;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Jerika Reyna
 */
public interface IListaAlumnoService {

    List<ListaAlumno> listarTodos();

    Optional<ListaAlumno> obtenerPorId(Integer listaAlumnoId);

    void crear(ListaAlumno listaAlumno);

    void actualizar(ListaAlumno listaAlumno);
}

package upeu.academia.service;

import java.util.List;
import java.util.Optional;

import upeu.academia.domain.entity.ListaAlumno;

public interface IListaAlumnoService {

    List<ListaAlumno> listarTodos();

    Optional<ListaAlumno> obtenerPorId(Integer listaAlumnoId);

    void crear(ListaAlumno listaAlumno);

    void actualizar(ListaAlumno listaAlumno);
}

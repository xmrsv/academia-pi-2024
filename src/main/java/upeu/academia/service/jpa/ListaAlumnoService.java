package upeu.academia.service.jpa;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.ListaAlumno;
import upeu.academia.repository.IListaAlumnoRepository;
import upeu.academia.service.IListaAlumnoService;

import java.util.List;
import java.util.Optional;


/**
 * 
 * @author Jerika Reyna
 */
@Service
@RequiredArgsConstructor
public class ListaAlumnoService implements IListaAlumnoService {

    private final IListaAlumnoRepository listaAlumnoRepository;

    @Override
    public void actualizar(ListaAlumno listaAlumno) {
        listaAlumnoRepository.save(listaAlumno);
    }

    @Override
    public void crear(ListaAlumno listaAlumno) {
        listaAlumnoRepository.save(listaAlumno);
    }

    @Override
    public List<ListaAlumno> listarTodos() {
        return listaAlumnoRepository.findAll();
    }

    @Override
    public Optional<ListaAlumno> obtenerPorId(Integer listaAlumnoId) {
        return listaAlumnoRepository.findById(listaAlumnoId);
    }

}

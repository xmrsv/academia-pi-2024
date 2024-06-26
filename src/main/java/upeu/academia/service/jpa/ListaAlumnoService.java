package upeu.academia.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.academia.domain.entity.ListaAlumno;
import upeu.academia.repository.IListaAlumnoRepository;
import upeu.academia.service.IListaAlumnoService;

@Service
public class ListaAlumnoService implements IListaAlumnoService {
    @Autowired
    private IListaAlumnoRepository listaAlumnoRepository;

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

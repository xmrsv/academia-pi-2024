package upeu.academia.service.jpa;

import upeu.academia.entity.Inscripcion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.service.IInscripcionService;
import upeu.academia.repository.IInscripcionRepository;

/**
 *
 * @author Carlos Omar
 */
@Service
public class InscripcionService implements IInscripcionService {

    @Autowired
    private IInscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> buscarTodos() {
        return inscripcionRepository.findAll();
    }

    @Override
    public void guardar(Inscripcion inscripciones) {
        inscripcionRepository.save(inscripciones);
    }

    @Override
    public void editar(Inscripcion inscripciones) {
        inscripcionRepository.save(inscripciones);
    }

    @Override
    public Optional<Inscripcion> buscarPorId(Integer id) {
        return inscripcionRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        inscripcionRepository.deleteById(id);
    }

}

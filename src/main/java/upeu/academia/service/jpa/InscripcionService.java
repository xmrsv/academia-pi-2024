package upeu.academia.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.domain.entity.Inscripcion;
import upeu.academia.repository.IInscripcionRepository;
import upeu.academia.service.IInscripcionService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@Service
public class InscripcionService implements IInscripcionService {

    @Autowired
    private IInscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> listarTodos() {
        return inscripcionRepository.findAll();
    }

    @Override
    public void crear(Inscripcion inscripcion) {
        inscripcionRepository.save(inscripcion);
    }

    @Override
    public void actualizar(Inscripcion inscripcion) {
        inscripcionRepository.save(inscripcion);
    }

    @Override
    public Optional<Inscripcion> obtenerPorId(Integer inscripcionId) {
        return inscripcionRepository.findById(inscripcionId);
    }

    @Override
    public void eliminarPorId(Integer inscripcionId) {
        inscripcionRepository.deleteById(inscripcionId);
    }

}

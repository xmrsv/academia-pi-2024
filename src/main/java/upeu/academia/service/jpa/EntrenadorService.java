package upeu.academia.service.jpa;

import upeu.academia.domain.entity.Entrenador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.service.IEntrenadorService;
import upeu.academia.repository.IEntrenadorRepository;

/**
 *
 * @author Carlos Omar
 */
@Service
public class EntrenadorService implements IEntrenadorService {

    @Autowired
    private IEntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> listarTodos() {
        return entrenadorRepository.findAll();
    }

    @Override
    public void crear(Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
    }

    @Override
    public void actualizar(Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
    }

    @Override
    public Optional<Entrenador> obtenerPorId(Integer entrenadorId) {
        return entrenadorRepository.findById(entrenadorId);
    }

    @Override
    public void eliminarPorId(Integer entrenadorId) {
        entrenadorRepository.deleteById(entrenadorId);
    }

}

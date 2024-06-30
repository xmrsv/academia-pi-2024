package upeu.academia.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.domain.entity.Entrenador;
import upeu.academia.repository.IEntrenadorRepository;
import upeu.academia.service.IEntrenadorService;

import java.util.List;
import java.util.Optional;

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

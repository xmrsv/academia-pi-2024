package upeu.academia.service.jpa;

import upeu.academia.entity.Entrenador;
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
    public List<Entrenador> buscarTodos() {
        return entrenadorRepository.findAll();
    }

    @Override
    public void guardar(Entrenador entrenadores) {
        entrenadorRepository.save(entrenadores);
    }

    @Override
    public void editar(Entrenador entrenadores) {
        entrenadorRepository.save(entrenadores);
    }

    @Override
    public Optional<Entrenador> buscarPorId(Integer id) {
        return entrenadorRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        entrenadorRepository.deleteById(id);
    }

}

package upeu.academia.service.jpa;

import upeu.academia.entity.Disciplina;
import upeu.academia.repository.IDisciplinaRepository;
import upeu.academia.service.IDisciplinaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Omar
 */
@Service
public class DisciplinaService implements IDisciplinaService {

    @Autowired
    private IDisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    @Override
    public void crear(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    @Override
    public void actualizar(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    @Override
    public Optional<Disciplina> obtenerPorId(Integer disciplinaId) {
        return disciplinaRepository.findById(disciplinaId);
    }

    @Override
    public void eliminarPorId(Integer disciplinaId) {
        disciplinaRepository.deleteById(disciplinaId);
    }

}

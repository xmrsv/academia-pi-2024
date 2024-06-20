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
    public List<Disciplina> buscarTodos() {
        return disciplinaRepository.findAll();
    }

    @Override
    public void guardar(Disciplina disciplinas) {
        disciplinaRepository.save(disciplinas);
    }

    @Override
    public void editar(Disciplina disciplinas) {
        disciplinaRepository.save(disciplinas);
    }

    @Override
    public Optional<Disciplina> buscarPorId(Integer id) {
        return disciplinaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        disciplinaRepository.deleteById(id);
    }

}

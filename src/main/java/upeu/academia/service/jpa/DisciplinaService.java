package upeu.academia.service.jpa;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.Disciplina;
import upeu.academia.repository.IDisciplinaRepository;
import upeu.academia.service.IDisciplinaService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@Service
@RequiredArgsConstructor
public class DisciplinaService implements IDisciplinaService {

    private final IDisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Disciplina crear(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina actualizar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
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

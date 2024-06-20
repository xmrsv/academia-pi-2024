package upeu.academia.service;

import upeu.academia.entity.Disciplina;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IDisciplinaService {

    List<Disciplina> buscarTodos();

    void guardar(Disciplina disciplina);

    void editar(Disciplina disciplina);

    Optional<Disciplina> buscarPorId(Integer disciplinaId);

    void eliminarPorId(Integer disciplinaId);

}

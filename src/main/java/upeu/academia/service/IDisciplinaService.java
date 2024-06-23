package upeu.academia.service;

import upeu.academia.entity.Disciplina;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IDisciplinaService {

    List<Disciplina> listarTodos();

    Optional<Disciplina> obtenerPorId(Integer disciplinaId);

    void crear(Disciplina disciplina);

    void actualizar(Disciplina disciplina);

    void eliminarPorId(Integer disciplinaId);

}

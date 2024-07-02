package upeu.academia.service;

import upeu.academia.domain.entity.Disciplina;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IDisciplinaService {

    List<Disciplina> listarTodos();

    Optional<Disciplina> obtenerPorId(Integer disciplinaId);

    Disciplina crear(Disciplina disciplina);

    Disciplina actualizar(Disciplina disciplina);

    void eliminarPorId(Integer disciplinaId);

}

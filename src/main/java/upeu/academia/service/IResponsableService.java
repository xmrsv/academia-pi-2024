package upeu.academia.service;

import upeu.academia.entity.Responsable;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IResponsableService {

    List<Responsable> buscarTodos();

    void guardar(Responsable responsable);

    void editar(Responsable responsable);

    Optional<Responsable> buscarPorId(Integer responsableId);

    void eliminarPorId(Integer responsableId);

}

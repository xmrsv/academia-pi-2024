package upeu.academia.service;

import upeu.academia.domain.entity.Responsable;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
public interface IResponsableService {

    List<Responsable> listarTodos();

    Optional<Responsable> obtenerPorId(Integer responsableId);

    void crear(Responsable responsable);

    void actualizar(Responsable responsable);

    void eliminarPorId(Integer responsableId);

}

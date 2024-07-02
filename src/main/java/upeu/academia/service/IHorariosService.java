package upeu.academia.service;

import java.util.List;
import java.util.Optional;

import upeu.academia.domain.entity.Horario;

/**
 * 
 * @author Carlos Omar
 */
public interface IHorariosService {
    List<Horario> buscarTodos();

    void guardar(Horario horarios);

    void modificar(Horario horarios);

    Optional<Horario> buscarId(Integer id);

    void eliminarPorId(Integer id);
}

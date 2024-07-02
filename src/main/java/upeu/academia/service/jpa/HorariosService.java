package upeu.academia.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.Horario;
import upeu.academia.repository.IHorariosRepository;
import upeu.academia.service.IHorariosService;

/**
 * 
 * @author Carlos Omar
 */
@Service
@RequiredArgsConstructor
public class HorariosService implements IHorariosService {

    private final IHorariosRepository horariosRepository;

    @Override
    public List<Horario> buscarTodos() {
        return horariosRepository.findAll();
    }

    @Override
    public void guardar(Horario horarios) {
        horariosRepository.save(horarios);
    }

    @Override
    public void modificar(Horario horarios) {
        horariosRepository.save(horarios);
    }

    @Override
    public Optional<Horario> buscarId(Integer id) {
        return horariosRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        horariosRepository.deleteById(id);
    }

}
package upeu.academia.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.domain.entity.Responsable;
import upeu.academia.repository.IResponsableRepository;
import upeu.academia.service.IResponsableService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@Service
public class ResponsableService implements IResponsableService {

    @Autowired
    private IResponsableRepository responsableRepository;

    @Override
    public List<Responsable> listarTodos() {
        return responsableRepository.findAll();
    }

    @Override
    public Responsable crear(Responsable responsable) {
        return responsableRepository.save(responsable);
    }

    @Override
    public void actualizar(Responsable responsable) {
        responsableRepository.save(responsable);
    }

    @Override
    public Optional<Responsable> obtenerPorId(Integer responsableId) {
        return responsableRepository.findById(responsableId);
    }

    @Override
    public void eliminarPorId(Integer responsableId) {
        responsableRepository.deleteById(responsableId);
    }

}

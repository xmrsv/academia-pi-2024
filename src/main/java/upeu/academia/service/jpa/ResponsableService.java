package upeu.academia.service.jpa;

import upeu.academia.entity.Responsable;
import upeu.academia.repository.IResponsableRepository;
import upeu.academia.service.IResponsableService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Omar
 */
@Service
public class ResponsableService implements IResponsableService {

    @Autowired
    private IResponsableRepository responsableRepository;

    @Override
    public List<Responsable> buscarTodos() {
        return responsableRepository.findAll();
    }

    @Override
    public void guardar(Responsable responsable) {
        responsableRepository.save(responsable);
    }

    @Override
    public void editar(Responsable responsable) {
        responsableRepository.save(responsable);
    }

    @Override
    public Optional<Responsable> buscarPorId(Integer id) {
        return responsableRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        responsableRepository.deleteById(id);
    }

}

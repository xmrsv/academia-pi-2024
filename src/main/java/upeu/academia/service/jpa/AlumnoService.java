package upeu.academia.service.jpa;

import upeu.academia.entity.Alumno;
import upeu.academia.service.IAlumnoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.repository.IAlumnoRepository;

/**
 *
 * @author Carlos Omar
 */
@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }

    @Override
    public void crear(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public void actualizar(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public Optional<Alumno> obtenerPorId(Integer alumnoId) {
        return alumnoRepository.findById(alumnoId);
    }

    @Override
    public void eliminarPorId(Integer alumnoId) {
        alumnoRepository.deleteById(alumnoId);
    }

}

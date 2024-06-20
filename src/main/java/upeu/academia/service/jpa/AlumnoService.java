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
    public List<Alumno> buscarTodos() {
        return alumnoRepository.findAll();
    }

    @Override
    public void guardar(Alumno alumnos) {
        alumnoRepository.save(alumnos);
    }

    @Override
    public void editar(Alumno alumnos) {
        alumnoRepository.save(alumnos);
    }

    @Override
    public Optional<Alumno> buscarPorId(Integer id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        alumnoRepository.deleteById(id);
    }

}

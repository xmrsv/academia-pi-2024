package upeu.academia.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.domain.entity.Alumno;
import upeu.academia.repository.IAlumnoRepository;
import upeu.academia.service.IAlumnoService;

import java.util.List;
import java.util.Optional;

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
    public Alumno crear(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno actualizar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Optional<Alumno> obtenerPorId(Integer alumnoId) {
        return alumnoRepository.findById(alumnoId);
    }

    @Override
    public void eliminarPorId(Integer alumnoId) throws Exception {

        if (!alumnoRepository.existsById(alumnoId)) {
            throw new Exception("usuario no encontrado");
        }
        alumnoRepository.deleteById(alumnoId);
    }

}

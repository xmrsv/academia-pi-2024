package upeu.academia.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.domain.entity.Alumno;
import upeu.academia.repository.IAlumnoRepository;
import upeu.academia.service.IAlumnoService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
        if (alumnoRepository.existsByDni(alumno.getDni())) {
            throw new IllegalArgumentException("Ya existe un alumno con el DNI: " + alumno.getDni());
        }
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno actualizar(Integer id, Alumno alumno) {
        if (!Objects.equals(id, alumno.getId())) {
            throw new IllegalArgumentException("El ID del alumno en la ruta y en el cuerpo de la solicitud no coinciden");
        }
        Alumno alumnoExistente = obtenerPorId(id);
        // Actualiza los campos del alumnoExistente con los valores de alumno
        alumnoExistente.setNombres(alumno.getNombres());
        alumnoExistente.setApellidoPaterno(alumno.getApellidoPaterno());
        alumnoExistente.setApellidoMaterno(alumno.getApellidoMaterno());
        alumnoExistente.setCorreo(alumno.getCorreo());
        alumnoExistente.setFechaNacimiento(alumno.getFechaNacimiento());
        alumnoExistente.setTelefono(alumno.getTelefono());
        return alumnoRepository.save(alumnoExistente);
    }

    @Override
    public Alumno obtenerPorId(Integer alumnoId) {
        return alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un alumno con el ID: " + alumnoId));
    }

    @Override
    public void eliminarPorId(Integer alumnoId) {  // Eliminamos 'throws Exception'
        if (!alumnoRepository.existsById(alumnoId)) {
            return; // O puedes manejar la excepción de otra manera
        }
        alumnoRepository.deleteById(alumnoId);
    }
}

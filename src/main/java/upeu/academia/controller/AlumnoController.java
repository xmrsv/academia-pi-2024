package upeu.academia.controller;

import java.util.ArrayList;
import upeu.academia.domain.entity.Alumno;
import upeu.academia.service.IAlumnoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Omar
 */
@RestController
@RequestMapping("api/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("")
    public ResponseEntity listarTodos() {
        List<Alumno> alumnos = alumnoService.listarTodos();

        if (alumnos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(alumnos);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id") Integer alumnoId) {
        Map<String, Object> response = new HashMap<>();
        Optional<Alumno> alumno = alumnoService.obtenerPorId(alumnoId);

        if (alumno.isPresent()) {
            return ResponseEntity.status(200).body(alumno.get());
        } else {
            response.put("message", "alumno con ID " + alumnoId + " no existe");
            return ResponseEntity.status(404).body(response);
        }
    }

    @PostMapping("")
    public ResponseEntity crear(@RequestBody Alumno nuevoAlumno) {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, String>> errors = new ArrayList<>();

        if (nuevoAlumno == null || (nuevoAlumno.getDni() == null || nuevoAlumno.getDni().isEmpty())
                && (nuevoAlumno.getNombres() == null || nuevoAlumno.getNombres().isEmpty())
                && (nuevoAlumno.getApellidoPaterno() == null || nuevoAlumno.getApellidoPaterno().isEmpty())
                && (nuevoAlumno.getApellidoMaterno() == null || nuevoAlumno.getApellidoMaterno().isEmpty())
                && (nuevoAlumno.getCorreo() == null || nuevoAlumno.getCorreo().isEmpty())
                && (nuevoAlumno.getFechaNacimiento() == null)
                && (nuevoAlumno.getTelefono() == null || nuevoAlumno.getTelefono().isEmpty())) {
            response.put("error", "no se enviaron datos válidos en la solicitud");
            return ResponseEntity.status(400).body(response);
        }

        if (nuevoAlumno.getDni() == null || nuevoAlumno.getDni().isEmpty() || !(nuevoAlumno.getDni().length() == 8) || !nuevoAlumno.getDni().matches("[0-9]+")) {
            errors.add(Map.of("field", "dni", "error", "El campo 'dni' es obligatorio y debe tener 8 dígitos"));
        }

        if (nuevoAlumno.getNombres() == null || nuevoAlumno.getNombres().isEmpty()) {
            errors.add(Map.of("field", "nombres", "error", "El campo 'nombres' es obligatorio"));
        }

        if (nuevoAlumno.getApellidoPaterno() == null || nuevoAlumno.getApellidoPaterno().isEmpty()) {
            errors.add(Map.of("field", "apellidoPaterno", "error", "El campo 'apellidoPaterno' es obligatorio"));
        }

        if (nuevoAlumno.getApellidoMaterno() == null || nuevoAlumno.getApellidoMaterno().isEmpty()) {
            errors.add(Map.of("field", "apellidoMaterno", "error", "El campo 'apellidoMaterno' es obligatorio"));
        }

        if (nuevoAlumno.getCorreo() == null || nuevoAlumno.getCorreo().isEmpty() || !nuevoAlumno.getCorreo().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.add(Map.of("field", "correo", "error", "El campo 'correo' es obligatorio y debe tener un formato válido"));
        }

        if (nuevoAlumno.getFechaNacimiento() == null) {
            errors.add(Map.of("field", "fechaNacimiento", "error", "El campo 'fechaNacimiento' es obligatorio"));
        }

        if (nuevoAlumno.getTelefono() == null || nuevoAlumno.getTelefono().isEmpty() || !(nuevoAlumno.getTelefono().length() == 9) || !nuevoAlumno.getTelefono().matches("[0-9]+")) {
            errors.add(Map.of("field", "telefono", "error", "El campo 'telefono' es obligatorio y debe tener 9 dígitos"));
        }

        if (!errors.isEmpty()) {
            response.put("errors", errors);
            return ResponseEntity.status(400).body(response);
        }

        return ResponseEntity.status(201).body(alumnoService.crear(nuevoAlumno));
    }

    @PutMapping("")
    public ResponseEntity actualizar(@RequestBody Alumno alumno) {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, String>> errors = new ArrayList<>();

        try {
            Optional<Alumno> alumnoExistente = alumnoService.obtenerPorId(alumno.getId());
            if (!alumnoExistente.isPresent()) {
                response.put("error", "El alumno no existe.");
                return ResponseEntity.status(404).body(response);
            }

            Alumno alumnoParaActualizar = alumnoExistente.get();

            if (alumno.getDni() != null && !(alumno.getDni().length() == 8) || (alumno.getDni() != null && !alumno.getDni().matches("[0-9]+"))) {
                errors.add(Map.of("field", "dni", "error", "El campo 'dni' debe tener 8 dígitos."));
            } else if (alumno.getDni() != null) {
                alumnoParaActualizar.setDni(alumno.getDni());
            }

            if (alumno.getNombres() != null) {
                alumnoParaActualizar.setNombres(alumno.getNombres());
            }

            if (alumno.getApellidoPaterno() != null) {
                alumnoParaActualizar.setApellidoPaterno(alumno.getApellidoPaterno());
            }

            if (alumno.getApellidoMaterno() != null) {
                alumnoParaActualizar.setApellidoMaterno(alumno.getApellidoMaterno());
            }

            if (alumno.getCorreo() != null && !alumno.getCorreo().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errors.add(Map.of("field", "correo", "error", "El campo 'correo' debe tener un formato válido."));
            } else if (alumno.getCorreo() != null) {
                alumnoParaActualizar.setCorreo(alumno.getCorreo());
            }

            if (alumno.getFechaNacimiento() != null) {
                alumnoParaActualizar.setFechaNacimiento(alumno.getFechaNacimiento());
            }

            if (alumno.getTelefono() != null && (!(alumno.getTelefono().length() == 9) || !alumno.getTelefono().matches("[0-9]+"))) {
                errors.add(Map.of("field", "telefono", "error", "El campo 'telefono' debe tener 9 dígitos."));
            } else if (alumno.getTelefono() != null) {
                alumnoParaActualizar.setTelefono(alumno.getTelefono());
            }

            if (!errors.isEmpty()) {
                response.put("errors", errors);
                return ResponseEntity.status(400).body(response);
            }

            return ResponseEntity.status(200).body(alumnoService.actualizar(alumnoParaActualizar));

        } catch (Exception e) {
            response.put("error", "Error al actualizar el alumno: " + e.getMessage());
            return ResponseEntity.status(400).body(response);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> eliminarPorId(@PathVariable("id") Integer alumnoId) {
        Map<String, Object> response = new HashMap<>();

        try {
            alumnoService.eliminarPorId(alumnoId);
            response.put("message", "alumno eliminado correctamente");
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            response.put("message", "error al eliminar alumno");
            response.put("error", e.getMessage());
            return ResponseEntity.status(400).body(response);
        }
    }
}

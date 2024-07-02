package upeu.academia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.academia.domain.entity.Alumno;
import upeu.academia.service.IAlumnoService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import upeu.academia.controller.responses.ErrorResponse;

@RestController
@RequestMapping("api/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> listarTodos() {
        List<Alumno> alumnos = alumnoService.listarTodos();
        return alumnos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(alumnos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable("id") Integer alumnoId) {
        try {
            Optional<Alumno> alumno = alumnoService.obtenerPorId(alumnoId);
            return ResponseEntity.ok(alumno.get());
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Alumno nuevoAlumno) {
        try {
            Alumno alumnoCreado = alumnoService.crear(nuevoAlumno);
            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Integer id, @Valid @RequestBody Alumno alumno) {
        try {
            Alumno alumnoActualizado = alumnoService.actualizar(id, alumno);
            return ResponseEntity.ok(alumnoActualizado);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer alumnoId) {
        try {
            alumnoService.eliminarPorId(alumnoId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

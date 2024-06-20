package upeu.academia.controller;

import upeu.academia.entity.Alumno;
import upeu.academia.service.IAlumnoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/apispring")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/alumnos")
    public List<Alumno> buscartodos() {
        return alumnoService.buscarTodos();
    }

    @PostMapping("/alumnos")
    public Alumno guardar(@RequestBody Alumno alumno) {
        alumnoService.guardar(alumno);
        return alumno;
    }

    @PutMapping("/alumnos")
    public Alumno editar(@RequestBody Alumno alumno) {
        alumnoService.editar(alumno);
        return alumno;
    }

    @DeleteMapping("/alumnos/{id}")
    public void eliminarPorId(@PathVariable("id") Integer alumnoId) {
        alumnoService.eliminarPorId(alumnoId);
    }

    @GetMapping("/alumnos/{id}")
    public Optional<Alumno> buscarPorId(@PathVariable("id") Integer alumnoId) {
        return alumnoService.buscarPorId(alumnoId);
    }
}

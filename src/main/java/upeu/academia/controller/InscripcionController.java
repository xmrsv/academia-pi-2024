package upeu.academia.controller;

import upeu.academia.entity.Inscripcion;
import upeu.academia.service.jpa.InscripcionService;
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
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("/inscripciones")
    public List<Inscripcion> buscartodos() {
        return inscripcionService.buscarTodos();
    }

    @PostMapping("/inscripciones")
    public Inscripcion guardar(@RequestBody Inscripcion inscripcion) {
        inscripcionService.guardar(inscripcion);
        return inscripcion;
    }

    @PutMapping("/inscripciones")
    public Inscripcion editar(@RequestBody Inscripcion inscripcion) {
        inscripcionService.editar(inscripcion);
        return inscripcion;
    }

    @DeleteMapping("/inscripciones/{id}")
    public void eliminarPorId(@PathVariable("id") Integer inscripcionId) {
        inscripcionService.eliminarPorId(inscripcionId);
    }

    @GetMapping("/inscripciones/{id}")
    public Optional<Inscripcion> buscarPorId(@PathVariable("id") Integer inscripcionId) {
        return inscripcionService.buscarPorId(inscripcionId);
    }
}

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
    public List<Inscripcion> listarTodos() {
        return inscripcionService.listarTodos();
    }

    @GetMapping("/inscripciones/{id}")
    public Optional<Inscripcion> obtenerPorId(@PathVariable("id") Integer inscripcionId) {
        return inscripcionService.obtenerPorId(inscripcionId);
    }

    @PostMapping("/inscripciones")
    public Inscripcion crear(@RequestBody Inscripcion inscripcion) {
        inscripcionService.crear(inscripcion);
        return inscripcion;
    }

    @PutMapping("/inscripciones")
    public Inscripcion actualizar(@RequestBody Inscripcion inscripcion) {
        inscripcionService.actualizar(inscripcion);
        return inscripcion;
    }

    @DeleteMapping("/inscripciones/{id}")
    public void eliminarPorId(@PathVariable("id") Integer inscripcionId) {
        inscripcionService.eliminarPorId(inscripcionId);
    }

}

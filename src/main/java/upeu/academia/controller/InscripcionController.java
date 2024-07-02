package upeu.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upeu.academia.domain.entity.Inscripcion;
import upeu.academia.service.jpa.InscripcionService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@RestController
@RequestMapping("api/v1/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<Inscripcion> listarTodos() {
        return inscripcionService.listarTodos();
    }

    @GetMapping("{id}")
    public Optional<Inscripcion> obtenerPorId(@PathVariable("id") Integer inscripcionId) {
        return inscripcionService.obtenerPorId(inscripcionId);
    }

    @PostMapping
    public Inscripcion crear(@RequestBody Inscripcion inscripcion) {
        inscripcionService.crear(inscripcion);
        return inscripcion;
    }

    @PutMapping
    public Inscripcion actualizar(@RequestBody Inscripcion inscripcion) {
        inscripcionService.actualizar(inscripcion);
        return inscripcion;
    }

    @DeleteMapping("{id}")
    public void eliminarPorId(@PathVariable("id") Integer inscripcionId) {
        inscripcionService.eliminarPorId(inscripcionId);
    }

}

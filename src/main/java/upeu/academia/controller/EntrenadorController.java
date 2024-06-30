package upeu.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upeu.academia.domain.entity.Entrenador;
import upeu.academia.service.IEntrenadorService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@RestController
@RequestMapping("api/entrenadores")
public class EntrenadorController {

    @Autowired
    private IEntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> listarTodos() {
        return entrenadorService.listarTodos();
    }

    @GetMapping("{id}")
    public Optional<Entrenador> obtenerPorId(@PathVariable("id") Integer entrenadorId) {
        return entrenadorService.obtenerPorId(entrenadorId);
    }

    @PostMapping
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        entrenadorService.crear(entrenador);
        return entrenador;
    }

    @PutMapping
    public Entrenador actualizar(@RequestBody Entrenador entrenador) {
        entrenadorService.actualizar(entrenador);
        return entrenador;
    }

    @DeleteMapping("{id}")
    public void eliminarPorId(@PathVariable("id") Integer entrenadorId) {
        entrenadorService.eliminarPorId(entrenadorId);
    }

}

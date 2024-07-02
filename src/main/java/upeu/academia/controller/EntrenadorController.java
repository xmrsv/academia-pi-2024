package upeu.academia.controller;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.Entrenador;
import upeu.academia.service.IEntrenadorService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@RestController
@RequestMapping("api/v2/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final IEntrenadorService entrenadorService;

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

    @PutMapping("{id}") // Agrega el ID a la ruta
    public Entrenador actualizar(@PathVariable("id") Integer id, @RequestBody Entrenador entrenador) {
        return entrenadorService.actualizar(id, entrenador); // Pasa el ID al método
    }

    @DeleteMapping("{id}")
    public void eliminarPorId(@PathVariable("id") Integer entrenadorId) {
        entrenadorService.eliminarPorId(entrenadorId);
    }

}
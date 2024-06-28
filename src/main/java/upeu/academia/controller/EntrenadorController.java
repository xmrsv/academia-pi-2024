package upeu.academia.controller;

import upeu.academia.domain.entity.Entrenador;
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
import upeu.academia.service.IEntrenadorService;

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

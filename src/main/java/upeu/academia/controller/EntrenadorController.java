package upeu.academia.controller;

import upeu.academia.entity.Entrenador;
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
@RequestMapping("/apispring")
public class EntrenadorController {

    @Autowired
    private IEntrenadorService entrenadorService;

    @GetMapping("/entrenadores")
    public List<Entrenador> buscartodos() {
        return entrenadorService.buscarTodos();
    }

    @PostMapping("/entrenadores")
    public Entrenador guardar(@RequestBody Entrenador entrenador) {
        entrenadorService.guardar(entrenador);
        return entrenador;
    }

    @PutMapping("/entrenadores")
    public Entrenador editar(@RequestBody Entrenador entrenador) {
        entrenadorService.editar(entrenador);
        return entrenador;
    }

    @DeleteMapping("/entrenadores/{id}")
    public void eliminarPorId(@PathVariable("id") Integer entrenadorId) {
        entrenadorService.eliminarPorId(entrenadorId);
    }

    @GetMapping("/entrenadores/{id}")
    public Optional<Entrenador> buscarPorId(@PathVariable("id") Integer entrenadorId) {
        return entrenadorService.buscarPorId(entrenadorId);
    }
}

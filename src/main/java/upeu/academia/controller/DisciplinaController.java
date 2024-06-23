package upeu.academia.controller;

import upeu.academia.entity.Disciplina;
import upeu.academia.service.IDisciplinaService;
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
public class DisciplinaController {

    @Autowired
    private IDisciplinaService disciplinaService;

    @GetMapping("/disciplinas")
    public List<Disciplina> listarTodos() {
        return disciplinaService.listarTodos();
    }

    @GetMapping("/disciplinas/{id}")
    public Optional<Disciplina> obtenerPorId(@PathVariable("id") Integer disciplinaId) {
        return disciplinaService.obtenerPorId(disciplinaId);
    }

    @PostMapping("/disciplinas")
    public Disciplina crear(@RequestBody Disciplina disciplina) {
        disciplinaService.crear(disciplina);
        return disciplina;
    }

    @PutMapping("/disciplinas")
    public Disciplina actualizar(@RequestBody Disciplina disciplina) {
        disciplinaService.actualizar(disciplina);
        return disciplina;
    }

    @DeleteMapping("/disciplinas/{id}")
    public void eliminarPorId(@PathVariable("id") Integer disciplinaId) {
        disciplinaService.eliminarPorId(disciplinaId);
    }

}

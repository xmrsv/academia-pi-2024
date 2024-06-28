package upeu.academia.controller;

import upeu.academia.domain.entity.Disciplina;
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
@RequestMapping("api/disciplinas")
public class DisciplinaController {

    @Autowired
    private IDisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listarTodos() {
        return disciplinaService.listarTodos();
    }

    @GetMapping("{id}")
    public Optional<Disciplina> obtenerPorId(@PathVariable("id") Integer disciplinaId) {
        return disciplinaService.obtenerPorId(disciplinaId);
    }

    @PostMapping
    public Disciplina crear(@RequestBody Disciplina disciplina) {
        disciplinaService.crear(disciplina);
        return disciplina;
    }

    @PutMapping
    public Disciplina actualizar(@RequestBody Disciplina disciplina) {
        disciplinaService.actualizar(disciplina);
        return disciplina;
    }

    @DeleteMapping("{id}")
    public void eliminarPorId(@PathVariable("id") Integer disciplinaId) {
        disciplinaService.eliminarPorId(disciplinaId);
    }

}

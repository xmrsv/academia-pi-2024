package upeu.academia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.Categoria;
import upeu.academia.service.jpa.CategoriaService;

@RestController
@RequestMapping("api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getById(@PathVariable Integer id) {
        return categoriaService.obtenerPorId(id);
    }

    @PostMapping
    public void create(@RequestBody Categoria categoria) {
        categoriaService.crear(categoria);
    }

    @PutMapping
    public void actualizar(@RequestBody Categoria categoria) {
        categoriaService.actualizar(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaService.eliminarPorId(id);
    }
}

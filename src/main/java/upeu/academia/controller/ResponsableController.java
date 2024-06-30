package upeu.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upeu.academia.domain.entity.Responsable;
import upeu.academia.service.IResponsableService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@RestController
@RequestMapping("api")
public class ResponsableController {

    @Autowired
    private IResponsableService responsableService;

    @GetMapping
    public List<Responsable> listarTodos() {
        return responsableService.listarTodos();
    }

    @GetMapping("{id}")
    public Optional<Responsable> obtenerPorId(@PathVariable("id") Integer responsableId) {
        return responsableService.obtenerPorId(responsableId);
    }

    @PostMapping
    public Responsable crear(@RequestBody Responsable responsable) {
        responsableService.crear(responsable);
        return responsable;
    }

    @PutMapping
    public Responsable actualizar(@RequestBody Responsable responsable) {
        responsableService.actualizar(responsable);
        return responsable;
    }

    @DeleteMapping("{id}")
    public void eliminarPorId(@PathVariable("id") Integer responsableId) {
        responsableService.eliminarPorId(responsableId);
    }

}

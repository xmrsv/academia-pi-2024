package upeu.academia.controller;

import upeu.academia.domain.entity.Responsable;
import upeu.academia.service.IResponsableService;
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

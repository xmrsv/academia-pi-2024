package upeu.academia.controller;

import upeu.academia.entity.Responsable;
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
@RequestMapping("/apispring")
public class ResponsableController {

    @Autowired
    private IResponsableService responsableService;

    @GetMapping("/responsable")
    public List<Responsable> listarTodos() {
        return responsableService.listarTodos();
    }

    @GetMapping("/responsable/{id}")
    public Optional<Responsable> obtenerPorId(@PathVariable("id") Integer responsableId) {
        return responsableService.obtenerPorId(responsableId);
    }

    @PostMapping("/responsable")
    public Responsable crear(@RequestBody Responsable responsable) {
        responsableService.crear(responsable);
        return responsable;
    }

    @PutMapping("/responsable")
    public Responsable actualizar(@RequestBody Responsable responsable) {
        responsableService.actualizar(responsable);
        return responsable;
    }

    @DeleteMapping("/responsable/{id}")
    public void eliminarPorId(@PathVariable("id") Integer responsableId) {
        responsableService.eliminarPorId(responsableId);
    }

}

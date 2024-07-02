package upeu.academia.controller;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.ListaAlumno;
import upeu.academia.service.jpa.ListaAlumnoService;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Jerika Reyna
 */
@RestController
@RequestMapping("api/v1/lista-alumnos")
@RequiredArgsConstructor
public class ListaAlumnoController {

    private final ListaAlumnoService listaAlumnoService;

    @GetMapping
    public List<ListaAlumno> listarTodos() {
        return listaAlumnoService.listarTodos();
    }

    @GetMapping("{id}")
    public Optional<ListaAlumno> obtenerPorId(@PathVariable("id") Integer id) {
        return listaAlumnoService.obtenerPorId(id);
    }

    @PostMapping
    public ListaAlumno crear(@RequestBody ListaAlumno listaAlumno) {
        listaAlumnoService.crear(listaAlumno);
        return listaAlumno;
    }

    @PutMapping
    public ListaAlumno actualizar(@RequestBody ListaAlumno listaAlumno) {
        listaAlumnoService.actualizar(listaAlumno);
        return listaAlumno;
    }

}

package upeu.academia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.academia.domain.entity.ListaAlumno;
import upeu.academia.service.jpa.ListaAlumnoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("api")
public class ListaAlumnoController {
    @Autowired
    private ListaAlumnoService listaAlumnoService;

    @GetMapping("listaAlumnos")
    public List<ListaAlumno> listarTodos() {
        return listaAlumnoService.listarTodos();
    }
    
    @GetMapping("listaAlumno/{id}")
    public Optional<ListaAlumno> obtenerPorId(@PathVariable("id") Integer id) {
        return listaAlumnoService.obtenerPorId(id);
    }
    

    @PostMapping("listaAlumno")
    public ListaAlumno crear(@RequestBody ListaAlumno listaAlumno) {
        listaAlumnoService.crear(listaAlumno);
        return listaAlumno;
    }

    @PutMapping("listaAlumno/{id}")
    public ListaAlumno actualizar(@RequestBody ListaAlumno listaAlumno) {
        listaAlumnoService.actualizar(listaAlumno);
        return listaAlumno;
    }

}

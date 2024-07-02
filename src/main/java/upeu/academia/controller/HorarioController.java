package upeu.academia.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.Horario;
import upeu.academia.service.IHorariosService;

/**
 *
 * @author Carlos Omar
 */
@RestController
@RequestMapping("/api/v1/horarios")
@RequiredArgsConstructor
public class HorarioController {

    private final IHorariosService horariosService;

    @GetMapping
    public List<Horario> buscartodos() {
        return horariosService.buscarTodos();
    }

    @PostMapping
    public Horario guardar(@RequestBody Horario horarios) {
        horariosService.guardar(horarios);
        return horarios;
    }

    @PutMapping
    public Horario modificar(@RequestBody Horario horarios) {
        horariosService.modificar(horarios);
        return horarios;
    }

    @DeleteMapping("{id}")
    public void elimnarPorId(@PathVariable("id") Integer id) {
        horariosService.eliminarPorId(id);
    }

    @GetMapping("{id}")
    public Optional<Horario> buscarId(@PathVariable("id") Integer id) {
        return horariosService.buscarId(id);
    }
}
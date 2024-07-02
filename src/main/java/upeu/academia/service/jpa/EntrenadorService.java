package upeu.academia.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.academia.domain.entity.Entrenador;
import upeu.academia.repository.IEntrenadorRepository;
import upeu.academia.service.IEntrenadorService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author Carlos Omar
 */
@Service
public class EntrenadorService implements IEntrenadorService {

    @Autowired
    private IEntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> listarTodos() {
        return entrenadorRepository.findAll();
    }

    @Override
    public Entrenador crear(Entrenador entrenador) {
        if (entrenadorRepository.existsByDni(entrenador.getDni())) {
            throw new IllegalArgumentException("Ya existe un entrenador con el DNI: " + entrenador.getDni());
        }
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public Entrenador actualizar(Integer id, Entrenador entrenador) {
        if (!Objects.equals(id, entrenador.getId())) {
            throw new IllegalArgumentException(
                    "El ID del entrenador en la ruta y en el cuerpo de la solicitud no coinciden");
        }
        Entrenador entrenadorExistente = obtenerPorId(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un entrenador con el ID: " + id));
        // Actualiza los campos del entrenadorExistente con los valores de entrenador
        entrenadorExistente.setDni(entrenador.getDni());
        entrenadorExistente.setNombres(entrenador.getNombres());
        entrenadorExistente.setApellidoPaterno(entrenador.getApellidoPaterno());
        entrenadorExistente.setApellidoMaterno(entrenador.getApellidoMaterno());
        entrenadorExistente.setCorreo(entrenador.getCorreo());
        entrenadorExistente.setTelefono(entrenador.getTelefono());
        entrenadorExistente.setDireccion(entrenador.getDireccion());
        return entrenadorRepository.save(entrenadorExistente);
    }

    @Override
    public Optional<Entrenador> obtenerPorId(Integer entrenadorId) {
        return entrenadorRepository.findById(entrenadorId);
    }

    @Override
    public void eliminarPorId(Integer entrenadorId) {
        if (!entrenadorRepository.existsById(entrenadorId)) {
            return;
        }
        entrenadorRepository.deleteById(entrenadorId);
    }
}
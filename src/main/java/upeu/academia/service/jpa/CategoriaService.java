package upeu.academia.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.Categoria;
import upeu.academia.repository.ICategoriaRepository;
import upeu.academia.service.ICategoriaService;

/**
 * 
 * @author Carlos Omar
 */
@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService {


    private final ICategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> obtenerPorId(Integer caregoriaId) {
        return categoriaRepository.findById(caregoriaId);
    }

    @Override
    public void crear(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void actualizar(Categoria categoria) {
        categoriaRepository.save(categoria);

    }

    @Override
    public void eliminarPorId(Integer categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

}

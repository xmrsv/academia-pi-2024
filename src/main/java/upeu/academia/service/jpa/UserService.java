package upeu.academia.service.jpa;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import upeu.academia.domain.entity.User;
import upeu.academia.repository.IUserRepository;
import upeu.academia.service.IUserService;

/**
 * 
 * @author Miguel Gonzales
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public Optional<User> obtenerPorUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return user;
        } else {
            throw new NoSuchElementException("Usuario no encontrado");
        }
    }

    @Override
    public User crear(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new NoSuchElementException("El username ya existe");
        }
        return userRepository.save(user);
    }

    @Override
    public User actualizar(Integer userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setId(userId);
            return userRepository.save(user);
        }
        throw new NoSuchElementException("Usuario no encontrado");
    }

    @Override
    public void eliminar(Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new NoSuchElementException("Usuario no encontrado");
        }
    }

}

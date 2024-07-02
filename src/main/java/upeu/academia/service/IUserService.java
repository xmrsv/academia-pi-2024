package upeu.academia.service;

import java.util.Optional;

import upeu.academia.domain.entity.User;

public interface IUserService {
    
    Optional<User> obtenerPorUsername(String username); 

    User crear(User user);

    User actualizar(Integer userId, User user);

    void eliminar(Integer userId);

}

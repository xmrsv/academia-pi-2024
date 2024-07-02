package upeu.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.User;

import java.util.Optional;

/**
 *
 * @author Miguel Gonzales
 */
public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}

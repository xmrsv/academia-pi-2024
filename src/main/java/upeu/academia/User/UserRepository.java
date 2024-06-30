package upeu.academia.User;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.academia.domain.entity.User;

import java.util.Optional;

/**
 *
 * @author Miguel Gonzales
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}

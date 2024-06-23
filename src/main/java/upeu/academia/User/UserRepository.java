package upeu.academia.User;

import upeu.academia.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Miguel Gonzales
 */
public interface UserRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

}

package upeu.academia.auth;

import upeu.academia.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upeu.academia.User.Role;
import upeu.academia.User.User;
import upeu.academia.User.UserRepository;

/**
 *
 * @author adrian
 */
@Service
@RequiredArgsConstructor
class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setCountry(request.getCountry());
        user.setRole(Role.USER);

        userRepository.save(user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.getToken(user));
        return authResponse;
    }

}

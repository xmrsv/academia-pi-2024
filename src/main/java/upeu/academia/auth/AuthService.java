package upeu.academia.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import upeu.academia.domain.entity.Role;
import upeu.academia.domain.entity.User;
import upeu.academia.jwt.JwtService;
import upeu.academia.repository.IUserRepository;
import upeu.academia.service.jpa.UserService;

/**
 *
 * @author Miguel Gonzales
 */
@Service
@RequiredArgsConstructor
public class AuthService {

        private final IUserRepository userRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;
        private final UserService userService;

        public AuthResponse login(LoginRequest request) throws Exception {
                authenticationManager
                                .authenticate(
                                                new UsernamePasswordAuthenticationToken(
                                                                request.getUsername(), request.getPassword()));
                UserDetails user = userService.obtenerPorUsername(request.getUsername()).orElseThrow();
                String token = jwtService.getToken(user);
                return AuthResponse.builder()
                                .token(token)
                                .build();
        }

        public AuthResponse register(RegisterRequest request) {
                User user = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER) // Registra como usuario por defecto.
                                .build();

                userRepository.save(user);

                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .build();
        }

}

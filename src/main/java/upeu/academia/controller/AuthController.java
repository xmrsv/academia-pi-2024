package upeu.academia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import upeu.academia.auth.AuthResponse;
import upeu.academia.auth.AuthService;
import upeu.academia.auth.LoginRequest;
import upeu.academia.auth.RegisterRequest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Miguel Gonzales
 */
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {

        Map<String, Object> response = new HashMap<>();

        try {
            return ResponseEntity.ok(authService.login(request));
        } catch (Exception e) {
            response.put("error", "unauthorized: " + e.getMessage());
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}

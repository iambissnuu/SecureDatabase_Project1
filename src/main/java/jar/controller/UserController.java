package jar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.entity.User;
import jar.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Return users without showing their passwords
    @GetMapping
    public List<Map<String, Object>> getAllUsers() {

        return userRepository.findAll()
            .stream()
            .map(user -> Map.<String, Object>of(
                "id", user.getId(),
                "username", user.getUsername()
            ))
            .toList();
    }

    // Search for one user by username
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(
            @PathVariable String username) {

        User user = userRepository.findByUsername(username)
            .orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
            Map.of(
                "id", user.getId(),
                "username", user.getUsername()
            )
        );
    }
}
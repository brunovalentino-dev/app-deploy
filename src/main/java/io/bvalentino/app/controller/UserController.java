package io.bvalentino.app.controller;

import io.bvalentino.app.model.User;
import io.bvalentino.app.service.UserService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> register(@RequestBody UserRequest request) {
        var user = request.toEntity();

        var registeredUser = userService.createUser(user);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registeredUser.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new UserResponse(registeredUser.getName(), registeredUser.getEmail()));
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        var response = userService.getAllUsers().stream()
            .map(user -> new UserResponse(user.getName(), user.getEmail()))
            .toList();

        return ResponseEntity.ok(response);
    }

    public record UserRequest(
        @NotBlank String name,
        @NotNull Long age,
        @NotBlank String email,
        @NotBlank String password
    ) {

        public User toEntity() {
            return new User(name, age, email, password);
        }

    }

    public record UserResponse(
        String name,
        String email
    ) {}

}

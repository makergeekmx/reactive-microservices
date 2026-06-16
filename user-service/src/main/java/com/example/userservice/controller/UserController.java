package com.example.userservice.controller;

import com.example.userservice.model.UserAccount;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Flux<UserAccount> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<UserAccount> getUser(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserAccount> createUser(@Valid @RequestBody UserAccount user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public Mono<UserAccount> updateUser(@PathVariable Long id, @Valid @RequestBody UserAccount user) {
        user.setId(id);
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}

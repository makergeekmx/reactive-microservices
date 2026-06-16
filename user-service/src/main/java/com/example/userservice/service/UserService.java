package com.example.userservice.service;

import com.example.userservice.model.UserAccount;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<UserAccount> findAllUsers() {
        return userRepository.findAll();
    }

    public Mono<UserAccount> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<UserAccount> saveUser(UserAccount user) {
        return userRepository.save(user);
    }

    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }
}

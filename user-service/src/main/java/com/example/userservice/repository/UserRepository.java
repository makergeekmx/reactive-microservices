package com.example.userservice.repository;

import com.example.userservice.model.UserAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserAccount, Long> {
}

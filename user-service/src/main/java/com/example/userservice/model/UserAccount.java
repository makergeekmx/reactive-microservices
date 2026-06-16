package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class UserAccount {
    @Id
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String fullName;

    @Email
    private String email;

    private String role;
}

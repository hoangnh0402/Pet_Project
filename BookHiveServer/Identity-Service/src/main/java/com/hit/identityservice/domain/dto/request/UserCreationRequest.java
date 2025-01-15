package com.hit.identityservice.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
    @NotNull
    @Pattern(regexp="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message="USERNAME_INVALID")
    private String email;

    @NotNull
    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;
}

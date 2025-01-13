package com.hit.identityservice.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}

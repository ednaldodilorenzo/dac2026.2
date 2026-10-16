package com.example.base.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UsuarioReqDto(
        @NotBlank
        @Length(min = 3, max = 100)
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Length(min = 8)
        String senha
) {
}

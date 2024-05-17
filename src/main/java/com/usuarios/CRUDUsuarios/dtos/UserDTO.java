package com.usuarios.CRUDUsuarios.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank String nome, @NotBlank String email) {
}

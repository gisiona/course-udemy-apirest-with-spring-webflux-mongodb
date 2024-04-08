package com.br.gisiona.apirestwebflux.controller.dto.request;

import java.time.LocalDate;

public record UsuarioRequest(
        String nome,
        String email,
        String password,
        String telefone,
        LocalDate dataNascimento
) {
}

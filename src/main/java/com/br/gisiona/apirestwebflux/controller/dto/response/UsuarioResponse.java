package com.br.gisiona.apirestwebflux.controller.dto.response;

import java.time.LocalDate;

public record UsuarioResponse(
        String codigo,
        String nome,
        String email,
        String password,
        String telefone,
        LocalDate dataNascimento
) {
}

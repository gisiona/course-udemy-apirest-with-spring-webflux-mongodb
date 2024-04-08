package com.br.gisiona.apirestwebflux.mapper;

import com.br.gisiona.apirestwebflux.controller.dto.request.UsuarioRequest;
import com.br.gisiona.apirestwebflux.entity.UsuarioEntity;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class UsuarioMapper {

    public UsuarioEntity toUsuarioEntity(final UsuarioRequest request) {
        return UsuarioEntity
                .builder()
                .id(UUID.randomUUID().toString())
                .nome(request.nome())
                .email(request.email())
                .telefone(request.telefone())
                .senha(request.password())
                .usuarioConfirmado(Boolean.FALSE)
                .build();
    }
}

package com.br.gisiona.apirestwebflux.service;

import com.br.gisiona.apirestwebflux.controller.dto.request.UsuarioRequest;
import com.br.gisiona.apirestwebflux.entity.UsuarioEntity;
import reactor.core.publisher.Mono;

public interface UsuarioService {
    Mono<UsuarioEntity> criarUsuario(UsuarioRequest request);
}

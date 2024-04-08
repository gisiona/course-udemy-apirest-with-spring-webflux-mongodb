package com.br.gisiona.apirestwebflux.service.impl;

import com.br.gisiona.apirestwebflux.controller.dto.request.UsuarioRequest;
import com.br.gisiona.apirestwebflux.entity.UsuarioEntity;
import com.br.gisiona.apirestwebflux.mapper.UsuarioMapper;
import com.br.gisiona.apirestwebflux.repository.UsuarioRepository;
import com.br.gisiona.apirestwebflux.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service @RequiredArgsConstructor @Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Mono<UsuarioEntity> criarUsuario(UsuarioRequest request) {
        return usuarioRepository.criarUsuario(usuarioMapper.toUsuarioEntity(request));
    }
}

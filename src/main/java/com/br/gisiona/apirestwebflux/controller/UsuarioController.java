package com.br.gisiona.apirestwebflux.controller;

import com.br.gisiona.apirestwebflux.controller.dto.request.UsuarioRequest;
import com.br.gisiona.apirestwebflux.controller.dto.response.UsuarioResponse;
import com.br.gisiona.apirestwebflux.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/gisiona.api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Mono<Void>> CriarUsuario(@RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(request).then());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Mono<UsuarioResponse>> ConsultarUsuarioPorId(@PathVariable String codigo) {
        return null;
    }

    @GetMapping()
    public ResponseEntity<Flux<UsuarioResponse>> ConsultarUsuarioTodos() {
        return null;
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity<Mono<UsuarioResponse>> AtualizarUsuarioParcial(@PathVariable String codigo, @RequestBody UsuarioRequest request) {
        return null;
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Mono<Void>> DeleteUsuario(@PathVariable String codigo) {
        return null;
    }
}

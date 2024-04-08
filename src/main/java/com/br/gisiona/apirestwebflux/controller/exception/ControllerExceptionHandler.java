package com.br.gisiona.apirestwebflux.controller.exception;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Mono<DefaultErroException>> duplicationKeyException(DuplicateKeyException exception, ServerHttpRequest httpRequest) {
        return ResponseEntity
            .badRequest()
                .body(Mono.just(
                        DefaultErroException
                                .builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .message(getMensagemPersonalizada(exception.getMessage()))
                                .path(httpRequest.getURI().getPath())
                                .build()));
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<Mono<DefaultErroException>> duplicationKeyException(MongoWriteException exception, ServerHttpRequest httpRequest) {
        return ResponseEntity
                .badRequest()
                .body(Mono.just(
                        DefaultErroException
                                .builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .message(getMensagemPersonalizada(exception.getMessage()))
                                .path(httpRequest.getURI().getPath())
                                .build()));
    }

    private String getMensagemPersonalizada(String exception) {
        if (exception != null) {
            if (exception.contains("email dup key")){
                return "E-mail do usuário duplicado";
            } else {
                return "Erro ao criar usuário";
            }
        }
        return null;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Mono<DefaultErroException>> defaultException(Exception exception, ServerHttpRequest httpRequest) {
        return ResponseEntity
                .badRequest()
                .body(Mono.just(
                        DefaultErroException
                                .builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .message(getMensagemPersonalizada(exception.getMessage()))
                                .path(httpRequest.getURI().getPath())
                                .build()));
    }
}

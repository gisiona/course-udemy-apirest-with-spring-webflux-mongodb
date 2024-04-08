package com.br.gisiona.apirestwebflux.controller.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data @Builder
public class DefaultErroException {
    private LocalDateTime timestamp;
    private String error;
    private String path;
    private Integer status;
    private String message;
}

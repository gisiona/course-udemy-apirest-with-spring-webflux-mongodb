package com.br.gisiona.apirestwebflux.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @Builder @Document
public class UsuarioEntity {
    @Id
    private String id;
    private String nome;
    @Indexed(unique = true)
    private String email;
    private String telefone;
    private String senha;
    private boolean usuarioConfirmado;
}

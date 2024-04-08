package com.br.gisiona.apirestwebflux.repository;

import com.br.gisiona.apirestwebflux.entity.UsuarioEntity;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository @RequiredArgsConstructor @Slf4j
public class UsuarioRepository {
    private final ReactiveMongoTemplate mongoTemplate;

    public Mono<UsuarioEntity> criarUsuario(UsuarioEntity usuarioEntity){
        try {
            return mongoTemplate.save(usuarioEntity);
        } catch (DuplicateKeyException duplicateKeyException) {
            log.error("Erro ao salvar usuário duplicado. Mensagem: {}", duplicateKeyException.getMessage());
            throw duplicateKeyException;
        } catch (MongoException mongoException) {
            log.error("Erro ao salvar usuário. Mensagem: {}", mongoException.getMessage());
            throw mongoException;
        }
    }
}

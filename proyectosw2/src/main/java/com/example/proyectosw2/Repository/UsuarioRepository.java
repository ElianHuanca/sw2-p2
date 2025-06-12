package com.example.proyectosw2.Repository;

import com.example.proyectosw2.Entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.bson.types.ObjectId;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioEntity, ObjectId> {
    Optional<UsuarioEntity> findByEmail(String email);
}


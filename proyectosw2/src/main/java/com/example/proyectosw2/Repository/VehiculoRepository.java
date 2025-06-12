package com.example.proyectosw2.Repository;

import com.example.proyectosw2.Entity.VehiculoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.bson.types.ObjectId;

@Repository
public interface VehiculoRepository extends MongoRepository<VehiculoEntity, ObjectId> {
}

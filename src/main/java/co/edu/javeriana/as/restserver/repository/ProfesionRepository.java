package co.edu.javeriana.as.restserver.repository;

import co.edu.javeriana.as.restserver.entity.Profesion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfesionRepository extends MongoRepository<Profesion,Integer> {
}

package co.edu.javeriana.as.restserver.repository;

import co.edu.javeriana.as.restserver.entity.Telefono;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TelefonoRepository extends MongoRepository<Telefono,Integer> {
}

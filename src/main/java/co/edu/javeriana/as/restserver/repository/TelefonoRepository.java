package co.edu.javeriana.as.restserver.repository;

import co.edu.javeriana.as.restserver.entity.Telefono;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends MongoRepository<Telefono,Integer> {
}

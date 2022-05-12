package co.edu.javeriana.as.restserver.repository;

import co.edu.javeriana.as.restserver.entity.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona,Integer> {

}

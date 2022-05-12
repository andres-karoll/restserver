package co.edu.javeriana.as.restserver.repository;

import co.edu.javeriana.as.restserver.entity.Profesion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionRepository extends MongoRepository<Profesion,Integer> {

}

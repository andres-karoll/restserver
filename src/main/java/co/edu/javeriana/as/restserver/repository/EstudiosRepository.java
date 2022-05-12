package co.edu.javeriana.as.restserver.repository;

import co.edu.javeriana.as.restserver.entity.Estudios;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends MongoRepository<Estudios,Integer> {

}

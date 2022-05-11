package co.edu.javeriana.as.restserver.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Profesion")
public class Profesion {
    @Id
    private final Integer id;
    private final String nombre;
    private final String descripcion;

}

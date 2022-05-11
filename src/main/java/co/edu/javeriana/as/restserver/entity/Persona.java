package co.edu.javeriana.as.restserver.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Persona")
public class Persona {
    @Id
    private final Integer cc;
    private final String nombre;
    private final String apellido;
    private final char genero;
    private final Integer edad;

}

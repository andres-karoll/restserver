package co.edu.javeriana.as.restserver.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(value = "Persona")
public class Persona {
    @Id
    private final Integer cc;
    private final String nombre;
    private final String apellido;
    private final Genero genero;
    private final Integer edad;
    private final List<Telefono> telefonos;
    private final List<Estudios> estudios;
}

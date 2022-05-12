package co.edu.javeriana.as.restserver.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Telefono")
public class Telefono {
    @Id
    private final Integer duenio;
    private final String numero;
    private final String operador;


}

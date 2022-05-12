package co.edu.javeriana.as.restserver.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(value = "Estudios")
public class Estudios {
    @Id
    private final Integer identificador;
    private final Integer cc_per;
    private final LocalDateTime date;
    private final String universidad;

}

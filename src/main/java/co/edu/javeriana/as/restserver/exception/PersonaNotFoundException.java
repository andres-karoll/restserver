package co.edu.javeriana.as.restserver.exception;

public class PersonaNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public PersonaNotFoundException(){
        super("Persona not found");
    }

}

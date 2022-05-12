package co.edu.javeriana.as.restserver.exception;

public class ProfesionNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ProfesionNotFoundException(){
        super("Profesion not found");
    }

}

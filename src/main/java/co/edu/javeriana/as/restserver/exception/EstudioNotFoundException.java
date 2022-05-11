package co.edu.javeriana.as.restserver.exception;

public class EstudioNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EstudioNotFoundException(){
        super("Estudio not found");
    }
}

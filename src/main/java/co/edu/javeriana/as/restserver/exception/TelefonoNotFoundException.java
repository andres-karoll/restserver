package co.edu.javeriana.as.restserver.exception;

public class TelefonoNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public TelefonoNotFoundException(){
        super("Telefono not found");
    }

}

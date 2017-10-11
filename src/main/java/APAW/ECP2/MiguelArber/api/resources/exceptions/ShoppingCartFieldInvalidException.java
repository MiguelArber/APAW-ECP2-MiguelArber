package APAW.ECP2.MiguelArber.api.resources.exceptions;

public class ShoppingCartFieldInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;
    
    public static final String DESCRIPTION = "El nombre del carrito no es valido";

    public ShoppingCartFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ShoppingCartFieldInvalidException() {
        this("");
    }

}

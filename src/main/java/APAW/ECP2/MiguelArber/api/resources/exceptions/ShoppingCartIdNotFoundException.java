package APAW.ECP2.MiguelArber.api.resources.exceptions;

public class ShoppingCartIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;
    

    public static final String DESCRIPTION = "El id del carrito no existe";

    public ShoppingCartIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ShoppingCartIdNotFoundException() {
        this("");
    }

}

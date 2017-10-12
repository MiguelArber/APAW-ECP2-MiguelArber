package APAW.ECP2.MiguelArber.api.resources.exceptions;

public class RequestInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Acción no permitida";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public RequestInvalidException() {
        this("");
    }
}

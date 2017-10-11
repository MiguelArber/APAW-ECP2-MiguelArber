package APAW.ECP2.MiguelArber.api.resources.exceptions;

public class ArticleFieldInvalidException extends Exception {
    private static final long serialVersionUID = -5173361541880534566L;

    
    public static final String DESCRIPTION = "El nombre del articulo no es valido";

    public ArticleFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ArticleFieldInvalidException() {
        this("");
    }
    
}

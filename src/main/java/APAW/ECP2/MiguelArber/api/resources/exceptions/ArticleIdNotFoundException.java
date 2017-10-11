package APAW.ECP2.MiguelArber.api.resources.exceptions;

public class ArticleIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893112342899234744L;
    

    public static final String DESCRIPTION = "El id del articulo no existe";

    public ArticleIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ArticleIdNotFoundException() {
        this("");
    }

}

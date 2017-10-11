package APAW.ECP2.MiguelArber.api.resources;

import java.util.List;

import APAW.ECP2.MiguelArber.api.controllers.ArticleController;
import APAW.ECP2.MiguelArber.api.controllers.ShoppingCartController;
import APAW.ECP2.MiguelArber.api.dtos.ArticleDto;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartIdNotFoundException;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ArticleFieldInvalidException;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartFieldInvalidException;

public class ArticleResource {
	
	 public static final String ARTICLES = "articles";

	    public void createArticle(String articleName) throws ArticleFieldInvalidException {
	        this.validateField(articleName);
	        new ArticleController().createArticle(articleName);
	    }

	    private void validateField(String field) throws ArticleFieldInvalidException {
	        if (field == null || field.isEmpty()) {
	            throw new ArticleFieldInvalidException(field);
	        }
	    }
}

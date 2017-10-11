package APAW.ECP2.MiguelArber.api.resources;

import java.util.List;
import java.util.Optional;

import APAW.ECP2.MiguelArber.api.controllers.ArticleController;
import APAW.ECP2.MiguelArber.api.controllers.ShoppingCartController;
import APAW.ECP2.MiguelArber.api.dtos.ArticleDto;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartDto;
import APAW.ECP2.MiguelArber.api.entities.builders.ArticleBuilder;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartIdNotFoundException;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ArticleFieldInvalidException;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ArticleIdNotFoundException;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartFieldInvalidException;

public class ArticleResource {
	
	 public static final String ARTICLES = "articles";
	 public static final String ID = "/{id}";

	    public void createArticle(String articleName) throws ArticleFieldInvalidException {
	        this.validateField(articleName);
	        new ArticleController().createArticle(articleName);
	    }

	    private void validateField(String field) throws ArticleFieldInvalidException {
	        if (field == null || field.isEmpty()) {
	            throw new ArticleFieldInvalidException(field);
	        }
	    }
	    
	    public ArticleDto readArticle(Integer articleId) throws ArticleIdNotFoundException {
	    	
	    	/*ArticleDto article = new ArticleDto(new ArticleBuilder().addId(1).addReference("article").build());	
	    	return article;*/
	    	
	        Optional<ArticleDto> optional = new ArticleController().readArticle(articleId);
	        return optional.orElseThrow(() -> new ArticleIdNotFoundException(Integer.toString(articleId)));
	    }
}

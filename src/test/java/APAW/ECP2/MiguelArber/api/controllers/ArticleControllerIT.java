package APAW.ECP2.MiguelArber.api.controllers;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.memory.DaoMemoryFactory;
import APAW.ECP2.MiguelArber.api.dtos.ArticleDto;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartDto;

public class ArticleControllerIT {

    private ArticleController articleController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        articleController = new ArticleController();
    }

    @Test
    public void testCreateAndArticleList() {
    	articleController.createArticle("article");
        assertEquals("article", articleController.articleList().get(0).getReference());
    }
    
    private boolean existArticleId(int articleId) {
        return DaoFactory.getFactory().getArticleDao().read(articleId) != null;
    }
    
    public Optional<ArticleDto> readArticle(int articleId) {
        if (existArticleId(articleId)) {
             return Optional.of(new ArticleDto(DaoFactory.getFactory().getArticleDao().read(articleId)));
         } else {
             return Optional.empty();
         }
     }
    
}

package APAW.ECP2.MiguelArber.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.dtos.ArticleDto;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartDto;
import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;
import APAW.ECP2.MiguelArber.api.entities.builders.ArticleBuilder;
import APAW.ECP2.MiguelArber.api.entities.Article;

public class ArticleController {
	
	private int next_ID = 0;
	
    public List<ArticleDto> articleList() {
        List<Article> articleList = DaoFactory.getFactory().getArticleDao().findAll();
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (Article article : articleList) {
        	articleDtoList.add(new ArticleDto(article));
        }
        return articleDtoList;
    }
	
    public void createArticle(String articleReference) {
        DaoFactory.getFactory().getArticleDao().create(new ArticleBuilder().addId(next_ID+1).addReference(articleReference).build());
        next_ID++;
    }
    
    public Optional<ArticleDto> readArticle(int articleId) {
        if (existArticleId(articleId)) {
             return Optional.of(new ArticleDto(DaoFactory.getFactory().getArticleDao().read(articleId)));
         } else {
             return Optional.empty();
         }
     }
    
    private boolean existArticleId(int articleId) {
        return DaoFactory.getFactory().getArticleDao().read(articleId) != null;
    }


}

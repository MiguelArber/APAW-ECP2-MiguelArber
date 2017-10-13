package APAW.ECP2.MiguelArber.api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import APAW.ECP2.MiguelArber.api.daos.ArticleDao;
import APAW.ECP2.MiguelArber.api.entities.Article;
import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;

public class ArticleDaoMemory extends GenericDaoMemory<Article> implements ArticleDao {

    public ArticleDaoMemory() {
        this.setMap(new HashMap<Integer, Article>());
    }
	
	@Override
	protected Integer getId(Article entity) {
		return entity.getID();
	}

	@Override
	protected void setId(Article entity, Integer id) {
		
	}


}

package APAW.ECP2.MiguelArber.api.daos.memory;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.ShoppingCartDao;
import APAW.ECP2.MiguelArber.api.daos.ArticleDao;

public class DaoMemoryFactory extends DaoFactory {

    private ShoppingCartDao shoppingCartDao;
    private ArticleDao articleDao;
	
	@Override
	public ShoppingCartDao getShoppingCartDao() {
        if (shoppingCartDao == null) {
            shoppingCartDao = new ShoppingCartDaoMemory();
        }
        return shoppingCartDao;
	}

	@Override
	public ArticleDao getArticleDao() {
		if (articleDao == null) {
            articleDao = new ArticleDaoMemory();
        }
        return articleDao;
	}


}

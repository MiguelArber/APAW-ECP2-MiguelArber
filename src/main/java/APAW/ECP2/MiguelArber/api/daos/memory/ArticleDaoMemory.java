package APAW.ECP2.MiguelArber.api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import APAW.ECP2.MiguelArber.api.daos.ArticleDao;
import APAW.ECP2.MiguelArber.api.entities.Article;

public class ArticleDaoMemory extends GenericDaoMemory<Article> implements ArticleDao {

	@Override
	protected Integer getId(Article entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setId(Article entity, Integer id) {
		// TODO Auto-generated method stub
		
	}


}

package APAW.ECP2.MiguelArber.api.daos.memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.entities.Article;
import APAW.ECP2.MiguelArber.api.entities.builders.ArticleBuilder;

public class ArticleDaoMemoryTest {


    private Article article;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        article = new ArticleBuilder().addReference("article").build();
        DaoFactory.getFactory().getArticleDao().create(article);
    }

    @Test
    public void testReadArticle() {
        assertEquals("article", DaoFactory.getFactory().getArticleDao().read(1).getReference());
    }

    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getArticleDao().read(2));
    }
}

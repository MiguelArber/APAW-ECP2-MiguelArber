package APAW.ECP2.MiguelArber.api.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import APAW.ECP2.MiguelArber.api.entities.Article;
import APAW.ECP2.MiguelArber.api.entities.builders.ArticleBuilder;

public class ArticleBuilderTest {

	@Test
	public void testArticleIntStringLongBoolean() {
		
		Article article = new ArticleBuilder().addId(1).addReference("Ref#001").addStock(1000).addDisontinued(false).build();
		
		assertEquals(1, article.getID());
		assertEquals("Ref#001", article.getReference());
		assertEquals(1000, article.getStock());
		assertEquals(false, article.isDiscontinued());
		
	}
	
	@Test
	public void testArticleLongBoolean() {
		
		Article article = new ArticleBuilder(1, "Ref#001").addStock(1000).addDisontinued(false).build();
		
		assertEquals(1, article.getID());
		assertEquals("Ref#001", article.getReference());
		assertEquals(1000, article.getStock());
		assertEquals(false, article.isDiscontinued());
		
	}
	
}

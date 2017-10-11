package APAW.ECP2.MiguelArber.api.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.entities.Article;

public class ArticleTest {
	
	private Article article;
	private Article article2;

	
	@Before
	public void before() {
		
		article = new Article(1, "ref#123"); //Constructor 1
		article2 = new Article(1, "ref#123", 0, true); //Constructor 1

	}
	
	@Test
	public void testID() {
		
		assertEquals(1, article.getID());
		
	}
	
	@Test
	public void testReference() {
		
		assertEquals("ref#123", article.getReference());
		
	}
	
	@Test
	public void testStock() {
		
		assertEquals(0, article.getStock());
		article.setStock(10);
		assertEquals(10, article.getStock());
		
	}

	
	@Test
	public void testDiscontinued() {
		
		assertEquals(false, article.isDiscontinued());
		article.setDisontinued(true);
		assertEquals(true, article.isDiscontinued());
		
	}

}
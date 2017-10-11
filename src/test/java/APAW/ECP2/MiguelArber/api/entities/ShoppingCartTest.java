package APAW.ECP2.MiguelArber.api.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;

public class ShoppingCartTest {
	
	private ShoppingCart cart;
	private ShoppingCart cart2;
	
	@Before
	public void before() {
		
		cart = new ShoppingCart(1); //Constructor 1
		cart2 = new ShoppingCart(1, Calendar.getInstance(), "Carrito", false, new ArrayList<Article>()); //Constructor 2
		
	}
	
	@Test
	public void testID() {
		
		assertEquals(1, cart.getID());
		
	}
	
	@Test
	public void testName() {
		
		assertEquals("", cart.getName());
		assertEquals("Carrito", cart2.getName());
		cart.setName("Cart");
		assertEquals("Cart", cart.getName());
		
	}
	
	@Test
	public void testUrgent() {
		
		assertEquals(false, cart.isUrgent());
		cart.setUrgent(true);
		assertEquals(true, cart.isUrgent());
		
	}

	@Test
	public void testDate() {
		
		assertEquals(true, cart.getDate().before(Calendar.getInstance()));
		
	}
	
	@Test
	public void testArticles() {
		
		assertEquals(null, cart.getArticle(1));
		Article a = new Article(1, "ref#123");
		cart.addArticle(a);
		assertEquals(a, cart.getArticle(1));
		cart.removeArticle(1);
		assertEquals(null, cart.getArticle(1));
	}
	
}
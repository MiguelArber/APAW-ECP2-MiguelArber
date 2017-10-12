package APAW.ECP2.MiguelArber;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.memory.DaoMemoryFactory;
import APAW.ECP2.MiguelArber.api.resources.ShoppingCartResource;
import APAW.ECP2.MiguelArber.api.resources.ArticleResource;
import APAW.ECP2.MiguelArber.http.HttpClientService;
import APAW.ECP2.MiguelArber.http.HttpException;
import APAW.ECP2.MiguelArber.http.HttpMethod;
import APAW.ECP2.MiguelArber.http.HttpRequest;
import APAW.ECP2.MiguelArber.http.HttpRequestBuilder;

public class ShoppingCartResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    
    private void createShoppingCart() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingCartResource.SHOPPING_CART).body("cart").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateShoppingCart() {
        this.createShoppingCart();
    }

    @Test(expected = HttpException.class)
    public void testCreateShoppingCartNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingCartResource.SHOPPING_CART).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutShoppingCartName() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingCartResource.SHOPPING_CART).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testReadShoppingCart() {
        this.createShoppingCart();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ShoppingCartResource.SHOPPING_CART).path(ShoppingCartResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":\"cart\"}", new HttpClientService().httpRequest(request).getBody());

    }
    
    @Test(expected = HttpException.class)
    public void testReadShoppingCartNonExistingID() {
        this.createShoppingCart();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ShoppingCartResource.SHOPPING_CART).path(ShoppingCartResource.ID)
                .expandPath("100").build();
        new HttpClientService().httpRequest(request);

    }
    
    @Test
    public void testDeleteShoppingCart() {
    	
    		this.testCreateShoppingCart();
    		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path("shoppingCart/1").build();
    		assertEquals("{\"id\":1,\"name\":\"cart\"}", new HttpClientService().httpRequest(request).getBody()); //Debe devolver el carrito uno en caso de existir
    }
    
    /*@Test
    public void testDeleteWithoutShoppingCart() {
    	
    		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(ShoppingCartResource.SHOPPING_CART).path(ShoppingCartResource.ID).build();
    		assertEquals("{}", new HttpClientService().httpRequest(request).getBody()); //Devuelve vacío
    }*/
    
}

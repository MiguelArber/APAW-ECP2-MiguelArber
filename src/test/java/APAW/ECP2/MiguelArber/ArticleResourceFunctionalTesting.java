package APAW.ECP2.MiguelArber;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.memory.DaoMemoryFactory;
import APAW.ECP2.MiguelArber.api.resources.ShoppingCartResource;
import APAW.ECP2.MiguelArber.api.resources.ArticleResource;
import APAW.ECP2.MiguelArber.http.HttpClientService;
import APAW.ECP2.MiguelArber.http.HttpException;
import APAW.ECP2.MiguelArber.http.HttpMethod;
import APAW.ECP2.MiguelArber.http.HttpRequest;
import APAW.ECP2.MiguelArber.http.HttpRequestBuilder;

public class ArticleResourceFunctionalTesting {

    private HttpRequest request;

    @Rule
    public ExpectedException exception = ExpectedException.none();

   @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        request = new HttpRequest();
    }
   
  /* private void createShoppingCart() {
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingCartResource.SHOPPING_CART).body("cart").build();
       new HttpClientService().httpRequest(request);
   } Lo necesitaremos para luego */
   
   private void createArticles() {
       //this.createShoppingCart(); Lo necesitaremos para luego
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("article").build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test
   public void testCreateArticle() {
       this.createArticles();
   }
   
   @Test (expected = HttpException.class)
   public void testCreateArticleNAmeEmpty() {
       //this.createShoppingCart(); Lo necesitaremos para luego
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("").build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test (expected = HttpException.class)
   public void testCreateArticleWithoutArticleName() {
       //this.createShoppingCart(); Lo necesitaremos para luego
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test
   public void testReadArticle() {
       this.createArticles();
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ArticleResource.ARTICLES).path(ArticleResource.ID)
               .expandPath("1").build();
       assertEquals("{\"id\":1,\"name\":\"article\"}", new HttpClientService().httpRequest(request).getBody());

   }
   
   @Test(expected = HttpException.class)
   public void testReadShoppingCartNonExistingID() {
	   this.createArticles();
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ArticleResource.ARTICLES).path(ArticleResource.ID)
               .expandPath("100").build();
       new HttpClientService().httpRequest(request);

   }
   
}

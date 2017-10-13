package APAW.ECP2.MiguelArber;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.memory.DaoMemoryFactory;
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
   
   private void createArticles() {
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("article").build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test
   public void testCreateArticle() {
       this.createArticles();
   }
   
   @Test (expected = HttpException.class)
   public void testCreateArticleNAmeEmpty() {
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("").build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test (expected = HttpException.class)
   public void testCreateArticleWithoutArticleName() {
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
   
   @Test
   public void testDeleteArticle() {
   	
   		this.testCreateArticle();
   		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(ArticleResource.ARTICLES).path(ArticleResource.ID)
                .expandPath("1").build();
   		assertEquals("{\"id\":1,\"name\":\"article\"}", new HttpClientService().httpRequest(request).getBody());
   }
   
   /*@Test(expected = HttpException.class)
   public void testDeleteWithoutArticle() {
   	
   		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(ArticleResource.ARTICLES).path(ArticleResource.ID)
                .expandPath("10").build();
   		new HttpClientService().httpRequest(request).getBody();
   }*/
   
   
}

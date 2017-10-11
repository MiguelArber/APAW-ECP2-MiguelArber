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
   
   @Test
   public void test() {
	   
   }
}

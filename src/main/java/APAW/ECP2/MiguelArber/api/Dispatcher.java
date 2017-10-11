package APAW.ECP2.MiguelArber.api;

import APAW.ECP2.MiguelArber.api.resources.ShoppingCartResource;
import APAW.ECP2.MiguelArber.api.resources.ArticleResource;
import APAW.ECP2.MiguelArber.api.resources.exceptions.RequestInvalidException;
import APAW.ECP2.MiguelArber.http.HttpRequest;
import APAW.ECP2.MiguelArber.http.HttpResponse;
import APAW.ECP2.MiguelArber.http.HttpStatus;

public class Dispatcher {

    private ShoppingCartResource shoppingCartResource = new ShoppingCartResource();

    private ArticleResource articleResource = new ArticleResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        
    }

    public void doPost(HttpRequest request, HttpResponse response) {
    	
    	 try {
             if (request.isEqualsPath(ShoppingCartResource.SHOPPING_CART)) {
                 shoppingCartResource.createShoppingCart(request.getBody());
                 response.setStatus(HttpStatus.CREATED);
             }
    	 } catch (Exception e) {
             responseError(response, e);
         }
    		
    }

    public void doPut(HttpRequest request, HttpResponse response) {

    }

    public void doPatch(HttpRequest request, HttpResponse response) {

    }

    public void doDelete(HttpRequest request, HttpResponse response) {

    }

}

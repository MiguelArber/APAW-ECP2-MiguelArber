package APAW.ECP2.MiguelArber.api.resources;

import java.util.List;
import java.util.Optional;

import APAW.ECP2.MiguelArber.api.controllers.ShoppingCartController;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartDto;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartArticleListDto;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartFieldInvalidException;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartIdNotFoundException;

public class ShoppingCartResource {
	
	public static final String SHOPPING_CART = "shoppingCart";
	
	public static final String ID = "/{id}";
	
    public void createShoppingCart(String shoppingCartName) throws ShoppingCartFieldInvalidException {
        this.validateField(shoppingCartName);
        new ShoppingCartController().createShoppingCart(shoppingCartName);
    }
    
    private void validateField(String field) throws ShoppingCartFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new ShoppingCartFieldInvalidException(field);
        }
    }

}

package APAW.ECP2.MiguelArber.api.resources;

import java.util.List;
import java.util.Optional;

import APAW.ECP2.MiguelArber.api.controllers.ShoppingCartController;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartDto;
import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;
import APAW.ECP2.MiguelArber.api.entities.builders.ShoppingCartBuilder;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartArticleListDto;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartFieldInvalidException;
import APAW.ECP2.MiguelArber.api.resources.exceptions.ShoppingCartIdNotFoundException;

public class ShoppingCartResource {
	
	public static final String SHOPPING_CART = "shoppingCart";
	
	public static final String ID = "/{id}";
	
    public List<ShoppingCartDto> shoppingCartList() {
        return new ShoppingCartController().shoppingCartList();
    }
	
    public void createShoppingCart(String shoppingCartName) throws ShoppingCartFieldInvalidException {
        this.validateField(shoppingCartName);
        new ShoppingCartController().createShoppingCart(shoppingCartName);
    }
    
    private void validateField(String field) throws ShoppingCartFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new ShoppingCartFieldInvalidException(field);
        }
    }

    public ShoppingCartDto readShoppingCart(Integer shoppingCartId) throws ShoppingCartIdNotFoundException {
    	
    	/*ShoppingCartDto shoppingCart = new ShoppingCartDto(new ShoppingCartBuilder().addId(1).addName("cart").build());
    	
    	return shoppingCart; For testing purposes*/
    	
        Optional<ShoppingCartDto> optional = new ShoppingCartController().readShoppingCart(shoppingCartId);
        return optional.orElseThrow(() -> new ShoppingCartIdNotFoundException(Integer.toString(shoppingCartId)));
    }

}

package APAW.ECP2.MiguelArber.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.memory.DaoMemoryFactory;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartDto;

public class ShoppingCartControllerIT {

    private ShoppingCartController shoppingCartController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        shoppingCartController = new ShoppingCartController();
    }
    
    @Test
    public void testCreateAndShoppingCartList() {
    	shoppingCartController.createShoppingCart("cart");
        assertEquals("cart", shoppingCartController.shoppingCartList().get(0).getName());
    }
    
    private boolean existShoppingCartId(int shoppingCartId) {
        return DaoFactory.getFactory().getShoppingCartDao().read(shoppingCartId) != null;
    }
    
    public Optional<ShoppingCartDto> readShoppingCart(int shoppingCartId) {
        if (existShoppingCartId(shoppingCartId)) {
             return Optional.of(new ShoppingCartDto(DaoFactory.getFactory().getShoppingCartDao().read(shoppingCartId)));
         } else {
             return Optional.empty();
         }
     }
    
}

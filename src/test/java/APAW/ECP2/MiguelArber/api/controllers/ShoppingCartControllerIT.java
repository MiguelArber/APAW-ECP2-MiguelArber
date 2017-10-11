package APAW.ECP2.MiguelArber.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.memory.DaoMemoryFactory;

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
    
}

package APAW.ECP2.MiguelArber.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;
import APAW.ECP2.MiguelArber.api.entities.builders.ShoppingCartBuilder;

public class ShoppingCartDaoMemoryTest {

    private ShoppingCart shoppingCart;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        shoppingCart = new ShoppingCartBuilder().addName("cart").build();
        DaoFactory.getFactory().getShoppingCartDao().create(shoppingCart);
    }

    @Test
    public void testReadShoppingCart() {
        assertEquals("cart", DaoFactory.getFactory().getShoppingCartDao().read(1).getName());
    }

    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getShoppingCartDao().read(2));
    }
    
}

package APAW.ECP2.MiguelArber.api.daos.memory;

import java.util.HashMap;

import APAW.ECP2.MiguelArber.api.daos.ShoppingCartDao;
import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;

public class ShoppingCartDaoMemory extends GenericDaoMemory<ShoppingCart> implements ShoppingCartDao {

    public ShoppingCartDaoMemory() {
        this.setMap(new HashMap<Integer, ShoppingCart>());
    }
	
	@Override
	protected Integer getId(ShoppingCart entity) {
		return entity.getID();
	}

	@Override
	protected void setId(ShoppingCart entity, Integer id) {
		
	}


}

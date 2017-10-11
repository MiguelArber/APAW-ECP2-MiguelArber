package APAW.ECP2.MiguelArber.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import APAW.ECP2.MiguelArber.api.entities.builders.ShoppingCartBuilder;
import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartDto;
import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;
import APAW.ECP2.MiguelArber.api.dtos.ShoppingCartArticleListDto;

public class ShoppingCartController {
	
	private int next_ID = 0;
	
    public List<ShoppingCartDto> shoppingCartList() {
        List<ShoppingCart> shoppingCartList = DaoFactory.getFactory().getShoppingCartDao().findAll();
        List<ShoppingCartDto> shoppingCartDtoList = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCartList) {
            shoppingCartDtoList.add(new ShoppingCartDto(shoppingCart));
        }
        return shoppingCartDtoList;
    }
	
    public void createShoppingCart(String shoppingCartName) {
        DaoFactory.getFactory().getShoppingCartDao().create(new ShoppingCartBuilder().addId(next_ID+1).addName(shoppingCartName).build());
        next_ID++;
    }

}

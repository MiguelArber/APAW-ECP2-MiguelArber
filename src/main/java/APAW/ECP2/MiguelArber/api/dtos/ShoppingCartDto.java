package APAW.ECP2.MiguelArber.api.dtos;

import APAW.ECP2.MiguelArber.api.entities.ShoppingCart;

public class ShoppingCartDto {
    
    private int id;

    private String name;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(ShoppingCart cart) {
        id = cart.getID();
        name = cart.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }
	
	
}

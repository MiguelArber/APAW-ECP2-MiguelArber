package APAW.ECP2.MiguelArber.api.entities.builders;

import java.util.ArrayList;
import java.util.Calendar;

import APAW.ECP2.MiguelArber.api.entities.*;

public class ShoppingCartBuilder {
	
    private ShoppingCart cart;
    private int id;
    private ArrayList<Article> articles;
    private Calendar date = Calendar.getInstance();
    private String name;
    private boolean urgent;
    
    public ShoppingCartBuilder() {
    		
		this.cart = new ShoppingCart(0);
	
    }
    
    public ShoppingCartBuilder(int id) {
    	
    		this.id = id;
		this.cart = new ShoppingCart(id);
	
    }
    
    public ShoppingCartBuilder addId(int id) {
    	
		this.id = id;
		this.cart = new ShoppingCart(id, date, "", false, articles);
		return this;
    }
    
    public ShoppingCartBuilder addDate(Calendar date) {
    	
		this.date = date;
		this.cart = new ShoppingCart(id, date, name, urgent, articles);
		return this;
    }
    
    public ShoppingCartBuilder addName(String name) {
    		
    		this.name = name;
		cart.setName(name);
		return this;
    }
    
    public ShoppingCartBuilder addUrgent(Boolean urgent) {
    		
    		this.urgent = urgent;
		cart.setUrgent(urgent);
		return this;
    }
    
    public ShoppingCartBuilder addArticles(ArrayList<Article> articles) {
    	
		this.articles = articles;
		this.cart = new ShoppingCart(id, date, name, urgent, articles);
		return this;
    }
    
    public ShoppingCart build() {
    	
    		return this.cart;
    	
    }
    
}

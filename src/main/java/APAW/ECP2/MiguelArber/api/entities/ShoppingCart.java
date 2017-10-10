package APAW.ECP2.MiguelArber.api.entities;

import java.util.ArrayList;
import java.util.Calendar;

public class ShoppingCart {
	
	private int id;
	private Calendar date;
	private String name;
	private boolean urgent;
	private ArrayList<Article> articles;
	
	public ShoppingCart(int id) {
		
		this.id = id;
		this.name = "";
		this.urgent = false;
		this.date = Calendar.getInstance();
		this.articles = new ArrayList<Article>();
		
	}
	
	public ShoppingCart(int id, Calendar date, String name, boolean urgent, ArrayList<Article> articles) {
		
		this.id = id;
		this.date = date;
		this.name = name;
		this.urgent = urgent;
		this.articles = articles;
		
	}
	
	public int getID() {
		
		return id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setUrgent(boolean urgent) {
		
		this.urgent = urgent;
	}
	
	public boolean isUrgent() {
		
		return urgent;
	}
	
	public Calendar getDate() {
		
		return date;
		
	}
	
	public Article getArticle(int id) {
		
		if (!articles.isEmpty()) {
			for(int i = 0; i < articles.size(); i++) {
				
				if(articles.get(i).getID() == id)
					return articles.get(i);
			}
		}
		
		return null;
		
	}
	
	public void addArticle(Article article) {
		
		articles.add(article);
		
	}
	
	public void removeArticle(int id)  {
		
		if (!articles.isEmpty()) {
			for(int i = 0; i < articles.size(); i++) {
						
					if(articles.get(i).getID() == id)
						articles.remove(i);
			}
		}
		
	}
	
}
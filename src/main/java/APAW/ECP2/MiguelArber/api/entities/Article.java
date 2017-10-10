package APAW.ECP2.MiguelArber.api.entities;

public class Article {
	
	private int id;
	private String reference;
	private long stock;
	private boolean discontinued;
	
	public Article(int id, String reference) {
		
		this.id = id;
		this.reference = reference;
		this.stock = 0;
		this.discontinued = false;
		
	}
	
	public Article(int id, String reference, long stock, boolean discontinued) {
		
		this.id = id;
		this.reference = reference;
		this.stock = stock;
		this.discontinued = discontinued;
		
	}
	
	public int getID() {
		
		return id;
		
	}
	
	public String getReference() {
		
		return reference;
		
	}
	
	public void setStock(long stock) {
		
		this.stock = stock;
		
	}
	
	public long getStock() {
		
		return stock;
		
	}
	
	public void setDisontinued(boolean discontinued) {
		
		this.discontinued = discontinued;
		
	}
	
	public boolean isDiscontinued() {
		
		return discontinued;
		
	}

}

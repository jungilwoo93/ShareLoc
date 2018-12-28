package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Service {
	@Id
	private Colocation coloc;
	private String title;
	private String description;
	private int cost;
	
	
	public Colocation getColoc() {
		return coloc;
	}
	public void setColoc(Colocation coloc) {
		this.coloc = coloc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}

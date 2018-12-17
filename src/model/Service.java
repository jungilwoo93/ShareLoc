package model;

import javax.persistence.Column;

public class Service {
	
	private int pk;
	
	private Colocation coloc;

	private String title;
	
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	private String description;
	private double cost;
}

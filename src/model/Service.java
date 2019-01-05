package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String description;
	private String cost;
	
	private Colocation coloc;
	
	public Service() {
		
	}
	
	public Service(String title, String description, String cost) {
		//this.coloc=coloc;
		this.title=title;
		this.description=description;
		this.cost=cost;
	}
	
	public Service(Colocation coloc,String title, String description, String cost) {
		this.coloc=coloc;
		this.title=title;
		this.description=description;
		this.cost=cost;
	}
	
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
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
}

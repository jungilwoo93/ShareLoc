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
	private int cost;
	private User creator;// qui propose ce service
	private AchievedService achieved;
	private int pour;
	private int contre;
	
	private Colocation coloc;
	
	public Service() {
	}
	
	public Service(Colocation coloc,User creator,String title,String description, int cost) {
		this.coloc=coloc;
		this.creator=creator;
		this.title=title;
		this.description=description;
		this.cost=cost;
		//this.achieved=as;
	}
	
	public Service(String title, String description, int cost) {
		//this.coloc=new Colocation();
		this.title=title;
		this.description=description;
		this.cost=cost;
	}
	
	public Service(Colocation coloc,String title, String description, int cost) {
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public AchievedService getAchieved() {
		return achieved;
	}

	public void setAchieved(AchievedService achieved) {
		this.achieved = null;
		this.achieved=achieved;
	}

	public int getPour() {
		return pour;
	}

	public void setPour(int pour) {
		this.pour = pour;
	}

	public int getContre() {
		return contre;
	}

	public void setContre(int contre) {
		this.contre = contre;
	}
	
	
}

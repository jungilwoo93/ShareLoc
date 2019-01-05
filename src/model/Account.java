package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Colocation coloc;
	
	@OneToOne
	private User user;
	private int credit;
	
	public Account() {
		
	}
	
	public Account(Colocation c,User u) {
		this.coloc = c;
		this.user = u;
		this.credit=0;
	}
	
	public Account(Colocation c,User u,int point) {
		this.coloc = c;
		this.user = u;
		this.credit=point;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Colocation getColoc() {
		return coloc;
	}
	
	public void setColoc(Colocation coloc) {
		this.coloc = coloc;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public void addCredit(int point) {
		this.credit+=point;
	}
	
	public void reduceCredit(int point) {
		this.credit-=point;
	}
	
}

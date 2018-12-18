package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Table_Coloc")
public class Colocation {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int pk;
	@Column(name = "Name",nullable=false)
	private String name;
	
	private List<User> users;
	//private List<Service> missions;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}

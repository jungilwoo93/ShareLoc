package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Colocation {
	@Id
	@GeneratedValue
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

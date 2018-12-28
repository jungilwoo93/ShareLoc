package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Colocation {
	@Id
	public String name;
	
	public Colocation() {
		
	}
	
	public Colocation(String name) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

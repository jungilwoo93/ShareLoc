package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Table_User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int pk;
	@Column(name = "Email",nullable=false,unique=true)
	private String email;
	@Column(name = "Password",nullable=false)
	private String password;
	@Column(name="First_Name",length=100,nullable=false,unique=false)
	private String firstname;
	@Column(name="Last_Name",length=100,nullable=false,unique=false)
	private String lastname;
	
	/*public User(String email,String password,String firstname,String lastname) {
		this.setEmail(email);
		this.setPassword(password);
		this.setFirstname(firstname);
		this.setLastname(lastname);
	}*/
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

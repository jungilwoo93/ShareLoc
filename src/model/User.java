package model;

public class User {
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	
	public User(String email,String password,String firstname,String lastname) {
		this.setEmail(email);
		this.setPassword(password);
		this.setFirstname(firstname);
		this.setLastname(lastname);
	}

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
	
	
}

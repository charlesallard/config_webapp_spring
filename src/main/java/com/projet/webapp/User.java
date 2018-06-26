package com.projet.webapp;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;





public class User {

	
	
  
    @Length(min = 4)
    @Min(value = 1)
    private String pseudo;                
	
	@Min(value = 1)
	private int id;
	
	@Length(min = 1, max = 29)
	private String firstName;
	
	@Length(min = 1, max = 29)
	private String lastName;
	
	@Email
	private String email;
	
	@Length(min = 8)
	private String password;
	
	@PostalCode
	private String postalCode;
	
	
	public User() {
		
	}

	
	public User(int id, String firstName, String lastName, String email, String pseudo, String password, String postalCode) {
		this.postalCode = postalCode;
		this.pseudo = pseudo;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public User(int id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String email, String password) {
		this.id = -1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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
//////////////////////////////////////////////////////////
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
/////////////////////////////////////////////////////////////
	
	
	
}

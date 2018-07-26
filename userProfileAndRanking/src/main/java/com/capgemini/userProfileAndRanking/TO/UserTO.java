package com.capgemini.userProfileAndRanking.TO;

public class UserTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String motto;



	public UserTO(){
		
	}
	
	public UserTO(int id, String firstName, String lastName, String email,
			String password, String motto) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.motto = motto;
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


	public String getMotto() {
		return motto;
	}


	public void setMotto(String motto) {
		this.motto = motto;
	}

	

}

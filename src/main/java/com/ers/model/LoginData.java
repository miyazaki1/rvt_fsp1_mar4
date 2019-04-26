package com.ers.model;

public class LoginData {
	private int employee_id;
	private int job_id;


	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	public LoginData(int employee_id, int job_id, String username, String firstname, String lastname, String email,
			String password) {
		super();
		this.employee_id = employee_id;
		this.job_id = job_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public LoginData() {
		super();
	}
	
	public LoginData(int employee_id, int job_id, String username, String firstname, String lastname, String email) {
		super();
		this.employee_id = employee_id;
		this.job_id = job_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public LoginData(int employee_id, int job_id, String username, String firstname, String lastname) {
		super();
		this.employee_id = employee_id;
		this.job_id = job_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public LoginData(int employee_id, int job_id, String username) {
		super();
		this.employee_id = employee_id;
		this.job_id = job_id;
		this.username = username;
	}

	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
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
}

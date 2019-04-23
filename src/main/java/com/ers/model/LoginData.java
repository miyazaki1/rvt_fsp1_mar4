package com.ers.model;

public class LoginData {
	private int employee_id;
	private int job_id;
	private String username;
	public LoginData() {
		super();
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
}

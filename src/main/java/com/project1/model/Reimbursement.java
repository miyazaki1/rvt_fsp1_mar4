package com.project1.model;

import java.sql.Date;

public class Reimbursement {
	private int id;
	private int employee_id;
	private double amount;
	private int status_id;
	private Date request_date;
	private int manager_id;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, int employee_id, double amount, int status_id, Date request_date, int manager_id) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.amount = amount;
		this.status_id = status_id;
		this.request_date = request_date;
		this.manager_id = manager_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
}

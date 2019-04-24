package com.ers.dao;

import java.sql.Date;
import java.util.List;

import com.ers.model.Employee;
import com.ers.model.Reimbursement;

public interface ReimburseDao {
	List<Reimbursement> getAllReimbursements();
	List<Reimbursement> getAllApprovedReimbursements();
	List<Reimbursement> getAllDeclinedReimbursements();
	List<Reimbursement> getAllReimbursementsByEmployee(Employee employee);
	List<Reimbursement> getAllReimbursementsByDate(Date date);

	Reimbursement getReimbursementById(int id);
	void approveReimbursement(int id, int manager_id);
	void declineReimbursement(int id, int manager_id);

	Reimbursement addReimbursement(int employee_id, double amount, String description);
}

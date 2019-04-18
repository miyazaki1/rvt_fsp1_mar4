package com.project1.dao;

import java.sql.Date;
import java.util.List;

import com.project1.model.Employee;
import com.project1.model.Reimbursement;

public interface ReimburseDao {
	List<Reimbursement> getAllReimbursements();
	List<Reimbursement> getAllApprovedReimbursements();
	List<Reimbursement> getAllDeclinedReimbursements();
	List<Reimbursement> getAllReimbursementsByEmployee(Employee employee);
	List<Reimbursement> getAllReimbursementsByDate(Date date);

	Reimbursement getReimbursementById(int id);
	Reimbursement approveReimbursement();
	Reimbursement declineReimbursement();

	long removeReimbursement(Reimbursement...toBeDeleted);
}

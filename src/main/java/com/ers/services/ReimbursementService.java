package com.ers.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursement;

public interface ReimbursementService {
	List<Reimbursement> requestAllReimbursements(HttpServletRequest req, HttpServletResponse resp);
	Reimbursement createReimbursement(HttpServletRequest req, HttpServletResponse resp);
	Reimbursement approveReimbursement(HttpServletRequest req, HttpServletResponse resp);
	Reimbursement denyReimbursement(HttpServletRequest req, HttpServletResponse resp);
}

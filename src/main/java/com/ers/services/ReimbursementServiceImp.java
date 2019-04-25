package com.ers.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.ReimburseDao;
import com.ers.dao.ReimburseDaoImp;
import com.ers.model.Reimbursement;

public class ReimbursementServiceImp implements ReimbursementService {
	private final ReimburseDao dao = new ReimburseDaoImp();
	@Override
	public List<Reimbursement> requestAllReimbursements(HttpServletRequest req, HttpServletResponse resp) {
		
		return dao.getAllReimbursements();
	}
}

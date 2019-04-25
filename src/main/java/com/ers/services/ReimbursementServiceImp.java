package com.ers.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.ReimburseDao;
import com.ers.dao.ReimburseDaoImp;
import com.ers.model.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementServiceImp implements ReimbursementService {
	private final ReimburseDao dao = new ReimburseDaoImp();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<Reimbursement> requestAllReimbursements(HttpServletRequest req, HttpServletResponse resp) {		
		return dao.getAllReimbursements();
	}
	@Override
	public Reimbursement createReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("inside create");
		try {
			Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
			return dao.addReimbursement(reimbursement);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Reimbursement approveReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
			return dao.approveReimbursement(reimbursement.getId(), reimbursement.getEmployee_id());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
	}
	@Override
	public Reimbursement denyReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
			return dao.declineReimbursement(reimbursement.getId(), reimbursement.getEmployee_id());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
	}
}

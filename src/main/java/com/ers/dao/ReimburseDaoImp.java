package com.ers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.connection.ConnectionFactory;
import com.ers.model.Employee;
import com.ers.model.Reimbursement;

public class ReimburseDaoImp implements ReimburseDao{
	public static final String insert = "INSERT INTO Reimbursements (id, employee_id, amount, status_id, description, request_date, manager_id, decision_date) Values (?,?,?,?,?,?,?,?)";
	public static final String statusChange = "UPDATE Reimbursements Set status_id = ? , manager_id = ?, decision_date = ? where id = ?";
	public static final int approve_value = 2;
	public static final int decline_value = 3;
		
	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();	
		
		try(Connection conn = ConnectionFactory.getConnection()){
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Reimbursements");
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("id"), 
						rs.getInt("employee_id"),
						rs.getDouble("amount"),
						rs.getInt("status_id"),
						rs.getString("description"),
						rs.getDate("request_date"),
						rs.getInt("manager_id"),
						rs.getDate("decision_date")));
			}		
			return reimbursements;
		} catch (SQLException e){
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<Reimbursement> getAllApprovedReimbursements() {
		List<Reimbursement> approved = new ArrayList<>();	
		for(Reimbursement re : getAllReimbursements()) {			
			if(re.getStatus_id() == 2)			{
				approved.add(re);
			}
		}	
		return approved;
	}

	@Override
	public List<Reimbursement> getAllDeclinedReimbursements() {
		List<Reimbursement> declined = new ArrayList<>();	
		for(Reimbursement re : getAllReimbursements()) {			
			if(re.getStatus_id() == 3)			{
				declined.add(re);
			}
		}	
		return declined;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByEmployee(Employee employee) {
		List<Reimbursement> myReimb = new ArrayList<>();	
		for(Reimbursement re : getAllReimbursements()) {			
			if(re.getEmployee_id() == employee.getEmployee_id())			{
				myReimb.add(re);
			}
		}	
		return myReimb;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByDate(Date date) {
		List<Reimbursement> dateList = new ArrayList<>();	
		for(Reimbursement re : getAllReimbursements()) {			
			if(re.getRequest_date()== date)			{
				dateList.add(re);
			}
		}	
		return dateList;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		
		for(Reimbursement re : getAllReimbursements()) {
			if(re.getId() == id) { return re; }
		}	
		return null;
	}

	@Override
	public void approveReimbursement(int id, int manager_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(statusChange);
			Date date = new Date(System.currentTimeMillis());
			
			stmt.setInt(1, approve_value);
			stmt.setInt(2, manager_id);
			stmt.setDate(3, Date.valueOf(date.toLocalDate()));
			stmt.setInt(4, id);

			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected ==1) {
				System.out.println("Approve Successful");
			}	
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void declineReimbursement(int id, int manager_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(statusChange);
			Date date = new Date(System.currentTimeMillis());
			
			stmt.setInt(1, decline_value);
			stmt.setInt(2, manager_id);
			stmt.setDate(3, Date.valueOf(date.toLocalDate()));
			stmt.setInt(4, id);

			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected ==1) {
				System.out.println("Decline Successful");
			}	
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Reimbursement addReimbursement(int employee_id, double amount, String description) {
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(insert);
			Date date = new Date(System.currentTimeMillis());
			
			stmt.setInt(1, getAllReimbursements().size() + 1);
			stmt.setInt(2, employee_id);
			stmt.setDouble(3, amount);
			stmt.setInt(4, 1);
			stmt.setString(5, description);
			stmt.setDate(6, date);
			stmt.setNull(7, 0);
			stmt.setNull(8, 0);

			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected ==1) {
				System.out.println("Create Reimbursement Successful");
			}				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(insert);
			Date date = new Date(System.currentTimeMillis());
			
			stmt.setInt(1, getAllReimbursements().size() + 1);
			stmt.setInt(2, reimbursement.getEmployee_id());
			stmt.setDouble(3, reimbursement.getAmount());
			stmt.setInt(4, 1);
			stmt.setString(5, reimbursement.getDescription());
			stmt.setDate(6, date);
			stmt.setNull(7, 0);
			stmt.setNull(8, 0);

			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected ==1) {
				System.out.println("Create Reimbursement Successful");
			}				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

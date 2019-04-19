package com.project1.connection;

import java.util.List;

import org.junit.Test;

import com.project1.dao.EmployeeDao;
import com.project1.dao.EmployeeDaoImp;
import com.project1.dao.LoginDao;
import com.project1.dao.LoginDaoImp;
import com.project1.dao.ReimburseDao;
import com.project1.dao.ReimburseDaoImp;
import com.project1.model.Employee;
import com.project1.model.Reimbursement;

public class ConnectionFactoryTest {
	
	private EmployeeDao dao = new EmployeeDaoImp();
	private ReimburseDao rdao = new ReimburseDaoImp();
	private LoginDao ldao = new LoginDaoImp();
	
	@Test
	public void getAllEmployees() {
		List<Employee> employees = dao.getAllEmployees();
		
		for(Employee emp : employees) {
			System.out.println("Printing first name in test: " + emp.getFirst_name());
		}
	}
	
	//@Test
	public void addEmployee() {
		
		int eID = dao.getAllEmployees().size() + 1;
		String firstName = "Rick";
		String lastName = "Astley";
		String email = "some@email.com";
		int jID = 1;
		String username = "randomUser";
		String password = "aPassword";
		Employee employee = new Employee(eID, firstName, lastName, email, jID, username, password);
		dao.addEmployee(employee);
	}
	
	//@Test
	public void updateEmployee() {
		System.out.println("update Employee attempt");
		int eID = 1;
		String firstName = "Rick";
		String lastName = "Astley";
		String email = "some@email.com";
		int jID = 1;
		String username = "randomUser";
		String password = "aPassword";
		
		Employee employee = new Employee(eID, firstName, lastName, email, jID, username, password);
		dao.updateEmployee(employee);
		
		getAllEmployees();
	}
	
	//@Test
	public void approveReimbursement() {
		rdao.approveReimbursement(1, 2);
	}
	
	//@Test
	public void addReimbursement() {
		rdao.addReimbursement(1, 204.00, "TV");
	}
	
	@Test
	public void getAllReimbursements() {
		List<Reimbursement> reimb = rdao.getAllReimbursements();
		
		for(Reimbursement re : reimb) {
			System.out.println("id: " + re.getId() + " em_id: " + re.getEmployee_id() + " amount: " + re.getAmount());
		}
	}
	
	@Test
	public void testLogin()	{
		ldao.attemptAuthentication("dm", "pw1");
	}
	
}

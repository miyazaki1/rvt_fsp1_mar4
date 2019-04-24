package com.ers.util;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.ers.connection.ConnectionFactory;
import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImp;
import com.ers.dao.LoginDao;
import com.ers.dao.LoginDaoImp;
import com.ers.dao.ReimburseDao;
import com.ers.dao.ReimburseDaoImp;
import com.ers.model.Employee;
import com.ers.model.Reimbursement;

public class ConnectionFactoryTest {
	
	private EmployeeDao dao = new EmployeeDaoImp();
	private ReimburseDao rdao = new ReimburseDaoImp();
	private LoginDao ldao = new LoginDaoImp();
	
	@Test
	public void getAllEmployees() {
		
		System.out.println("#### Get All Employee Test ####");
		List<Employee> employees = dao.getAllEmployees();
		
		for(Employee emp : employees) {
			System.out.println("Printing first name in test: " + emp.getFirst_name());
		}
		
		System.out.println("####   End of Test  ####\n\n");
	}
	
	//@Test
	public void addEmployee() {
		
		System.out.println("#### Add Employee Test ####");
		
		int eID = dao.getAllEmployees().size() + 1;
		String firstName = "Rick";
		String lastName = "Astley";
		String email = "some@email.com";
		int jID = 1;
		String username = "randomUser";
		String password = "aPassword";
		Employee employee = new Employee(eID, firstName, lastName, email, jID, username, password);
		dao.addEmployee(employee);
		
		System.out.println("####   End of Test  ####\n\n");
	}
	
	//@Test
	public void updateEmployee() {
		System.out.println("#### Update Employee Info Test ####");

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
		
		System.out.println("####   End of Test  ####\n\n");
	}
	
	//@Test
	public void approveReimbursement() {
		System.out.println("#### Approve Reimbursement Info Test ####");

		rdao.approveReimbursement(1, 2);
		
		System.out.println("####   End of Test  ####\n\n");
	}
	
	//@Test
	public void addReimbursement() {
		System.out.println("#### Add Reimbursement Test ####");

		rdao.addReimbursement(1, 204.00, "TV");
		
		System.out.println("#### End of <addReimbursement> Test ####\n\n");
	}
	
	@Test
	public void getAllReimbursements() {
		
		System.out.println("#### Get All Reimbursement Test ####");

		List<Reimbursement> reimb = rdao.getAllReimbursements();
		
		for(Reimbursement re : reimb) {
			System.out.println("id: " + re.getId() + " em_id: " + re.getEmployee_id() + " amount: " + re.getAmount());
		}
		
		System.out.println("#### End of <getAllReimbursements> Test ####\n\n");
	}
	
	@Test
	public void testLoginServlet()	{
		System.out.println("#### Test Login Servlet ####");
		ldao.attemptAuthentication("dmarlene", "p1");
		System.out.println("#### End of <testLoginServlet> Test ####\n\n");
	}	
	
//	@Test
//	public void GetJDBC() {
//		Properties props = ConnectionFactory.getJdbcProperties();		
//		System.out.println(props.getProperty("jdbc.url"));
//		System.out.println(props.getProperty("jdbc.username"));
//		System.out.println(props.getProperty("jdbc.password"));
//	}
}

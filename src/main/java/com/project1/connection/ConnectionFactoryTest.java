package com.project1.connection;

import java.util.List;

import org.junit.Test;

import com.project1.dao.EmployeeDao;
import com.project1.dao.EmployeeDaoImpl;
import com.project1.model.Employee;

public class ConnectionFactoryTest {
	
	private EmployeeDao dao = new EmployeeDaoImpl();
	
	@Test
	public void getAllEmployeees() {
		List<Employee> employees = dao.getAllEmployees();
		
		for(Employee emp : employees) {
			System.out.println(emp.getFirst_name());
		}
	}
	
	@Test
	public void addEmployee() {
		//Employee employee = new Employee(3,"FN", "LN", "EM", 1);
		//dao.addEmployee(employee);
	}
}

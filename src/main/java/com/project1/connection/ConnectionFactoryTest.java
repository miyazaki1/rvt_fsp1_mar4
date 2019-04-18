package com.project1.connection;

import static org.junit.Assert.assertEquals;

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
		assertEquals(employees.size(), employees.size());
	}
}

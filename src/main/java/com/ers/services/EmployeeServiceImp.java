package com.ers.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImp;
import com.ers.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeServiceImp implements EmployeeService{

	private final EmployeeDao dao = new EmployeeDaoImp();
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<Employee> getAllEmployees(HttpServletRequest request, HttpServletResponse response) {		
		return dao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee emp = mapper.readValue(request.getInputStream(), Employee.class);
			return  dao.getEmployeeById(emp.getEmployee_id());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee addEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee emp = mapper.readValue(request.getInputStream(), Employee.class);
			return  dao.addEmployee(emp);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee emp = mapper.readValue(request.getInputStream(), Employee.class);
			
			
//			emp.setUsername(request.getSession().getAttribute("username").toString());
//			emp.setJob_id(Integer.valueOf(request.getSession().getAttribute("job_id").toString()));
//			emp.setEmployee_id(Integer.valueOf(request.getSession().getAttribute("employee_id").toString()));
//			emp.setFirst_name(request.getSession().getAttribute("firstname").toString());
//			emp.setLast_name(request.getSession().getAttribute("lastname").toString());
//			emp.setPassword( request.getSession().getAttribute("password").toString());
			
			
		 System.out.println("Inside Update Employee:" + emp);
			request.getSession().setAttribute("email", emp.getEmail());
			
			
			return  dao.updateEmployee(emp);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public long removeEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee emp = mapper.readValue(request.getInputStream(), Employee.class);
			return  dao.removeEmployee(emp);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}

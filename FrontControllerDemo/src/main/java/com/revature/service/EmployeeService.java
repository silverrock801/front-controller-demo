package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.dao.EmployeeDAO;
import com.revature.models.Employee;

/**
 * The Service layer is responsible for the business ( or application) logic
 * Whereas the DAO layer is responsible for persistence logic (anything to do with the session)
 * and Hibernate's Session methods
 */
public class EmployeeService {

	//The service class needs to call on the DAO layer to perform ops on the EMployee objects
	private EmployeeDAO edao;
	
	//This is dependency INjection by way of Constructor Injection
	
	//Every time we instantiate an EmployeeSErvice object, it has a full initialized DAO
	public EmployeeService(EmployeeDAO edao) {
		super();
		this.edao = edao;
	}
	/**
	 * The confimLogin() method will return the Employee that has
	 * successfully logged in(meaning that their username and password match a
	 * unique record in the DB.) IF the username & pass DOESN"T match a record,
	 * return null;
	 */
	
	public Employee confirmLogin(String username, String password) {
		
		//call the findAll() method
		Optional<Employee> possibleEmp = edao.findAll()
		//stream() through the records, and find the first wshose username and password matches
		.stream()
		.filter(e -> (e.getUsername().equals(username) && e.getPassword().equals(password)))
		.findFirst();
		
		return (possibleEmp.isPresent() ? possibleEmp.get() : null);
		
	}
	
	//findall
	public List<Employee> findAll(){
		return edao.findAll();	
	}
	public int insert(Employee e) {
		
		return edao.insert(e);
	}
	
	public boolean update(Employee e) {
		
		return edao.update(e);
	}
	
	public boolean delete(Employee e) {
		
		return edao.delete(e);
	}
	
}

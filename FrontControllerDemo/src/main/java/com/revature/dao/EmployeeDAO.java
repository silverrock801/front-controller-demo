package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDAO {

	public int insert(Employee e) {
		//Grab session object
		Session ses = HibernateUtil.getSession();//Session in the context of JDBC connection
		//begin a tx
		Transaction tx = ses.beginTransaction();
		
		//capture the pk returned from save()
		int pk = (int) ses.save(e);
		
		//commit tx
		tx.commit();
		
		//return pk
		return pk;
	}
	
	public List<Employee> findAll(){
		
		//grab the session
		Session ses = HibernateUtil.getSession();
		
		//Make a HQL statement to return all records from the Employee table - mix of SQL & OOP
		List<Employee> emps = ses.createQuery("from Employee", Employee.class).list();
		
		//There's also Criteria API & Native SQL are other ways to write complex queries
		
		//return as a list
		return emps;
	}
	
	public boolean update(Employee e) {
		return false;
	}
	
	public boolean delete(Employee e) {
		return false;
	}
}

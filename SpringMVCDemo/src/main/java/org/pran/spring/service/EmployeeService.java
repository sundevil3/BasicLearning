package org.pran.spring.service;

import java.util.List;

import org.pran.spring.model.Employee;

/**
 * @author  Prannoy Chandra
 *
 */
public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeid);

	public Employee updateEmployee(Employee employee);

	public Employee validateUser(String userName, String password);
}

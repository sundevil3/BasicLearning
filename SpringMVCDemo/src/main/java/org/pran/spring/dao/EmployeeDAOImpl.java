package org.pran.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pran.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author  Prannoy Chandra
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
	}

	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, empid);
	}

	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	@SuppressWarnings("unchecked")
	public Employee validateUser(String userName, String password) {
		/*StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT * FROM EMPLOYEE WHERE USERNAME ='")
		.append(userName)
		.append("' AND PASSWORD ='")
		.append("';");*/
		String sqlQuery = "SELECT * FROM EMPLOYEE WHERE USERNAME='" + userName + "' AND PASSWORD ='" + password + "' ;";
		Query query =  sessionFactory.getCurrentSession().createSQLQuery(sqlQuery).addEntity(Employee.class);
		List<Employee> result = query.list();
		Employee employee = new Employee();
		if(!result.isEmpty()) {
		employee = result.get(0);
		} else {
			employee = null;
		}
		return employee;
	}

}
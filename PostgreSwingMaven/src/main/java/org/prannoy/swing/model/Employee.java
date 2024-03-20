package org.prannoy.swing.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.prannoy.swing.utils.PostgresUtils;

public class Employee implements Runnable{

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String salary;
	private static int rowCount = 1;
	private static String[][] employeeDataFromCSV;
	private int threadNum;
	static Object lock = new Object();
	static Logger logger = Logger.getLogger(Employee.class.getName());
	
	public Employee (String[][] empData, int rowCountOfCSV) {
		employeeDataFromCSV = empData;
	}
	
	public Employee (int threadNum) {
		this.threadNum = threadNum;
	}
	
	public Employee (String fname, String lname, String email, String salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", salary=" + salary + ", threadNum=" + threadNum + "]";
	}

	public void run() {
		while (rowCount <= employeeDataFromCSV.length-9) {
			synchronized (lock) {
				while (rowCount % 10 != threadNum) {
					try {
						lock.wait();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Connection conn1 = null;
				PreparedStatement preparedStatement = null;
				Employee rString = new Employee(employeeDataFromCSV[rowCount-1][0],employeeDataFromCSV[rowCount-1][1],employeeDataFromCSV[rowCount-1][2],employeeDataFromCSV[rowCount-1][3]);
					try {
						Class.forName(PostgresUtils.JDBC_DRIVER);
						conn1 = DriverManager.getConnection(PostgresUtils.DB_URL, PostgresUtils.USER, PostgresUtils.PASS);
						String sql = "INSERT INTO \"EMPLOYEE\"(\"FNAME\", \"LNAME\", \"EMAIL\", \"SALARY\") VALUES (?, ?, ?, ?)";
						preparedStatement = conn1.prepareStatement(sql);
						preparedStatement.setString(1, rString.getFirstName());
						preparedStatement.setString(2, rString.getLastName());
						preparedStatement.setString(3, rString.getEmail());
						preparedStatement.setString(4, rString.getSalary());
						preparedStatement.execute();
						logger.debug("Record "+rString.toString()+" has been inserted using the Thread Num: "+ threadNum);
						preparedStatement.close();
						conn1.close();
						
					}	catch (Exception e) {
						e.printStackTrace();
					}
				rowCount++;
				lock.notifyAll();
			}
		}
		
		
	}
	
	
}

package org.prannoy.swing.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Employee implements Runnable{

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String salary;
	private static int rowCount = 1;
	private static String[][] employeeDataFromCSV;
	private int threadNum;
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Blockbuster";
	static final String USER = "prannoy2";
	static final String PASS = "1234";
	static Object lock = new Object();
	
	
	public Employee (String[][] empData, int rowCountOfCSV) {
		employeeDataFromCSV = empData;
	/*	for(int r=0;r<rowCountOfCSV;r++) {
			System.out.println("printing inside constructor");
			System.out.println(employeeDataFromCSV[r][0]+"," +employeeDataFromCSV[r][1]+"," +employeeDataFromCSV[r][2]+"," +employeeDataFromCSV[r][3]);	
		}*/
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
						Class.forName(JDBC_DRIVER);
						conn1 = DriverManager.getConnection(DB_URL, USER, PASS);
						String sql = "INSERT INTO \"EMPLOYEE\"(\"FNAME\", \"LNAME\", \"EMAIL\", \"SALARY\") VALUES (?, ?, ?, ?)";
						preparedStatement = conn1.prepareStatement(sql);
						preparedStatement.setString(1, rString.getFirstName());
						preparedStatement.setString(2, rString.getLastName());
						preparedStatement.setString(3, rString.getEmail());
						preparedStatement.setString(4, rString.getSalary());
						preparedStatement.execute();
						System.out.println(employeeDataFromCSV[rowCount-1][0]+"," +employeeDataFromCSV[rowCount-1][1]+"," +employeeDataFromCSV[rowCount-1][2]+"," +employeeDataFromCSV[rowCount-1][3]+"Inserted using Thread-"+threadNum); 
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

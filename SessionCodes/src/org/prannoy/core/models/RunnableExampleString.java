package org.prannoy.core.models;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.opencsv.CSVReader;

public class RunnableExampleString implements Runnable{

	private String firstName;
	private String lastName;
	private String email;
	private String salary;
	private static int rowCount = 1;
	private static String[][] employeeDataFromCSV;
	int threadNum;
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Blockbuster";
	static final String USER = "prannoy2";
	static final String PASS = "1234";

	static Object lock = new Object();

	public RunnableExampleString (String[][] empData, int rowCountFromCSV)
	{
		employeeDataFromCSV = empData;
		/*for(int r=0;r<rowCountFromCSV;r++) {
			System.out.println(employeeDataFromCSV[r][0]+"," +employeeDataFromCSV[r][1]+"," +employeeDataFromCSV[r][2]+"," +employeeDataFromCSV[r][3]);	
	}*/
		
	}

	public RunnableExampleString (String firstName, String lastName, String email, String salary)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.salary=salary;
	}

	public RunnableExampleString (int threadNum)
	{
		this.threadNum = threadNum;
		System.out.println("Creating Thread-" +  threadNum );
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}



	@Override
	public void run() {
		long currentTime = System.currentTimeMillis();
		//System.out.println("Running Thread-" +  threadNum );
		while ((rowCount <= employeeDataFromCSV.length-9) /*&& (rowCount % 10 == threadNum)*/) {
					Connection conn1 = null;
					PreparedStatement preparedStatement = null;
						RunnableExampleString rString = new RunnableExampleString(employeeDataFromCSV[rowCount-1][0],employeeDataFromCSV[rowCount-1][1],employeeDataFromCSV[rowCount-1][2],employeeDataFromCSV[rowCount-1][3]);
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
							//System.out.println("Thread-"+threadNum+" inserted "+ employeeDataFromCSV[rowCount-1][0]+"," +employeeDataFromCSV[rowCount-1][1]+"," +employeeDataFromCSV[rowCount-1][2]+"," +employeeDataFromCSV[rowCount-1][3]);
							preparedStatement.close();
							conn1.close();
							
						}	catch (Exception e) {
							e.printStackTrace();
						}
						
				rowCount++;
		}
		
		long currentTime2 = System.currentTimeMillis();
		System.out.println("Time taken for 30K rows is: "+ (currentTime2 - currentTime));
	}
}

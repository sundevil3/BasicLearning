package org.restful.serv.dao;

import org.restful.serv.model.Student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {


	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/restfulservices?autoReconnect=true";
	private static final String DB_USER = "prannoys21";
	private static final String DB_PASSWORD = "root";
	private Connection connection = null;

	public StudentDAO() {

	}

	public void defaultStudent() {
		createStudent(1, "Vikram Modugu", 34);
	}

	public boolean addStudent(Student student) {
		return createStudent(student.getId(), student.getName(), student.getAge());
	}

	public boolean createStudent(int id, String name, int age) {

		boolean createStatus = false;
		Connection connection;
		Statement statement = null;
		try {
			connection = getDBConnection();
			statement = connection.createStatement();

			String sqlCreate = "insert into student(student_id, student_age, student_name) values(" + id + "," + age + ", '" + name + "')";
			createStatus = statement.execute(sqlCreate);
			System.out.println("The record creation status: " + createStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeStatement(statement);
			//            closeConnection();
		}
		return createStatus;
	}

	public Student getStudent(int id) {
		Connection connection;
		Statement statement = null;
		ResultSet resultSet;
		Student student = null;

		try {
			connection = getDBConnection();
			statement = connection.createStatement();

			String sql = "SELECT student_id, student_name, student_age from student where student_id=" + id;
			resultSet = statement.executeQuery(sql);
			student = new Student();
			while (resultSet.next()) {
				//Retrieve by column name
				int student_id = resultSet.getInt("student_id");
				int student_age = resultSet.getInt("student_age");
				String student_name = resultSet.getString("student_name");


				//Display values
				System.out.println("student_id: " + student_id+", student_age: " + student_age+", student_name: " + student_name);

				student.setAge(student_age);
				student.setName(student_name);
				student.setId(student_id);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeStatement(statement);
			//            closeConnection();
		}
		return student;
	}

	public List<Student> getAllStudents() {

		List<Student> students = new ArrayList<Student>();
		Connection connection;
		Statement statement = null;
		ResultSet resultSet;

		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			String sql = "SELECT id, name, age from student";
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				//Retrieve by column name
				int student_id = resultSet.getInt("id");
				String student_name = resultSet.getString("name");
				int student_age = resultSet.getInt("age");



				//Display values
				System.out.print("student_id: " + student_id);
				System.out.print(", student_age: " + student_age);
				System.out.print(", student_name: " + student_name);
				Student student = new Student();
				student.setAge(student_age);
				student.setName(student_name);
				student.setId(student_id);
				students.add(student);
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			closeStatement(statement);
			//            closeConnection();
		}
		return students;
	}

	public boolean deleteStudent(int id) {
		Connection connection;
		Statement statement = null;
		boolean deleteStatus = false;

		try {
			connection = getDBConnection();
			statement = connection.createStatement();

			String sqlDelete = "delete from student where id=" + id;
			deleteStatus = statement.execute(sqlDelete);
			System.out.println("The record deletion status: " + deleteStatus);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeStatement(statement);
			//            closeConnection();
		}
		return deleteStatus;
	}

	public boolean upateStudent(int id, String name, int age) {
		boolean updateStatus = false;
		Connection connection;
		Statement statement = null;

		try {
			connection = getDBConnection();
			statement = connection.createStatement();

			String sqlUpdate = "update student set age=" + age + ", name='" + name + "' where id=" + id;
			System.out.println("update query: "+sqlUpdate);
			updateStatus = statement.execute(sqlUpdate);
			System.out.println("The record update status: " + updateStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeStatement(statement);
			//            closeConnection();
		}
		return updateStatus;
	}

	private Connection getDBConnection() {
		try {
			if (connection == null) {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				return connection;
			} else {
				return connection;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}

	@SuppressWarnings("unused")
	private void closeConnection() {
		try {
			connection.close();
		} catch (Exception ex) {
		}
	}

	private void closeStatement(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception ex) {
		}
	}
}

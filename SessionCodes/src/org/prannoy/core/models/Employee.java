package org.prannoy.core.models;
/**
 * @author  Prannoy Chandra
 *
 */
public class Employee {

	//private static final long serialVersionUID = -3465813074586302847L;

	private int id;

	private String firstName;
	
	private String surName;


	private String userName;

	private String password;
	
	private int age;
	
	public Employee (String firstName, String surName, String userName, String password, int age) {
		this.firstName = firstName;
		this.surName = surName;
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String surName, String userName, String password, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.userName = userName;
		this.password = password;
		this.age = age;
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

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", userName=" + userName
				+ ", password=" + password + ", age=" + age + "]";
	}


}
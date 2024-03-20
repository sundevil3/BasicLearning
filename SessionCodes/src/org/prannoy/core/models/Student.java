package org.prannoy.core.models;
/**
 * @author  Prannoy Chandra
 *
 */
public class Student {


	private String firstName;

	private String userName;

	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	} 
	
	public Student (String firstName,  String userName, int age) {
		this.firstName = firstName;
		this.userName = userName;
		this.age = age;
	}


	public String toString(Student student) {
		String finalStr = student.getFirstName() + " "+ student.getUserName() +  " " + student.getAge();
		return finalStr;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
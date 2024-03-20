import org.apache.log4j.Logger;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String salary;
	private int threadNum;
	static Object lock = new Object();
	static Logger logger = Logger.getLogger(Employee.class.getName());
	
	public Employee (String[][] empData, int rowCountOfCSV) {
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
	
}

package org.prannoy.core.tests;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.prannoy.core.models.Employee;

public class Test {

	public static void main(String args[]) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1,"pawan", "kalyan", "pspk", "thammudu", 25));
		empList.add(new Employee(2,"mahesh", "babu", "ssmb", "maharshi", 26));
		empList.add(new Employee(3,"chiranjeevi", "ko", "megastar", "syera", 27));
		empList.add(new Employee(4,"ram", "charan", "mps", "magadheera", 28));
		empList.add(new Employee(5,"vijay", "devera", "arjun", "reddy", 29));

		Iterator<Employee> iterator = empList.listIterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}

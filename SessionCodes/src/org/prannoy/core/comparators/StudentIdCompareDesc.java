package org.prannoy.core.comparators;
import java.util.Comparator;
import java.util.Date;

import org.prannoy.core.models.Student;


public class StudentIdCompareDesc implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getAge() == student2.getAge()) {
			return 0;
		} else if (student1.getAge() > student2.getAge()) {
			return -1;
		}
		return 1;
	}
	
	
	public String hashCode(Student student) {
		StringBuilder sb =  new StringBuilder();
		sb.append(student.getAge());
		sb.append("+");
		sb.append(new Date());
		return sb.toString();
	}
}

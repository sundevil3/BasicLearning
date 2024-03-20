package org.prannoy.core.tests;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.prannoy.core.comparators.StudentIdCompareAsc;
import org.prannoy.core.comparators.StudentIdCompareDesc;
import org.prannoy.core.models.Student;

public class Test2 {

	public static void main(String args[]) {
		Student stud= new Student();
		Student stud2= new Student();
		Set<Student> studList = new TreeSet<Student>(new StudentIdCompareAsc()); //for Ascending
		Set<Student> studList2 = new TreeSet<Student>(new StudentIdCompareDesc()); ////for Descending
		studList.add(new Student("pawan", "thammudu", 29));
		studList.add(new Student("mahesh", "maharshi", 28));
		studList.add(new Student("chiranjeevi", "syera", 27));
		studList.add(new Student("ram", "magadheera", 26));
		studList.add(new Student("vijay", "reddy", 22));


		Iterator<Student> iterator = studList.iterator();
		Iterator<Student> iterator2 = studList2.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(stud.toString(iterator.next()));
		}
		
		while(iterator.hasNext()) {
			System.out.println(stud2.toString(iterator2.next()));
		}

	}

}

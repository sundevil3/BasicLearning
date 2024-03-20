package org.prannoy.core.models;

import java.util.Iterator;

public class EmployeeGenericMain <E>{
	E obj;
	
	
	public EmployeeGenericMain(E obj) {
		//super();
		this.obj = obj;
	}
	public E getObj() {
		return obj;
	}
	

	public <E> void printArray(Iterator<E> obj) {
		
		while(obj.hasNext()) {
			System.out.println(obj.next());
		}
		System.out.println();
	}


	public static void main(String args[]) {
		
		/*List<Integer> nest = new ArrayList<Integer>();
		nest.add(1);
		nest.add(19);
		nest.add(0);
		nest.add(23);
		Iterator<Integer> iterator = nest.listIterator();*/
		//EmployeeGenericMain<List<String>>  egm = new EmployeeGenericMain<List<String>>(nest);
		//egm.printArray(iterator);
	        String s1 = new String("HELLO"); 
	        String s2 = new String("HELLO"); 
	        System.out.println(s1 == s2); 
	        System.out.println(s1.equals(s2)); 

	}
}


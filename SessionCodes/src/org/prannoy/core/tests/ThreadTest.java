package org.prannoy.core.tests;

import org.prannoy.core.models.ThreadExample;

public class ThreadTest {

	public static void main(String args[]) {
		Thread t1 = new ThreadExample(1);
		Thread t2 = new ThreadExample(2);
		Thread t3 = new ThreadExample(3);
		Thread t4 = new ThreadExample(4);
		Thread t5 = new ThreadExample(5);
		Thread t6 = new ThreadExample(6);
		Thread t7 = new ThreadExample(7);
		Thread t8 = new ThreadExample(8);
		Thread t9 = new ThreadExample(9);
		Thread t10 = new ThreadExample(0);
		
		t1.start();
		//t1.run();
		
		t2.start();
		//t2.run();
		
		t3.start();
		//t3.run();
		
		t4.start();
		//t4.run();
		
		t5.start();
		//t5.run();
		
		t6.start();
		//t6.run();
		
		t7.start();
		//t7.run();
		
		t8.start();
		//t8.run();
		
		t9.start();
		//t9.run();
		
		t10.start();
		//t10.run();
		
	}
}

package org.prannoy.core.tests;

import org.prannoy.core.models.RunnableExample;

public class RunnableTest {
	public static void main(String args[]) {
		
		RunnableExample runnableExample1 = new RunnableExample(1);
		RunnableExample runnableExample2 = new RunnableExample(2);
		RunnableExample runnableExample3 = new RunnableExample(3);
		RunnableExample runnableExample4 = new RunnableExample(4);
		RunnableExample runnableExample5 = new RunnableExample(5);
		RunnableExample runnableExample6 = new RunnableExample(6);
		RunnableExample runnableExample7 = new RunnableExample(7);
		RunnableExample runnableExample8 = new RunnableExample(8);
		RunnableExample runnableExample9 = new RunnableExample(9);
		RunnableExample runnableExample10 = new RunnableExample(0);
		
		Thread t1 = new Thread(runnableExample1, "1");
		Thread t2 = new Thread(runnableExample2, "2");
		Thread t3 = new Thread(runnableExample3, "3");
		Thread t4 = new Thread(runnableExample4, "4");
		Thread t5 = new Thread(runnableExample5, "5");
		Thread t6 = new Thread(runnableExample6, "6");
		Thread t7 = new Thread(runnableExample7, "7");
		Thread t8 = new Thread(runnableExample8, "8");
		Thread t9 = new Thread(runnableExample9, "9");
		Thread t10 = new Thread(runnableExample10, "10");
		
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

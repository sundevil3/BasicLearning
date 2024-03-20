package org.prannoy.core.models;

public class RunnableExample implements Runnable{

	public static final int PRINT_NUMBERS_UPTO=100;
	static int  number=1;
	int remainder;
	static Object lock=new Object();
 
	public RunnableExample (int remainder)
	{
		this.remainder=remainder;
	}
 
	@Override
	public void run() {
		while (number <= PRINT_NUMBERS_UPTO - 9) {
			synchronized (lock) {
				while (number % 10 != remainder) {
					try {
						lock.wait();
					} catch (Exception e) {
						//number++;
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
}

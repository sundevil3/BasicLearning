package org.prannoy.core.models;

import java.util.LinkedList;

public class ProducerConsumer { 
	LinkedList<Integer> list = new LinkedList<>(); 
	int capacity = 1; 

	public void produce() throws InterruptedException 
	{ 
		int value = 0; 
		while (true) 
		{ 
			synchronized (this) 
			{ 
				while (list.size()==capacity) {
					wait(); 
				}
				System.out.println("Produced Value-" + value); 
				list.add(value++); 
				notify(); 
				Thread.sleep(1000); 
			} 
		} 
	} 

	public void consume() throws InterruptedException 
	{ 
		while (true) 
		{ 
			synchronized (this) 
			{ 
				while (list.size()==0) {
					wait();
				}
				int val = list.removeFirst(); 
				System.out.println("Consumed Value-" + val); 
				notify(); 
				Thread.sleep(1000); 
			} 
		} 
	} 
} 
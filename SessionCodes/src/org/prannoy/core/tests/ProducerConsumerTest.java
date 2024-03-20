package org.prannoy.core.tests;

import org.prannoy.core.models.ProducerConsumer;

public class ProducerConsumerTest {

	public static void main(String[] args)	 
	{ 
		final ProducerConsumer producerConsumer = new ProducerConsumer(); 
		Thread t1 = new Thread(new Runnable() 
		{ 
			@Override
			public void run() 
			{ 
				try
				{ 
					producerConsumer.produce(); 
				} 
				catch(InterruptedException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
		}); 

		Thread t2 = new Thread(new Runnable() 
		{ 
			@Override
			public void run() 
			{ 
				try
				{ 
					producerConsumer.consume(); 
				} 
				catch(InterruptedException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
		}); 

		t1.start(); 
		t2.start(); 
		
	/*	try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	} 
}

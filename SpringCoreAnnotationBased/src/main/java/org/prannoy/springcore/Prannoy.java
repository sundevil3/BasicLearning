package org.prannoy.springcore;

import org.prannoy.springcore.model.Laptop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Prannoy {
	public static void main (String args[]) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	Laptop lt3 = factory.getBean(Laptop.class);
        lt3.getHardDrive().getHardDrive();
	}
}

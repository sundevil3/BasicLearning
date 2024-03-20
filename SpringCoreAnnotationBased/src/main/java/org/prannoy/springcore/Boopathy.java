package org.prannoy.springcore;

import org.prannoy.springcore.model.Laptop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Boopathy {
	public static void main (String args[]) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	Laptop lt2 = factory.getBean(Laptop.class);
        lt2.getHardDrive().getHardDrive();
	}
}

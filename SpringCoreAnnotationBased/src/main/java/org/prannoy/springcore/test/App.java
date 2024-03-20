package org.prannoy.springcore.test;

import org.prannoy.springcore.AppConfig;
import org.prannoy.springcore.model.Laptop;
import org.prannoy.springcore.service.HardDrive;
import org.prannoy.springcore.serviceImpl.SeagateHardDrive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	Laptop lt = factory.getBean(Laptop.class);
        lt.specs();
        System.out.println(lt.count);
        System.out.println(lt.name);
    	HardDrive hardDrive = factory.getBean(SeagateHardDrive.class);
        hardDrive.getHardDrive();
        
        /*DellHardDrive dellHardDrive = factory.getBean(DellHardDrive.class);
        dellHardDrive.getHardDrive();*/
    }
}

package org.prannoy.springcore.test;

import org.prannoy.springcore.model.Laptop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
    	ApplicationContext factory = new ClassPathXmlApplicationContext("org//prannoy//springcore//spring.xml");
    	Laptop lt = (Laptop) factory.getBean("laptop2");
        lt.specs();
        System.out.println(lt.getCount());
        System.out.println(lt.getName());
    }
}

package org.prannoy.springcore.model;

import org.prannoy.springcore.service.Display;
import org.prannoy.springcore.service.HardDrive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	public int count;
	
	
	public String name;
	
	@Autowired
	/*@Qualifier("dellHardDrive")*/ //Don't use this if using @Configuration and @Bean
	//Use @Qualifier only if you're using @ComponentScan(basePackages="org.prannoy.springcore")
	HardDrive hardDrive;
	
	@Autowired
	Display display;

	
	public void specs() {
		System.out.println("This is my laptop");
		hardDrive.getHardDrive();
		display.getDisplay();
	}

	public HardDrive getHardDrive() {
		return hardDrive;
	}


	public void setHardDrive(HardDrive hardDrive) {
		this.hardDrive = hardDrive;
	}
	
	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

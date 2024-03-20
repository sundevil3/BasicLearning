package org.prannoy.springcore.model;

import org.prannoy.springcore.service.HardDrive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	int count;
	String name;
	
	@Autowired
	@Qualifier("seagateHardDrive")
	HardDrive hd;

	
	public void specs() {
		System.out.println("This is my laptop");
		hd.getHardDrive();
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


	public HardDrive getHd() {
		return hd;
	}


	public void setHd(HardDrive hd) {
		this.hd = hd;
	}



}

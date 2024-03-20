package org.prannoy.springcore.serivceImpl;

import org.prannoy.springcore.service.HardDrive;
import org.springframework.stereotype.Component;

@Component
public class DellHardDrive implements HardDrive {

	public void getHardDrive() {
		System.out.println("This system has a Dell Hard Drive");
	}

}

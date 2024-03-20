package org.prannoy.springcore.serivceImpl;

import org.prannoy.springcore.service.HardDrive;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
/*@Primary*/
public class SeagateHardDrive implements HardDrive {

	public void getHardDrive() {
		System.out.println("This laptop has a Seagate Harddrive");
	}

}

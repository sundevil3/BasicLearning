package org.prannoy.springcore;

import org.prannoy.springcore.model.Laptop;
import org.prannoy.springcore.service.Display;
import org.prannoy.springcore.service.HardDrive;
import org.prannoy.springcore.serviceImpl.LgDisplay;
import org.prannoy.springcore.serviceImpl.SeagateHardDrive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
/*@ComponentScan(basePackages="org.prannoy.springcore")*/
@Configuration //Use this if @ComponentScan is not used and uncomment the @Bean annotations below
//Also, if you're using @Configuration, make sure to remove the @Qualifier("dellHardDrive") or @Qualifier("seagateHardDrive") in Laptop.java

public class AppConfig {
	
	@Bean
	public Laptop laptop() {
		/*return new Laptop();*/
		Laptop l1 = new Laptop();
		l1.count = 5;
		l1.name="Sarkar";
		return l1;
	}
	
	@Bean
	public HardDrive hardDrive() {
		HardDrive hd = new SeagateHardDrive();
		return hd;
	}
	
	/*@Bean
	public HardDrive hardDrive2() {
		HardDrive hd = new DellHardDrive();
		return hd;
	}*/
	
	@Bean
	public Display display() {
		Display display = new LgDisplay();
		return display;
	}
}

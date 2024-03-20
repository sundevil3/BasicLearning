package org.prannoy.core.models;

class CloneExample2 implements Cloneable{  
	int age;  
	String address;  

	CloneExample2(int age,String address){  
		this.age=age;  
		this.address=address;  
	}  
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}  

}  
package org.prannoy.core.tests;

import org.prannoy.core.models.SingleObj;

public class SingleObjTest {
	
	public static void main(String args[]) 
    { 
		SingleObj x = SingleObj.getInstance(); 
		SingleObj y = SingleObj.getInstance();
		
  
        String prompt = x.getS(); 
		  prompt = (prompt).toUpperCase(); 
  
        System.out.println("String from x is " + x.getS()); 
        System.out.println("String from y is " + y.getS()); 
        System.out.println("\n"); 
  
        String prompt2 = y.getS(); 
        prompt2 = (prompt2).toLowerCase(); 
  
        System.out.println("String from x is " + x.getS()); 
        System.out.println("String from y is " + y.getS()); 
    } 
}

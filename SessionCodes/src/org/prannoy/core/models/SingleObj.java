package org.prannoy.core.models;


public class SingleObj {

    private static SingleObj single_instance = new SingleObj(); 
; 
    private String s; 
  
    private SingleObj() 
    { 
        s = "Hello I am a string part of Singleton class"; 
    } 
  
    public static SingleObj getInstance() 
    { 
        return single_instance; 
    }

	public static SingleObj getSingle_instance() {
		return single_instance;
	}

	public static void setSingle_instance(SingleObj single_instance) {
		SingleObj.single_instance = single_instance;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	} 
    
    
}

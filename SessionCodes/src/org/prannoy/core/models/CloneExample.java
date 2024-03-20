package org.prannoy.core.models;

class CloneExample implements Cloneable{  
	int rollno;  
	String name;  
	CloneExample2 cloneExample2;

	CloneExample(int rollno,String name, CloneExample2 cloneExample2){  
		this.rollno=rollno;  
		this.name=name;  
		this.cloneExample2 = cloneExample2;
	}  

	public Object clone() throws CloneNotSupportedException {  
		//return super.clone(); // uncomment this for shallow cloning
		CloneExample clEx = (CloneExample)super.clone();
		clEx.cloneExample2 = (CloneExample2) cloneExample2.clone();
		return clEx;
	}  

	public static void main(String args[]){  
		try{  
			CloneExample2 ce2 = new CloneExample2(20,"Hello World");
			CloneExample ce1=new CloneExample(101,"amit",ce2);  
			
			
			
			CloneExample CEArr [] = new CloneExample[100];

			//System.out.println(s1.toString());
			
			for (int i = 0 ; i< 100; i++) {
				CEArr[i] = (CloneExample)ce1.clone();
				//CloneExample2 ce2 = (CloneExample2)ce.clone();
/*				System.out.println(CEArr[i].toString());
				System.out.println(CEArr[i].rollno);
				System.out.println(CEArr[i].name);
				System.out.println(CEArr[i].cloneExample2.address);
				System.out.println(CEArr[i].cloneExample2.age);*/
				System.out.println(CEArr[i].cloneExample2.toString());
			}

		}catch(CloneNotSupportedException c){}  

	}  
}  
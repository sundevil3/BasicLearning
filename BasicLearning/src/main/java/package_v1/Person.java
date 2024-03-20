//this is a sample code  to test out the JAVA compiler for learning purposes only
package package_v1;

import java.math.BigInteger;

public class Person {
	
	int age;
	String  name;
	double weight;

	public Person() {
		//super();
		age = 32;
		name = "Pawan";
		weight = 71.56;

	}
	
	public Person(int age, String name, double weight) {
		//super();
		this.age = age;
		this.name = name;
		this.weight = weight;
		//System.out.println();
	}

	public void eat() {
		//int a = 10001;
		System.out.println("he is eating food \n");
		//return a;
	}

	public void sleep() {
		System.out.println("he is sleeping");
	}

	public BigInteger GPACalculation(int a, int b, int c) {
		int d = a + b;//79
		int e = d * 23; // 1817
		int f = e + 46; // 1863
		int g = f*2; // 3726
		//long h = d*e*f*g;
		//System.out.println(" "+ d + " "+ e + " "+ f + "  "+ g+ " " );

		BigInteger k = BigInteger.valueOf(d).multiply(BigInteger.valueOf(e).multiply(BigInteger.valueOf(f)).multiply(BigInteger.valueOf(g)));
		return k;
	}

	public static void main(String[] args) {

		Person p1 = new Person();
		Person p2 = new Person(29, "Mahesh", 68.84);
		
		System.out.println("this is p1 object before overriding values" +p1.age + " " + p1.name+ " " + p1.weight + "\n");
		
		
		p1.age = 26;
		p1.name = "Ram Charan";
	
		System.out.println("this is p1 object after overriding or updating values" + p1.age + " " + p1.name+ " " + p1.weight + "\n");
		
		System.out.println(p2.age + " " + p2.name + " " + p2.weight + "\n");
				
		p1.eat();

		System.out.println("first \n"+ p1.GPACalculation(34, 45, 63) + "\n");

		BigInteger newVar = p1.GPACalculation(23, 45, 808);

		System.out.println("second \n" +newVar);
		
	}

}

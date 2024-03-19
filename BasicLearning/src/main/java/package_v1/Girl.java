//this is a sample code  to test out the JAVA compiler for learning purposes only
package package_v1;

import java.math.BigInteger;

public class Girl {
	
	int age;
	String  name;
	double weight;

	public Girl() {
		//super();
		age = 32;
		name = "Katrina";
		weight = 51.56;

	}
	
	public Girl(int age, String name, double weight) {
		//super();
		this.age = age;
		this.name = name;
		this.weight = weight;
		//System.out.println();
	}

	public void eat() {
		//int a = 10001;
		System.out.println("she eats food \n");
		//return a;
	}

	public void sleep() {
		System.out.println("she is sleeping");
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

		Girl vani = new Girl();
		Girl deepu = new Girl(29, "deepthi", 48.84);
		
		System.out.println("this is vani object before overriding values" +vani.age + " " + vani.name+ " " + vani.weight + "\n");
		
		
		vani.age = 26;
		vani.name = "Vaani";
	
		System.out.println("this is vani object after overriding or updating values" + vani.age + " " + vani.name+ " " + vani.weight + "\n");
		
		System.out.println(deepu.age + " " + deepu.name + " " + deepu.weight + "\n");
				
		//vani.eat();

		System.out.println("first \n"+ vani.GPACalculation(34, 45, 63) + "\n");

		BigInteger newVar = vani.GPACalculation(23, 45, 808);

		System.out.println("second \n" +newVar);
		
	}

}

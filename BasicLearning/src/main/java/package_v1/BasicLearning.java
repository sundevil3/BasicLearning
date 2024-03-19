//this is a sample code  to test out the JAVA compiler for learning purposes only
package package_v1;

public class BasicLearning {

	protected void display() {
		System.out.println("geeks for geeeks");
	}

	public int complexFunc(int a, int b, int c) {
		int d = a + b;
		int e = d * 23;
		int f = e + 46;
		return f;
	}

	public static void main(String[] args) {
		System.out.println(3 + 00.4);
		BasicLearning vani = new BasicLearning();
		vani.display();
		System.out.println("printing from SOP first " + vani.complexFunc(34, 45, 63));
		int newVar = vani.complexFunc(23, 45, 808);
		System.out.println(newVar);
	}

}

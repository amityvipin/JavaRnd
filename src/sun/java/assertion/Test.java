package sun.java.assertion;

public class Test {

	
	public void display(int i){
		assert(i>0):"test";
		System.out.println(i);
	}
	public static void main(String[] args) {
		new Test().display(0);
	}

}

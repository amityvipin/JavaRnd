package sun.java.java8.interfaces;


interface TestInterface{
	default void display(){System.out.println("TestInterface");};
	public static int getValue(){
		return 5;
	}
}

interface TestInterface2{
	void display();
}

public class Sample implements TestInterface,TestInterface2{

//	public void display(){
//		System.out.println("Sample");
//		TestInterface.super.display();
//	}
	public static void main(String[] args) {
		new Sample().display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}

package sun.java.polymorphism;

import java.io.IOException;

public class Testing {
	
	public static void main(String[] args) {
		
	}

}

class A{
	private int i;
	protected Object display(Integer i) throws Exception{
		System.out.println("This is A class object");
		return this;
	}
}

class B extends A{
	@Override
	public String display(int i){
		System.out.println("This is B class object");
		return "";
	}
	public void test(){
		
	}
}

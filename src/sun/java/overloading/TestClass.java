package sun.java.overloading;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestClass {
	
	static class SuperClass{
		public void getDisplay() throws IOException{
			
		}
	}
	
	static class ChildClass extends SuperClass{
		public void getDisplay() throws FileNotFoundException{
			
		}
	}

	public static void main(String[] args) {

		 int i=0;
		 while(i<10)
			 do {
				 System.out.println("fkdjf");
			 }while(i<6);
		 
	}

}

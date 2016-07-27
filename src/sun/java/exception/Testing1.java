package sun.java.exception;

import java.beans.Customizer;
import java.io.IOException;
import java.util.*;

public class Testing1 {
	public static void main(String args[]) throws Exception{
		
		
		
		List stuff = Arrays.asList(new String[] { "a", "b" });
	      List list = new ArrayList(stuff);
	      list = Collections.unmodifiableList(list);
		try{
			System.out.println("try");
			int i = 1/0;
		}catch(Exception e){
			System.out.println("catch");
		
			throw new Exception("catch");
		}
		finally{
			System.out.println("exception");
			throw new Exception("finally");
		}
		
	}

}

package sun.java.collections;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class Test {

	public static void main(String args[]) throws IOException{
		
		
		HashMap<String,String> test = new HashMap<>();
		test.put("test1", "value1");
		test.put("test2", "value1");
		test.put("test3", "value1");
		test.put("test4", "value1");
		test.put("test5", "value1");
		test.put("test6", "value1");
	}
	
	public void display() throws IOException{
		try{
			show();
		}catch(Exception e){
//			e.printStackTrace();
		throw new IOException("exception in display",e);
		}
	}
	
	public void show() throws IOException{
		throw new IOException("dfjdjfk");
	}
}

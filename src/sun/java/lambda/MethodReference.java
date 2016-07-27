package sun.java.lambda;

import java.util.HashMap;

public class MethodReference {
	
	public static void main(String args[]){
		
		
		HashMap<String,String> map = new HashMap<>();
		map.put("vipin", "kumar");
		map.put("manu", "batham");
		
		String value = "vipin-manu";
		
		//bounded reference
		//map.replaceAll(value::replace);
		
		map.replaceAll(String::concat);
		
		System.out.println(map);
	}

}

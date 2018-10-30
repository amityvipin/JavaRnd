package sun.java.lambda;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.script.*;

public class MethodReference {
	
	public static void main(String args[]) throws ScriptException{
		
		
		HashMap<String,String> map = new HashMap<>();
		map.put("vipin", "kumar");
		map.put("manu", "batham");
		
		String value = "vipin-manu";
		
		//bounded reference
		//map.replaceAll(value::replace);
		
		map.replaceAll(String::concat);
		
		System.out.println(map);
		
		Consumer<String> c = (String s)-> {System.out.println(s);};
		c.accept("vipin");

		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        @SuppressWarnings("unchecked")
        Consumer<String> f = (Consumer<String>)engine.eval(
            String.format("new java.util.function.Consumer(%s)","consumer(x) System.out.println(x)"));
           f.accept("vipind");
        }

}

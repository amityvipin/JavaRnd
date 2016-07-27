package sun.java.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str() default "test";
	int val();
}

public class Test{
	@MyAnno(val = 0)
	public static void test(){
		System.out.println("");
	}
	
	
	public static void main(String args[]) throws NoSuchMethodException, SecurityException{
		MyAnno temp = new Test().getClass().getMethod("test", null).getAnnotation(MyAnno.class);
System.out.println(temp.str());
	}
}

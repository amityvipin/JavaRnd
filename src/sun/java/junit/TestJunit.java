package sun.java.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
	
	
	@Test
	public void testData(){
		String str = "this is tessst";
		assertEquals("this is test", str);
		
	}

}

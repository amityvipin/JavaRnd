import java.util.ArrayList;
import java.util.Arrays;


public class Test1 {

	
	private static void workHard(){
		try{
			workHard();
		}finally{
			workHard();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		workHard();
		System.out.println("It's nap time");
		
		int i=8;
		System.out.println(~i);
		ArrayList<String> test = new ArrayList<String>();
		test.add("vipin");
		test.add("kumar");
		
		Object[] testStringArray =  test.toArray();
		test.remove("kumar");
		test.add("fjkdjfjd");
		System.out.println(testStringArray[0].toString()+testStringArray[1].toString());
	}

}

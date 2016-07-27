package css;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "vipin";
		if(s == "vipin")
			System.out.println("true");
		else
			System.out.println("false");
		
		
		String s2 = "vipinkumar";
		s2 = s2.substring(0,5);
		if(s2 == "vipin")
			System.out.println("true");
		else
			System.out.println(s2.substring(0,5));
	}

}

package sun.java.algorithms;

/**
 * @author Vipin
 *
 */
public class UniqueStringCharacter {
	
	/**
	 * Complexity is O(n) and space complexity is O(1)
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str){
		
		if(str.length()>128)
			return false;
		boolean[] char_set = new boolean[256];
		
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		
		return true;
	}

    /**Complexity is O(n) and space complexity then O(1) although here we are reducing the usage of space
     * @param str
     * @return
     */
    public static boolean isUniqueChars2(String str){
    	int checker = 0;
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i) - 'a';
			
			// As we are shifting  ASCII value of all the charater to the left so that we have binary representation of the character like this 0000 0001 for a
			// and 0000 0010 for b etc. every time we have a new character we are filling the bit in the binary representation in checker variable so when we anding 
			// this value to new value with left shifting then if it is greater than 0 then it means that this character is already processed before. so we will return false.
			if((checker & (1 << val)) >0)
				return false;
			checker |= (1<<val);
		}
		
		return true;
	}

	
	public static void main(String[] args) {

		System.out.println(isUniqueChars2("aba"));
	}

}

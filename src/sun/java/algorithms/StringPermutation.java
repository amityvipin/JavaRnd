package sun.java.algorithms;

import java.util.Arrays;

public class StringPermutation {

	public static boolean isPermuation(String first, String second){
		
		if(first.length()!= second.length())
			return false;
		char[] firstArray = first.toCharArray();
		char[] secondArray = second.toCharArray();
		
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		
		return new String(firstArray).equals(new String(secondArray));
	}
	
	
	public static boolean isPermutationOptimized(String first, String second){
		if(first.length()!= second.length())
			return false;
		int[] letters = new int[256];
		char[] firstArray = first.toCharArray();
		char[] secondArray = second.toCharArray();
		for(int i=0; i<firstArray.length;i++){
			letters[firstArray[i]]++;
		}
		for(int i=0; i<secondArray.length;i++){
			if(--letters[secondArray[i]]<0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPermutationOptimized("vipin", "ipivn"));
	}

}

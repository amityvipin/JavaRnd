package sun.java.algorithms;

public class ReverseSentense {

	
	public static void reverseString(StringBuffer input, int start, int end){
		while(start<end){
			char temp = input.charAt(start);
			input.setCharAt(start, input.charAt(end));
			input.setCharAt(end, temp);
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		
		StringBuffer input = new StringBuffer("This is a test of reverse String sentense.");
		
		int i=0;
		int startIndexOfWord = 0,endIndexOfWord = 0;
		while(i<input.length()){
			if(i==0)
				startIndexOfWord = 0; 
			if(input.charAt(i) == ' ' || i==input.length()-1){
				endIndexOfWord = i;
				if(i!=input.length()-1)
				endIndexOfWord--;
				reverseString(input,startIndexOfWord,endIndexOfWord);
				startIndexOfWord = i+1;
			}
			i++;
		}
		
		reverseString(input,0,input.length()-1);
		System.out.println(input.toString());
	}

}

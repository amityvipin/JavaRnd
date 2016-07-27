package sun.java.algorithms;

public class UniqueCharactersInRepeatedStringSequence {

	public static void main(String[] args) {

		StringBuffer input = new StringBuffer("invipinvipinvipinvipinvipinvi");
		StringBuffer uniqueCharacters = new StringBuffer();
		int i=0;
		while(i<input.length()){
			char ch = input.charAt(i);
			process(uniqueCharacters,ch);
			i++;
		}
		System.out.println(uniqueCharacters);
	}
	public static void process(StringBuffer uniqueCharacters, char ch){
		int i=0;
		boolean flag = true;
		while(i<uniqueCharacters.length()){
			char ch1 = uniqueCharacters.charAt(i);
			if(ch==ch1){
				flag = false;
				break;
			}
			i++;
		}
		if(flag){
			uniqueCharacters.append(ch);
		}
	}

}

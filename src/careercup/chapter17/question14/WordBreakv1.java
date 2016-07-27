package careercup.chapter17.question14;

import java.util.Arrays;
import java.util.List;

public class WordBreakv1 {
	
	String sentence = "icecream";
	String[] list =  {"ice", "cream"};
	List<String> disctionary = Arrays.asList(list);
	
	public int parseSimple(int wordStart, int wordEnd){
		if(wordEnd >= sentence.length()){
			return wordEnd-wordStart;
		}
		
		String word = sentence.substring(wordStart, wordEnd + 1);
		
		int bestExact = parseSimple(wordEnd +1, wordEnd +1);
		if(!disctionary.contains(word)){
			bestExact += word.length();
		}
		
		int bestExtend = parseSimple(wordStart, wordEnd +1);
		
		return Math.min(bestExact, bestExtend);
	}

	public static void main(String[] args) {
		
		System.out.println(new WordBreakv1().parseSimple(0, 7));
	}

}

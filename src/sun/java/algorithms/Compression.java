package sun.java.algorithms;

import javax.swing.tree.TreeNode;

public class Compression {
	
	public static String compressString(String str){
		
		char last = str.charAt(0);
		int charSize = 1;
		StringBuffer finalString = new StringBuffer();
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==last){
				charSize ++;
			}else{
				finalString.append(last);
				finalString.append(charSize);
				last = str.charAt(i);
				charSize = 1;
			}
		}
		finalString.append(last);
		finalString.append(charSize);
		return finalString.toString();
	}

	
	public static void main(String args[]){
		System.out.println(compressString("vvippin"));
	}
}

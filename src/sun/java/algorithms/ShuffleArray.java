package sun.java.algorithms;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

	
	public static int[] shuffleArray(int[] values){
		int length = values.length;
		Random random = new Random();
		for(int i=length-1; i>=0;i--){
			int j = random.nextInt(1);
			int temp = values[i];
			values[i]=values[j];
			values[j] = temp;
		}
		return values;
	}
	
	public static void main(String[] args) {
		int[] values ={1,2,3,4,5,6,7,8};
		int[] shuffledArray = shuffleArray(values);
		for(int i=0;i<shuffledArray.length;i++){
			System.out.print(shuffledArray[i]+" ");	
		}
		
	}

}

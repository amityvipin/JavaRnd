package sun.java.algorithms;

public class Fabonacci {

	public static void main(String[] args) {
		int first = 0, second = 1;
		int n = 7;
		int value = 0;
		while(n-2>0){
			value= first+second;
			first = second;
			second = value;
			n--;
		}
		
		System.out.println(value);

	}

}

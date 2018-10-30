package sun.java.algorithms.number;

public class PrimeNumber {
	
	static int[] coins = {1,2,3};

	public static void main(String[] args) {
		
		System.out.println(isPrime(47));
		System.out.println(greatestCommonDenominator(65,75));
		System.out.println(maxNumberOfProvidedBaseOfProvidedDigit(10,5));
		System.out.println(coinChangeProblem(4,3));
	}
	
	public static boolean isPrime(int value) {
		for(int i=2;i<value;i++) {
			for(int j=1;j<Math.sqrt(value);j=j+2) {
				if(i*j==value)
					return false;
			}
		}
		return true;
	}
	
	public static void generatePrimeNumbers(int maxValue) {
		
	}
	
	public static int greatestCommonDenominator(int first, int second) {
		if(second==0)
			return first;
		return greatestCommonDenominator(second,first%second);
	}
	
	public static double maxNumberOfProvidedBaseOfProvidedDigit(int base, int digit) {
		return Math.pow(base, digit)-1;
	}
	
	public static int coinChangeProblem(int noOfRupees, int numberOfCoins) {
		if(noOfRupees<0 || numberOfCoins<=0)
			return 0;
		if(noOfRupees==0)
			return 1;
		return coinChangeProblem(noOfRupees,numberOfCoins-1)+coinChangeProblem(noOfRupees-coins[numberOfCoins-1],numberOfCoins);
	}

}

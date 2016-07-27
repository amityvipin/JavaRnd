package sun.java.algorithms;

public class Checksum {

	public static void main(String[] args) {
		String num = "321541";
		char[] ch = num.toCharArray();
		int mult = 0;
		for (int i = 0; i < ch.length - 1; i++) {
			int val = ch[i] - '0';
			mult += val * val;
		}
		int t = checkCheckSum(mult);
		if (t == ch[num.length() - 1] - '0') {
			System.out.println("Check Sum Valid");
		} else {
			System.out.println("Check Sum Invalid :: " + t);
		}
	}

	private static int checkCheckSum(int number) {
		String mul = String.valueOf(number);
		while (mul.length() > 1) {
			char a[] = mul.toCharArray();
			int sum = 0;
			for (Character c : a) {
				int v = c - '0';
				sum = sum + v;
			}
			mul = String.valueOf(sum);
		}
		return Integer.parseInt(mul);
	}
}
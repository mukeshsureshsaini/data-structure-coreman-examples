import java.math.BigInteger;

public class ExtendedEculid {

	public static int[] egcd(int a, int b) {
		if (b == 0)
			return new int[] { a, 1, 0 };
		else {
			int[] arr = egcd(b, a % b);

			int gcd = arr[0];
			int X = arr[2];
			int Y = arr[1] - (a / b) * arr[2];

			return new int[] { gcd, X, Y };
		}
	}

	public static int multiplicativeInverse(int a, int modulo) {

		int[] egcdValues = egcd(a, modulo);

		// since multiplicative inverse exist iff gcd(a,modulo) =1
		// if no inverse exist then return 0

		if (egcdValues[0] != 1)
			return 0;
		if (egcdValues[1] > 0)
			return egcdValues[1];
		else
			return egcdValues[1] + modulo;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(multiplicativeInverse(5, 7));
		
		// using BigInteger
		BigInteger a = new BigInteger("5");
		BigInteger m = new BigInteger("7");
		System.out.println(a.modInverse(m));
		
		
		
	}
}

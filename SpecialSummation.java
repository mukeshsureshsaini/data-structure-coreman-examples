// walmart special summation 

/**
 * 
 * 
 * Find number of digits in sum for a given integer eg 1234 => 1111+111+11+1 ==>
 * 10 32 => 11+11+11-1 => 7
 * 
 * 
 * 9 => 11-1-1 9 => 1+1+1+1+1+1+1+1+1
 * 
 * but for 9 we can represent it 4 digits rather than 9 digits hence 4 is the
 * answer
 * 
 * @author a13218298
 *
 */
public class SpecialSummation {

	public static int noOfDigits(long n) {
		return (int) (Math.log10(n) + 1);
	}

	public static long Onces(long noOfDigits) {
		long res = 1;
		noOfDigits--;
		while (noOfDigits > 0) {
			res = (res * 10) + 1;
			noOfDigits -= 1;
		}
		return res;
	}

	public static long solve(long n) {

		long noOfDigits = noOfDigits(n);
		long Ones = Onces(noOfDigits);
		if (n >= 11 && n % Ones == 0)
			return noOfDigits * (n / Ones);
		else
			return solveHelper(n, Ones, noOfDigits);
	}

	public static long solveHelper(long num, long ones, long noOfDigits) {
		if (num == 0 || ones == 0 || noOfDigits == 0)
			return 0;
		if (noOfDigits <= 2) {
			return solveHelperFor2Digits(num);
		} else {
			long rem = num % ones;
			long digits = noOfDigits(rem);
			long oneSeq = Onces(digits);
			if (num < ones) {
				return solveHelper(rem, oneSeq / 10, digits - 1);
			}
			return noOfDigits * (num / ones) + solveHelper(rem, oneSeq, digits);
		}
	}

	private static long solveHelperFor2Digits(long num) {
		long reminder = num % 11;
		long dividend = num / 11;
		long waysForReminder = reminder + 2 * dividend;
		long nextMultiple = (dividend + 1) * 11;
		long diffForNextMultiple = nextMultiple - num;
		long waysForNextMultiple = diffForNextMultiple + 2 * (dividend + 1);
		return Long.min(waysForNextMultiple, waysForReminder);
	}

	public static void main(String[] args) {
		// System.out.println(solve(32));
		// System.out.println(solve(1234));
		//System.out.println(solve(11104));
//		for (int x = 1; x <= 11; x++)
//			System.out.println(solve(x));
		
		System.out.println(noOfDigitsRecursive(9));
		System.out.println(noOfDigitsRecursive(10));
		System.out.println(noOfDigitsRecursive(100));

	}
	
	
	public static int noOfDigitsRecursive(int i) {	
		if(i <= 9) return 1;
		else return 1+ noOfDigitsRecursive(i/10);
	}
}


public class FindingTwoMissingNumber {

	public static void printTwoMissingNumber(int[] numbers, int end) {
		int x = 0; // why zero because we are going to use XOR and if we do XOR with zero,

		// number remains same

		// XOR from [1....end]
		for (int i = 1; i <= end; i++) {
			x = x ^ i;
		}

		// XOR of array value
		for (int i = 0; i < numbers.length; i++) {
			x = x ^ numbers[i];
		}

		// if both bits are same XOR is zero
		// if either bit is set XOR is one

		int firstMissingNumber = 0;
		int secondMissingNumber = 0;
		// @formatter:off

		// find the leftmost set bit ,number will be  in form of 
		//		XXX 0 XXX 
		//		XXX 1 XXX 
		//.so we need the right bit with is set we can get that by using below formula
		
		// @formatter:on

		x = x & (~(x - 1)); //

		for (int i = 1; i <= end; i++) {

			if ((i & x) == x) { // i has right most bit set

				firstMissingNumber ^= i;
			} else {
				secondMissingNumber ^= i;
			}

			if (i - 1 < numbers.length) { // remove those numbers which are in arrays using xor

				if ((numbers[i - 1] & x) == x) {
					firstMissingNumber ^= numbers[i - 1];
				} else {
					secondMissingNumber ^= numbers[i - 1];
				}

			}
		}

		System.out.printf("first missing number : %d ,Second missing number : %d", firstMissingNumber,
				secondMissingNumber);
	}

	public static void main(String[] args) {
		// printTwoMissingNumber(new int[] { 1, 2, 4 }, 5);

		int x = 24;

		System.out.println(x & -x);

		
		System.out.println((int)Math.log(14));


	}

}

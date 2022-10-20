public class IsBeautifulNumber {

	private static int[] square = { 0, 1, 4, 9, 16, 25, 36, 49, 64, 81 };

	public static long allDigitSquare(long number) {
		if (number == 0)
			return 0;
		else
			return square[(int) (number % 10)] + allDigitSquare(number / 10);
	}

	public static boolean canReducedToOne(long number) {

		long slow  = number;
		long fast = number;
		do {
			slow = allDigitSquare(slow);
			fast = allDigitSquare(allDigitSquare(fast));
		}while(slow!=fast);
		
		if(slow ==1) {
			return true;
		}
		
		return false;

	}

	public static void main(String[] args) {

		System.out.println(canReducedToOne(31));

		System.out.println(canReducedToOne(1234));
		
		// 1234 > 30 >  9 > 81 > 65 >61 > 37 > 58
		//                                 |    v      we are in loop . can we solve using detacting a loop in linked list
		//                             	  37 > 89
	}

}

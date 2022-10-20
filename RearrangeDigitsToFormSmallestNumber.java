
public class RearrangeDigitsToFormSmallestNumber {

	public static long smallestNumber(long num) {

		if (num == 0L)
			return num;

		boolean isPositive = num > 0;
		int[] f = new int[10];
		if (!isPositive)
			num = -num;
		while (num > 0) {
			
			f[(int) (num % 10)]++;
			num /= 10;
		}
		long res = 0L;

		if (isPositive) { // smallest to larget

			// set first smallest digit anything but 0;

			for (int i = 1; i <= 9; i++) {
				if (f[i] != 0) {
					res = i;
					f[i] -= 1;
					break;
				}
			}

			for (int i = 0; i <= 9; i++) {
				while (f[i] > 0) {
					res = res * 10 + i;
					f[i] -= 1;
				}
			}

		} else {
			for (int i = 9; i >= 0; i--) {
				if (f[i] != 0) {
					res = i;
					f[i] -= 1;
					break;
				}
			}

			for (int i = 9; i >= 0; i--) {
				while (f[i] > 0) {
					res = res * 10 + i;
					f[i] -= 1;
				}
			}
		}

		return isPositive ? res : -res;

	}

	public static void main(String[] args) {

		System.out.println(smallestNumber(2170596702L));
	}
}

import java.math.BigInteger;

public class NextPalindromNumber {

	public static String nextPalindrome(String str) {
		if (isAllDigit9(str)) { // if all digits are 9 next palindrom is just 2 steps away
			return new BigInteger(str).add(BigInteger.ONE).add(BigInteger.ONE).toString();
		}
		int len = str.length();
		if (len % 2 == 0) { // even length String
			return getNextPalindromeForEvenLength(str, len);
		} else { // odd length String
			return getNextPalindromeForOddLength(str, len);
		}
	}

	private static String getNextPalindromeForEvenLength(String str, int len) {
		String firstHalf = str.substring(0, len / 2 - 1);
		String middle = str.substring(len / 2 - 1, len / 2 + 1);
		String reverseFirstHalf = reverse(firstHalf);

		if (isGreaterThan(firstHalf + middle + reverseFirstHalf, str)
				&& isPalindrome(firstHalf + middle + reverseFirstHalf)) {
			return new String(firstHalf + middle + reverseFirstHalf);
		}

		// check if middle string is not 99 , here it is confirmed that middle will be
		// length of 2 only
		if (middle.startsWith("0")) {
			return new String(firstHalf + "11" + reverseFirstHalf);
		} else if (!middle.equals("99")) {
			middle = nextPalindromeOf2Digits(middle);
			return new String(firstHalf + middle + reverseFirstHalf);
		} else {
			BigInteger tillMiddle = new BigInteger(str.substring(0, len / 2 + 1));
			tillMiddle = tillMiddle.add(BigInteger.ONE);
			return nextPalindrome(tillMiddle.toString() + reverseFirstHalf);
		}

	}

	private static String nextPalindromeOf2Digits(String str) {
		int firstDigit = Character.getNumericValue(str.charAt(0));
		int secondDigit = Character.getNumericValue(str.charAt(1));

		int max = Math.max(firstDigit, secondDigit);
		int min = Math.min(firstDigit, secondDigit);
		int diff = max - min;
		int multiplier = (firstDigit > secondDigit ? 0 : 11);
		str = String.valueOf((max * 10 + max) - (multiplier * (diff - 1)));

		return str;

	}

	private static String getNextPalindromeForOddLength(String str, int len) {

		String firstHalf = str.substring(0, len / 2);
		char middle = str.charAt(len / 2);
		String reverseFirstHalf = reverse(firstHalf);

		// check if firstHalf+middle+reverseFirstHalf is palindrome

		if (isGreaterThan(firstHalf + middle + reverseFirstHalf, str)
				&& isPalindrome(firstHalf + middle + reverseFirstHalf)) {
			return new String(firstHalf + middle + reverseFirstHalf);
		}

		// if above check fail check the middle chars if it is less than 9 increment it
		// else increment the value till middle and find next palindrome
		int middleNumericValue = Character.getNumericValue(middle);
		if (middleNumericValue < 9) {
			middleNumericValue += 1;
			middle = Character.forDigit(middleNumericValue, 10);
			return new String(firstHalf + middle + reverseFirstHalf);
		} else {
			BigInteger tillMiddle = new BigInteger(str.substring(0, len / 2 + 1));
			tillMiddle = tillMiddle.add(BigInteger.ONE);
			return nextPalindrome(tillMiddle.toString() + reverseFirstHalf);
		}

	}

	public static boolean isGreaterThan(String x, String y) {
		BigInteger X = new BigInteger(x);
		BigInteger Y = new BigInteger(y);
		return X.compareTo(Y) > 0;
	}

	public static String reverse(String str) {
		int i = 0;
		int j = str.length();
		if (j < 2)
			return str;
		char[] chars = str.toCharArray();
		j--;
		while (j > i) {
			swap(chars, i, j);
			i++;
			j--;

		}
		return new String(chars);
	}

	public static boolean isAllDigit9(String str) {
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if (c != '9')
				return false;
		}
		return true;

	}

	public static void swap(char[] chars, int i, int j) {
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}

	public static boolean isPalindrome(String str) {
		int len = str.length();
		if (len < 2)
			return true;
		if (str.charAt(0) != str.charAt(len - 1))
			return false;
		else
			return isPalindrome(str.substring(1, len - 1));
	}

	public static void main(String[] args) {

//		System.out.println(nextPalindrome("45312"));
//		System.out.println(nextPalindrome("12345"));
//		System.out.println(nextPalindrome("12945"));
//		System.out.println(nextPalindrome("4531"));
//		System.out.println(nextPalindrome("1459"));
//		System.out.println(nextPalindrome("1997"));
		System.out.println(nextPalindrome("2"));

		System.out.println("------------------------------");

//		System.out.println(bruteForceNextPalindromeNumber(45312));
//		System.out.println(bruteForceNextPalindromeNumber(12345));
//		System.out.println(bruteForceNextPalindromeNumber(12945));
//		System.out.println(bruteForceNextPalindromeNumber(4531));
//		System.out.println(bruteForceNextPalindromeNumber(1459));
//		System.out.println(bruteForceNextPalindromeNumber(1997));
	}

	public static int bruteForceNextPalindromeNumber(int x) {

		while (true) {
			x = x + 1;
			if (isPalindrome(String.valueOf(x))) {
				return x;
			}
		}

	}
}

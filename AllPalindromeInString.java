
public class AllPalindromeInString {

	public static int countPalindrome(String str, int length) {
		int count = 0;
		if (str == null || str.isEmpty())
			return count;
		for (int i = 0; i < length; i++) {
			count += countPalindromeHelper(str, i, i, length); // for length 1,3,5,7,9...
			count += countPalindromeHelper(str, i, i + 1, length); // for length 2,4,6,8,......
		}
		return count;
	}

	public static int countPalindromeHelper(String str, int low, int high, int length) {
		int count = 0;
		while ((low >= 0 && high < length) && str.charAt(low) == str.charAt(high)) {
			count += 1;
			low -= 1;
			high += 1;

		}
		return count;
	}

	
	public static void main(String[] args) {
		System.out.println(countPalindrome("aabbbaa", 7));
	}



}

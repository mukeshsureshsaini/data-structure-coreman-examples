
public class LongestPalindromSubstring {

	static public int longestPalindromSubstring(String s) {
		int pl = 0;
		String res = "";

		int sLen = s.length();

		for (int i = 0; i < sLen; i++) {

			int left = i, right = i;

			// for odd length palindrom
			while (left >= 0 && right < sLen && s.charAt(left) == s.charAt(right)) {
				if (right - left + 1 > pl) {
					res = s.substring(left, right + 1);
					pl = right - left + 1;
				}
				left -= 1;
				right += 1;
			}

			// for even length palindrome
			
			left = i;
			right = i + 1;
			while (left >= 0 && right < sLen && s.charAt(left) == s.charAt(right)) {
				if (right - left + 1 > pl) {
					res = s.substring(left, right + 1);
					pl = right - left + 1;
				}
				left -= 1;
				right += 1;
			}
		}
		System.out.println(res);
		return pl;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindromSubstring("cababbad"));
	}

}

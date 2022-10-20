import java.util.Arrays;

public class NextLargerNumberWithSameDigits {

	public static String nextLarger(String number) {

		int left = number.length() - 1;
		int rightMost = number.charAt(left) - '0';
		left -= 1;
		while (left >= 0) {
			int curr = number.charAt(left) - '0';
			if (curr < rightMost) {
				break;
			}
			left -= 1;
		}
		
		if (left < 0)
			return null;
		String firstPart = number.substring(0, left);
		char s[] = number.substring(left).toCharArray();
		char leftMostChar = s[0];
		char rightMostChar = s[s.length - 1];
		s[0] = rightMostChar;
		s[s.length - 1] = leftMostChar;
		Arrays.sort(s, 1, s.length);
		return firstPart.concat(new String(s));

	}


	public static void main(String[] args) {
		
		
		//Input:  n = "218765"
		//		Output: "251678"

	//	System.out.println(nextLarger("218765"));
		
		//System.out.println(nextLarger("987"));
		
		System.out.println(nextLarger("1234"));
	}

}

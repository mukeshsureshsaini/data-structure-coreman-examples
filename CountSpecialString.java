import java.util.Arrays;

public class CountSpecialString {

//	public static long countSpecialStrings(String str, int length) {
//		long count = 0;
//		if (str == null || str.isEmpty())
//			return count;
//
//		for (int i = 0; i < length; i++) {
//			count += countSpecialHelper(str, i, i, length);
//			count += countSpecialHelper(str, i, i + 1, length);
//		}
//		return count;
//	}

//	public static long countSpecialHelper(String str, int low, int high, int length) {
//		long value = 0L;
//		while ((low >= 0 && high < length) && str.charAt(low) == str.charAt(high)) {
//			String specialStr = str.substring(low, high + 1);
//			if (isSpecialString(specialStr)) {
//				System.out.println(specialStr);
//				value += 1;
//			}
//			low -= 1;
//			high += 1;
//
//		}
//
//		return value;
//
//	}

	public static long countSpecialString(String str, int len) {
		long count = 0L;
		boolean[][] cache = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			cache[i][i] = true;
			count += 1;

			if (i < len - 1 && str.charAt(i) == str.charAt(i + 1)) {
				cache[i][i + 1] = true;
				count += 1;
			}

		}
		print(cache);
		for (int l = 3; l <= len; l++) {
			for (int startIdx = 0; startIdx < len - l + 1; startIdx++) {
				int endIndex = l + startIdx - 1;

				if (str.charAt(startIdx) == str.charAt(endIndex) && cache[startIdx + 1][endIndex - 1]) {
					if (((startIdx + 1 == endIndex - 1) || (str.charAt(startIdx) == str.charAt(startIdx + 1))
							&& str.charAt(startIdx + 1) == str.charAt(endIndex - 1))) {
						cache[startIdx][endIndex] = true;
						count++;
					}
				}
			}

		}
		System.out.println("==============================================");
		print(cache);
		return count;
	}

	public static void print(boolean[][] cache) {
		for (boolean[] arr : cache) {
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {

		// System.out.println(countPalindrome("google", 6));
		// mnonopoo
		// asasd
		// System.out.println(countSpecialStrings("mnonopoo",8));
//		System.out.println("=======================================");
		// System.out.println(countSpecialStrings("asasd", 5));
//		System.out.println("=======================================");
		// System.out.println(countSpecialStrings("aaaa", 4));

		String str = "asasd";
		System.out.println(countSpecialString(str, str.length()));
	}
}

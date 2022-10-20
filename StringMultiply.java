
public class StringMultiply {

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";

		int l1 = num1.length();
		int l2 = num2.length();
		int[] sum = new int[l1 + l2];
		// String reversed1 = new StringBuilder(num1).reverse().toString();
		// String reversed2 = new StringBuilder(num2).reverse().toString();

		int diff = l1 + l2 - 2;

		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				sum[diff - (i + j)] += ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
			}
		}

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < sum.length; i++) {
			int res = sum[i] + carry;
			sb.append(res % 10);
			carry = res / 10;
		}
		String result = sb.reverse().toString();
		int i = 0;
		while (result.charAt(i) == '0') {
			i += 1;
		}
		// removing leading zero

		return result.substring(i, result.length());
	}

	public static void main(String[] args) {
		System.out.println(multiply("678", "895"));
		System.out.println(multiply("0", "0"));
	}
}

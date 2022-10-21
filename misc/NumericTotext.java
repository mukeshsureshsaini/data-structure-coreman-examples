package com.alpha.misc;

public class NumericTotext {

	private static String[] nums = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	private static String[] tens = { "", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninty" };

	public static String toText(int number) {

		StringBuilder sb = new StringBuilder();
		sb.append(arab(number));
		sb.append(" ");
		sb.append(crores(number));
		sb.append(" ");
		sb.append(Lakhs(number));
		sb.append(" ");
		sb.append(thousands(number));
		sb.append(" ");
		sb.append(hundreds(number));
		sb.append(" ");
		sb.append(tens(number));
		sb.append(" ");

		return sb.toString().trim();

	}

	public static String arab(int num) {
		// num %= 100000000000;
		int x = num / 100_000_0000;
		if (x == 0)
			return "";
		return tens(x) + " Arab";

	}

	public static String crores(int num) {
		num %= 100_000_0000;
		int x = num / 100_000_00;
		if (x == 0)
			return "";
		return tens(x) + " Crore";

	}

	public static String Lakhs(int num) {

		num %= 100_00_000;
		int x = num / 100_00_0;
		if (x == 0)
			return "";
		return tens(x) + " Lakh";

	}

	public static String thousands(int num) {
		num %= 100000;
		int x = num / 1000;
		if (x == 0)
			return "";
		return tens(x) + " Thousand";

	}

	public static String hundreds(int num) {
		num %= 1000;
		int x = num / 100;
		if (x == 0)
			return "";
		return (nums[x] + " Hundred");

	}

	public static String tens(int num) {
		num %= 100;
		if (num == 0)
			return "";
		if (num > 0 && num < 19)
			return nums[num];
		return (tens[num / 10] + " " + nums[num % 10]).trim();

	}

	public static void main(String[] args) {

		// int x = 10000;
		// while (x <= 12000) {
		System.out.println(toText(11_23_45_67));
		// x++;
		// }
//		System.out.println(toText(10));
//		System.out.println(toText(11));
//		System.out.println(toText(20));
//		System.out.println(toText(21));
//		System.out.println(toText(45));
//		
//		System.out.println(toText(99));
//		System.out.println(toText(100));
//		
//		
//		System.out.println(toText(101));
//		
//		System.out.println(toText(110));
//		
//		System.out.println(toText(141));
//		
//		System.out.println(toText(199));
//		
//		System.out.println(toText(200));
//		
//		System.out.println(toText(999));
//		
//		System.out.println(toText(1000));
//		
//		System.out.println(toText(1001));
//		
//		System.out.println(toText(9999));
//		
//		System.out.println(toText(10000));
//		
//		System.out.println(toText(11111));
	}

}

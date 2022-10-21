

public class IntegertoWords {

	private static String[] lessThan20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twleve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"NineTeen", };

	private static String tens[] = { "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	private static final int BILLION = 1000000000;
	private static final int MILIION = 1000000;
	private static final int THOUSAND = 1000;
	private static final int HUNDRED = 100;

	public static String integerToWords(int num) {
		if (num == 0)
			return "Zero";

		return integerToWordsHelper(num);

	}

	public static String integerToWordsHelper(int num) {

		if (num >= BILLION) {
			return integerToWordsHelper(num / BILLION) + "Billion " + integerToWordsHelper(num % BILLION);
		}
		if (num >= MILIION) {
			return integerToWordsHelper(num / MILIION) + "Million " + integerToWordsHelper(num % MILIION);
		}
		if (num >= THOUSAND) {
			return integerToWordsHelper(num / THOUSAND) + "Thousand " + integerToWordsHelper(num % THOUSAND);
		}
		if (num >= HUNDRED) {
			return integerToWordsHelper(num / HUNDRED) + "Hundred " + integerToWordsHelper(num % HUNDRED);
		}
		if (num < 20) {
			if (num == 0)
				return "";
			else
				return lessThan20[num] + " ";
		}
		return tens[num / 10] + " " + integerToWordsHelper(num % 10);
	}

	public static void main(String[] args) {
		System.out.println(integerToWords(50868));
		// System.out.println(integerToWords(54));
		// System.out.println(integerToWords(123));
//		System.out.println(integerToWords(1234));
//		System.out.println(integerToWords(12345));
//		System.out.println(integerToWords(123456));
//		System.out.println(integerToWords(1234567));
//		System.out.println(integerToWords(12345678));
//		System.out.println(integerToWords(123456789));

	}

}

package com.alpha.exhaustive;

public class PrintAllDecimals {

	public static void printDecimals(int digits) {
		printDecimals(digits, "");
	}

	public static void printDecimals(int digits, String soFar) {
		if (digits == 0) {
			System.out.println(soFar);
			return;
		}

		// in decimal we have choice from 0 to 9
//		printDecimals(digits - 1, soFar + 0);
//		printDecimals(digits - 1, soFar + 1);
//		printDecimals(digits - 1, soFar + 2);
//		printDecimals(digits - 1, soFar + 3);
//		printDecimals(digits - 1, soFar + 4);
//		printDecimals(digits - 1, soFar + 5);
//		printDecimals(digits - 1, soFar + 6);
//		printDecimals(digits - 1, soFar + 7);
//		printDecimals(digits - 1, soFar + 8);
//		printDecimals(digits - 1, soFar + 9);

		// above 9 choices in short form

		for (int i = 0; i <= 9; i++) {
			printDecimals(digits - 1, soFar + i);
		}

	}

	public static void main(String[] args) {

		printDecimals(2);

	}
}

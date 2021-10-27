package com.alpha.exhaustive;

public class PrintAllBinaryString {

	public static void printAll(int digits) {

		printAll(digits, "");
	}

	private static void printAll(int digits, String soFar) {

		if (digits == 0) {
			System.out.println(soFar);
			return;
		}
		// in binary only 0 and 1 are the choices
		printAll(digits - 1, soFar + "0"); // we append 0
		printAll(digits - 1, soFar + "1"); // we append 1

	}

	public static void main(String[] args) {

		printAll(5);
	}

}

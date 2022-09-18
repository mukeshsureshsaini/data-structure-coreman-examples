package com.alpha;

public class ValidBracesPair {

	public static void main(String[] args) {

		printpair(3);
	}

	private static void printpair(int i) {

		printPairHelper("", 0, 0, i);
	}

	private static void printPairHelper(String soFar, int openingBracesCount, int closingBracesCount,
			int numberOfPairs) {
		if (soFar.length() == 2 * numberOfPairs) {
			System.out.println(soFar);
			return;
		}
		if (openingBracesCount < numberOfPairs) {
			printPairHelper(soFar + "(", openingBracesCount + 1, closingBracesCount, numberOfPairs);
		}
		if (closingBracesCount < openingBracesCount) {
			printPairHelper(soFar + ")", openingBracesCount, closingBracesCount + 1, numberOfPairs);
		}

	}
}

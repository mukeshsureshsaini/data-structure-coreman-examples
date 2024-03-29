package com.alpha.string;

public class KMP {

	/***
	 * 
	 * @param pattern
	 * @return
	 * 
	 *         computing LSP is dynamic programming problem
	 */

	public static int[] computeLspTable(String pattern) {
		int[] lsp = new int[pattern.length()];
		lsp[0] = 0; // Base case
		for (int i = 1; i < pattern.length(); i++) {
			// Start by assuming we're extending the previous LSP (number of chars match)
			int j = lsp[i - 1];
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = lsp[j - 1]; // try with smaller LSP or reduce the match chars by one and find LSP of that
			if (pattern.charAt(i) == pattern.charAt(j))
				j++;
			lsp[i] = j;
		}
		return lsp;
	}

	public static int search(String pattern, String text) {
		int[] lsp = computeLspTable(pattern);

		int j = 0; // Number of chars matched in pattern
		for (int i = 0; i < text.length(); i++) {

			while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
				// Fall back in the pattern
				j = lsp[j - 1]; // Strictly decreasing
			}

			if (text.charAt(i) == pattern.charAt(j)) {
				// Next char matched, increment position
				j++;

				// have we reached total length
				if (j == pattern.length())
					return i - (j - 1);
			}
		}

		return -1; // Not found
	}

	public static void main(String[] args) {

//		String T = "bacbababaabcbab";
//		String P = "ababaca";
//
//		System.out.println(search(P, T));

		String P = "aaab";
		String T = "aaaaaaaaab";
		
		
		
		System.out.println(search(P, T));
	}
}

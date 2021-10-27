package com.recursion.dp;

// @formatter:off
// given a string of digits , find the substring such that sum of first half of substring is equal to sum of second half of substring
// eg 670341 -> 7034 , sum of first half 7+0 , sum of second half 3+4

// @formatter:on

class BruteForceMethod {

	private String str;
	private String equalSumSubstring = "";

	public BruteForceMethod(String str) {
		this.str = str;
		preprocess(this.str, str.length());

	}

	private void preprocess(String str, int strLen) {

		for (int i = 0; i < strLen; i++) {

			for (int j = i + 1; j < strLen; j += 2) { // why j+2 because we need equals half hence we always need to be
														// even

				int substringlength = j - i + 1;

				if (equalSumSubstring.length() > substringlength) {
					continue;
				} else {
					int lsum = 0, rsum = 0;
					for (int k = 0; k < substringlength / 2; k++) {

						lsum += this.str.charAt(i + k);
						rsum += this.str.charAt(i + k + substringlength / 2);
					}
					if (lsum == rsum) {
						equalSumSubstring = this.str.substring(i, j + 1);
					}

				}

			}
		}

	}

	public String getEqualSumSubstring() {
		return this.equalSumSubstring;
	}

}

class DynamicProgrammingMethod {

	private String str;
	private int maxLen;

	public DynamicProgrammingMethod(String str) {
		this.str = str;
		preprocessDyPro(str, this.str.length());
	}

	public void preprocessDyPro(String str, int n) {

		int cache[][] = new int[n][n];
		for (int x = 0; x < n; x++)
			cache[x][x] = str.charAt(x); // sum of length 1

		for (int len = 2; len <= n; len++) { // try for len 2,3,4,....

			for (int i = 0; i < n - len + 1; i++) { // start with ith index

				// we have length of substring and start index of substring we can find end
				// index and mid index of substring

				int j = i + len - 1; // end index

				int k = (i + j) / 2; // mid index for given i and j

				cache[i][j] = cache[i][k] + cache[k + 1][j];

				if (len % 2 == 0 && (cache[i][k] == cache[k + 1][j]) && (len > maxLen)) {
					maxLen = len;
				}

			}

		}
	}

	public int getEqualSumSubstringLength() {
		return this.maxLen;
	}

}

public class FirstAndsecondHalfEqualSumSubstring {

	public static void main(String[] args) {
		// BruteForceMethod m = new BruteForceMethod("67034");
		DynamicProgrammingMethod m = new DynamicProgrammingMethod("67043");
		System.out.println(m.getEqualSumSubstringLength());
	}

}

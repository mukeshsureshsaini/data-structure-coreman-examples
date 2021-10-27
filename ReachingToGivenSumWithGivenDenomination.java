package com.recursion.dp;

import java.util.Arrays;

// # of ways to reach 13 using 3,5,10

public class ReachingToGivenSumWithGivenDenomination {
	int[] cache;

	public ReachingToGivenSumWithGivenDenomination(int sum, int[] values) {

		cache = new int[sum + 1];
		cache[0] = 1;
		preprocess(sum, values);
	}

	private void preprocess(int sum, int[] values) {

		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < values.length; j++) {
				if (i - values[j] >= 0) {
					cache[i]+=cache[i-values[j]];
				}
			}

		}
		
		System.out.println(Arrays.toString(cache));

	}

	public static void main(String[] args) {
		
		ReachingToGivenSumWithGivenDenomination m = new ReachingToGivenSumWithGivenDenomination(13, new int[]{3,5,10});
		

	}
}

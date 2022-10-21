package com.alpha.exhaustive;

public class CoinChange {

	private int[] cache;

	private int result;

	public CoinChange(int[] denominations, int sum) {
		cache = new int[sum + 1];
		preporcess(denominations, sum);

	}

	private void preporcess(int[] denominations, int sum) {
		cache[0]=0;
		for (int i = 1; i <= sum; i++)
			cache[i] = Integer.MAX_VALUE;

		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < denominations.length; j++) {
				if (denominations[j] <= i) {
					cache[i] = Math.min(1+cache[i - denominations[j]], cache[i]);
				}
			}
		}
		
		result = cache[sum];

	}


	public int res() {
		return result;
	}

	public static void main(String[] args) {
		CoinChange c = new CoinChange(new int[] { 1, 3, 5, 7 }, 8);
		System.out.println(c.res());
	}

}

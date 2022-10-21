package com.alpha.exhaustive;

/***
 * 
 * also known as 0-1 knapsack problem
 * 
 * @author a13218298
 * 
 * 
 *         Given a Knapsack with given capacity C , weight W , value of weight V
 * 
 *         fill the knapsack to the maximum value given that only 1 item is
 *         available for each type
 *         
 *         
 *         Binary knapsack is core problem in other problem like coin change , subset sum etc
 *
 */
public class BinaryKnapsack {

	private int[][] profitCache;
	private int maxProfit;

	public int getMaxProfit() {
		return maxProfit;
	}

	public BinaryKnapsack(int capacity, int[] weight, int[] values) {
		preprocess(capacity, weight, values);
	}

	private void preprocess(int capacity, int[] weight, int[] values) {

		if (capacity <= 0 || weight.length == 0 || values.length == 0 || weight.length != values.length) {
			maxProfit = 0;
			return;
		}

		int items = weight.length;

		profitCache = new int[items + 1][capacity + 1];

		// if capacity is 0 , first column is zero
		for (int i = 0; i <= items; i++) {
			profitCache[i][0] = 0;
		}

		// if profit is zero ,first row is zero
		for (int j = 0; j <= capacity; j++) {
			profitCache[0][j] = 0;
		}

		// @formatter:off
		
		// below is the tricky part
		
		// check if item is eligible to be included (because it fits into given capacity)
		//   Yes       No
		// if item is eligible to be include , i also have to two choice
		// include it or not include it
		
		// @formatter:on

		for (int i = 1; i <= items; i++) { // check if this item can be included into given capacity

			for (int j = 1; j <= capacity; j++) { // check for ith capacity
				if (weight[i - 1] <= j) { // if this item is eligible

					int p1 = values[i - 1] + profitCache[i - 1][j - weight[i - 1]]; // item is included
					int p2 = profitCache[i - 1][j]; // item not included

					profitCache[i][j] = Math.max(p1, p2);

				} else {
					profitCache[i][j] = profitCache[i - 1][j];
				}

			}
		}

		maxProfit = profitCache[items][capacity];

	}

	public static void main(String[] args) {

		//BinaryKnapsack bks = new BinaryKnapsack(5, new int[] { 2, 3, 4, 5 }, new int[] { 3, 4, 5, 6 });
	//	System.out.println(bks.getMaxProfit());
		
		
		BinaryKnapsack bks = new BinaryKnapsack(7,  new int[] { 1, 2, 3, 5 },new int[] { 1, 6, 10, 16 });
		System.out.println(bks.getMaxProfit());

	}

}

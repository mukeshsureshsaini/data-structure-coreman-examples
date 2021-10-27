package com.recursion.dp;

import java.util.Arrays;

// @formatter:off
 


/***
 * 
 * @author a13218298
 *
 */


// Given the cost matrix find the minimum cost at last station





//@formatter:on
public class MinCostOfTravellingStations {

	private int[] minCost;
	private int[][] cost;

	public MinCostOfTravellingStations(int[][] cost, int dim) {
		this.cost = cost;
		minCost = new int[dim];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		preprocess(dim);
	}

	public int minCost(int dest) {
		return minCost[dest - 1];
	}

	private void preprocess(int dim) {

		minCost[0] = 0;
		minCost[1] = cost[0][1];
		for (int col = 2; col < dim; col++) {
			for (int row = 0; row < col; row++) {
				minCost[col] = Math.min(minCost[col - 1] + cost[row][col], minCost[col]);
			}
		}

	}

	public void syso() {
		System.out.println(Arrays.toString(minCost));
	}

	public static void main(String[] args) {

// @formatter:off
 
		int cost[][] = new int[][] {
			{ 0, 10, 75, 94 },
			{ -1, 0, 35, 50 },
			{ -1, -1, 0, 80 },
			{ -1, -1, -1, 0 } };
			
// @formatter:on

		MinCostOfTravellingStations ob = new MinCostOfTravellingStations(cost, 4);
		System.out.println(ob.minCost(3));

	}

}

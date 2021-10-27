package com.recursion.dp;

// @formatter:off

/*Given a cost matrix of M*N where cost[i][j] represent the cost of passing cell [i][j].
 * Find the min cost path for [0][0] to [M][N] 
 */

// @formatter:on

public class MinCostPath {

	private int minCost;
	private int[][] minCostMatrix;

	public MinCostPath(int[][] cost, int M, int N) {
		this.minCostMatrix = new int[M][N];
		preprocess(cost, M, N);

	}

	private void preprocess(int[][] cost, int M, int N) {

		minCostMatrix[0][0] = cost[0][0];

		// first row
		for (int col = 1; col < N; col++) {
			minCostMatrix[0][col] = cost[0][col] + minCostMatrix[0][col - 1];
		}

		// first column
		for (int row = 1; row < M; row++) {
			minCostMatrix[row][0] = cost[row][0] + minCostMatrix[row - 1][0];
		}

		for (int r = 1; r < M; r++) {
			for (int c = 1; c < N; c++) {
				minCostMatrix[r][c] = Math.min(minCostMatrix[r - 1][c], minCostMatrix[r][c - 1]) + cost[r][c];
			}
		}

		minCost = minCostMatrix[M - 1][N - 1];

	}

	public int getMinCost() {
		return minCost;
	}
	
	

	public static void main(String[] args) {

		// @formatter:off
		
		int [][] cost = new int[][] {
			{1,3,5,8},
			{4,2,1,7},
			{4,3,2,3}
		};
		
		// @formatter:on
		
		
		MinCostPath m = new MinCostPath(cost, 3, 4);
		System.out.println(m.getMinCost());

	}
}

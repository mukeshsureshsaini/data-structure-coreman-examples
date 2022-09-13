package com.alpha;

public class Maze {

	private static int counter = 0;

	public static void main(String[] args) {
		solve(3);
		System.out.println("total number Of ways : " + counter);
	}

	private static void solve(int dim) {
		int[][] dirs = { { 0, 1 }, { 1, 0 } };
		solve(dirs, 0, 0, dim);
	}

	private static void solve(int dirs[][], int startR, int startC, int dim) {
		if (startR == dim - 1 && startC == dim - 1) { // at destination
			counter += 1;
			return;
		} else {
			for (int[] dir : dirs) {
				if (isSafe(startR + dir[0], startC + dir[1], dim)) {
					solve(dirs, startR + dir[0], startC + dir[1], dim);
				}

			}
		}
	}

	private static boolean isSafe(int i, int j, int d) {
		return i >= 0 && i < d && j >= 0 && j < d;
	}

}

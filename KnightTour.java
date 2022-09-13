package com.alpha;

import java.util.Arrays;

public class KnightTour {

	private static int counter = 1;
	private static int totalCOnf = 0;

	public static void knightTour(int[][] moves, int startRow, int startCol) {

		int[][] dirs = { { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 }, { -1, -2 }, { 1, -2 }, { -1, 2 }, { 1, 2 } };
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				moves[i][j] = 0;
				knightTour(moves, i, j, dirs);
				moves[i][j] = -1;
				resetArrayToMinusOne(moves);
				counter = 1;
				System.out.println("------------------------------------------------------------");
			}
		}

	}

	private static void knightTour(int[][] moves, int startRow, int startCol, int[][] dirs) {
		if (counter == (moves[0].length * moves[0].length)) {
			for (int[] move : moves) {
				System.out.println(Arrays.toString(move));
			}
			totalCOnf += 1;
		} else {
			for (int[] dir : dirs) {
				int x = startRow + dir[0];
				int y = startCol + dir[1];
				if (isSafe(x, y, moves[0].length, moves)) {
					moves[x][y] = counter++;
					knightTour(moves, x, y, dirs);
				}
			}
		}
	}

	private static void resetArrayToMinusOne(int[][] arr) {
		for (int[] move : arr) {
			Arrays.fill(move, -1);
		}
	}

	public static boolean isSafe(int i, int j, int dim, int[][] moves) {
		return (i >= 0 && i < dim) && (j >= 0 && j < dim) && moves[i][j] == -1;
	}

	public static void main(String[] args) {
		int moves[][] = new int[8][8];
		resetArrayToMinusOne(moves);
		knightTour(moves, 0, 0);
		System.out.println("total conf : " + totalCOnf);

	}

}

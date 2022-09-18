package com.alpha;

import java.util.Arrays;

public class SudokuSingleSolution {

	public static void main(String[] args) {

		// @formatter:off
 

		int sudoku[][] = { 
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } 
				};
		// @formatter:on

		find(sudoku, 0, 0, 9);
	}

	// this will print all of the solution
	private static void find(int[][] sudoku, int row, int col, int dimension) {

		// base case
		if (row == 8 && col == 9) {
			for (int[] arr : sudoku) {
				System.out.println(Arrays.toString(arr));
				
			}
			
			System.out.println("==========================================");
			
			return;
		} else {

			// recursive case

			if (col == 9) {
				row += 1;
				col = 0;
			}
			if (sudoku[row][col] != 0) {
				find(sudoku, row, col + 1, dimension);
			}
			for (int no = 1; no <= dimension; no++) {
				if (isSafe(sudoku, row, col, no, dimension)) {
					sudoku[row][col] = no;
					find(sudoku, row, col + 1, dimension);
					sudoku[row][col] = 0;

				}
			}

		}
	}

	private static boolean isSafe(int[][] sudoku, int row, int col, int value, int dim) {

		// col and row can't have repeated value
		for (int i = 0; i < dim; i++) {
			if (sudoku[row][i] == value || sudoku[i][col] == value) {
				return false;
			}
		}

		// sub grid can't have same value again

		int sX = (row / 3) * 3; // subgrid starting row for element at [i][j]
		int sY = (col / 3) * 3; // sub grid starting column for element [i][j]

		for (int i = sX; i < sX + 3; i++) {
			for (int j = sY; j < sY + 3; j++) {
				if (sudoku[i][j] == value) { // value is already in sub grid
					return false;
				}
			}
		}
		return true;
	}
}

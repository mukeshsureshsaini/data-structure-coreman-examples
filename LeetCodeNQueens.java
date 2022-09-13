package demo;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeNQueens {

	private int counter = 0;

	public List<List<String>> solveNQueens(int n) {

		int[] queens = new int[n];
		List<List<String>> res = new ArrayList<>();
		solveNQueens(n, 0, queens, res);
		System.out.println(counter);

		return res;
	}

	public void solveNQueens(int n, int row, int[] queensSoFar, List<List<String>> result) {
		if (row == n) {
			result.add(makeResult(queensSoFar));
			counter += 1;
		} else {
			for (int col = 0; col < n; col++) {
				queensSoFar[row] = col;
				if (isSafe(queensSoFar, row, col)) {
					solveNQueens(n, row + 1, queensSoFar, result);
				}
				queensSoFar[row] = 0;
			}
		}
	}

	public boolean isSafe(int[] queensSoFar, int currentRow, int currentCol) {
		for (int i = 0; i < currentRow; i++) {
			if (queensSoFar[i] == currentCol) {
				return false;
			} // same column
			if (Math.abs(i - currentRow) == Math.abs(queensSoFar[i] - currentCol))
				return false;
		}
		return true;
	}

	public List<String> makeResult(int[] queens) {

		List<String> strs = new ArrayList<>();
		for (int i = 0; i < queens.length; i++) {
			StringBuilder sb = new StringBuilder();
			int k = queens[i];
			for (int j = 0; j < k; j++)
				sb.append(".");
			sb.append("Q");
			for (int j = k + 1; j < queens.length; j++)
				sb.append(".");
			strs.add(sb.toString());

		}
		return strs;
	}
	
	public static void main(String[] args) {
		
		LeetCodeNQueens x = new LeetCodeNQueens();
		x.solveNQueens(4);
	}
}

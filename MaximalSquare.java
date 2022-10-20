public class MaximalSquare {

	public static int maximalSquare(int[][] arr, int rows, int cols) {

		int[][] cache = new int[rows][cols];
		for (int i = 0; i < cols; i++) {
			cache[0][i] = arr[0][i];
		}
		for (int i = 0; i < rows; i++) {
			cache[i][0] = arr[i][0];
		}

		int max = Integer.MIN_VALUE;

		for (int r = 1; r < rows; r++) {
			for (int c = 1; c < cols; c++) {
				if (arr[r][c] == 1) {

					cache[r][c] = 1 + Integer.min(cache[r - 1][c - 1], Integer.min(cache[r][c - 1], cache[r - 1][c]));
					max = Integer.max(max, cache[r][c]);
				}
			}
		}
		return max;

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(maximalSquare(arr, arr.length, arr[0].length));

	}

}

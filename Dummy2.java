import java.util.ArrayList;
import java.util.List;

public class Dummy2 {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		List<List<Integer>> res = shiftGrid(arr, 1);
		for (List<Integer> resulList : res) {
			System.out.println(resulList);
		}

	}

	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

		int m = grid.length;
		int n = grid[0].length;
		while (k > 0) {
			int temp = grid[m - 1][n - 1];
			;
			for (int row = m - 1; row >= 0; row--) {

				for (int col = n - 1; col > 0; col--) {

					grid[row][col] = grid[row][col - 1];
				}
				if (row - 1 >= 0)
					grid[row][0] = grid[row - 1][n - 1];
			}
			grid[0][0] = temp;
			k -= 1;
		}

		List<List<Integer>> res = new ArrayList<>();

		for (int a[] : grid) {
			List<Integer> arr = new ArrayList<>();
			for (int b : a) {
				arr.add(b);
			}
			res.add(arr);
		}

		return res;
	}
}

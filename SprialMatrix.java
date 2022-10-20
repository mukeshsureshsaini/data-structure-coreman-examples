import java.util.Arrays;

public class SprialMatrix {

	public static int[][] sprialMatrix(int n) {
		int left = -1, right = n, top = -1, bottom = n;
		int row = 0;
		int col = 0;
		int[][] res = new int[n][n];
		int x = 1;
		while (left < right && top < bottom) {
			// left to right
			while (col < right) {
				res[row][col] = x++;
				col++;
			}
			col--;
			row++;
			top++;

			// top to bottom
			while (row < bottom) {
				res[row][col] = x++;
				row++;
			}
			row--;
			right--;
			col--;

			// right to left
			while (col > left) {
				res[row][col] = x++;
				col--;
			}
			col++;
			row--;
			bottom--;

			// bottom to top
			while (row > top) {
				res[row][col] = x++;
				row--;
			}
			row++;
			col++;
			left++;

		}
		return res;

	}

	public static void main(String[] args) {
		int[][] sprial = sprialMatrix(4);
		for (int[] arr : sprial) {
			System.out.println(Arrays.toString(arr));
		}
	}
}

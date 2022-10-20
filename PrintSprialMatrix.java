import java.util.ArrayList;
import java.util.List;

// leetcode 42
public class PrintSprialMatrix {

	public static List<Integer> printSprialMatrix(int[][] n) {

		int left = 0, right = n[0].length - 1, top = 0, bottom = n.length - 1;
		int row = 0;
		int col = 0;
		List<Integer> res = new ArrayList<>();
		while (left <= right && top <= bottom) {
			// left to right

			row = top;

			for (col = left; col <= right; col++) {
				res.add(n[row][col]);
			}

			// top to bottom
			for (row = top + 1; row <= bottom; row++) {
				res.add(n[row][right]);
			}

			if (left < right && top < bottom) {
				// right to left
				for (col = right - 1; col >= left; col--) {
					res.add(n[bottom][col]);
				}

				// bottom to top
				for (row = bottom - 1; row > top; row--) {
					res.add(n[row][left]);
				}
			}

			left += 1;
			right -= 1;
			top += 1;
			bottom -= 1;

		}

		return res;

	}

	public static void main(String[] args) {
		 List<Integer> sprial = printSprialMatrix(new int[][] { { 1, 2, 3, 4 }, { 5,
		 6, 7, 8 }, { 9, 10, 11, 12 } });
//		for (int i = 0; i < sprial.size(); i++) {
//
//			if (i % 4 == 0) {
//				System.out.println();
//			}
//			System.out.printf("%d\t", sprial.get(i));
//
//		}
		//List<Integer> sprial = printSprialMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		sprial.forEach(System.out::println);

	}
}

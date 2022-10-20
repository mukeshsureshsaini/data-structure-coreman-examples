import java.util.Arrays;

public class TappingRainWater {

	// with O(2n) space complexity
	public static int maxTrapWater(int[] heights) {

		int result = 0;
		int len = heights.length;

		int[] maxLeft = new int[len];
		int[] maxRight = new int[len];

		int MAXL = 0, MAXR = 0;

		for (int i = 0; i < len; i++) {
			maxLeft[i] = MAXL;
			MAXL = Integer.max(heights[i], MAXL);
			maxRight[len - i - 1] = MAXR;
			MAXR = Integer.max(heights[len - i - 1], MAXR);
		}

		for (int i = 0; i < len; i++) {
			result += Integer.max(Integer.min(maxLeft[i], maxRight[i]) - heights[i], 0);
		}

		return result;
	}

	// with O(1) space complexity
	// why this works see neetcode explanation
	public static int maxTrapWater2(int[] heights) {

		int res = 0;
		int len = heights.length;
		int l = 0, r = len - 1;
		int MAXL = heights[l];
		int MAXR = heights[r];
		while (l < r) {

			if (MAXL < MAXR) {
				l += 1;
				res += Integer.max(Integer.max(MAXL, heights[l]) - heights[l], 0);
				MAXL = Integer.max(MAXL, heights[l]);

			} else {

				r -= 1;
				res += Integer.max(Integer.max(MAXR, heights[r]) - heights[r], 0);
				MAXR = Integer.max(MAXR, heights[r]);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int heights[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		System.out.println(maxTrapWater2(heights));
	}

}

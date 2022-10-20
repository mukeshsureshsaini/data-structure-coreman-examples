import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 
 * 
 * @author Mukesh Kumar Saini
 * 
 * 
 *         The idea to find the largest rectangle in histogram is to find the
 *         left and right boundary for given height. The left and right
 *         boundaries are defined as the first index of lesser height on left
 *         and right side. Left and right boundaries indices will tell the width
 *         (R-l) and you already have the height for calculating the area.
 *
 */

public class LargestRectangleUnderHistogram {

	public static int largestRectangle(int[] heights) {

		// maintain increasing height index in stack
		Deque<Integer> stack = new ArrayDeque<>();
		int maxArea = 0;

		for (int i = 0; i <= heights.length; i++) { // why i am running loop till equal to length ,see height if height
													// i == heights.length ,length will be 0 at that time and all the
													// elements are greater than zero hence will be popped from stack at
													// the end

			int h = (i == heights.length) ? 0 : heights[i];

			if (stack.isEmpty() || h >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				int leftSideSmallHeightIndex = stack.pop();
				int leftSideHeight = heights[leftSideSmallHeightIndex];
				int width = stack.isEmpty() ? i : (i - 1) - stack.peek();
				maxArea = Math.max(maxArea, leftSideHeight * width);
				i--; // since we still need to process i ,we decrement it , i++ in loop will
						// increment
						// it so we still be on element i
			}
		}

		return maxArea;

	}

	public static void main(String[] args) {

		System.out.println(largestRectangle(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

}

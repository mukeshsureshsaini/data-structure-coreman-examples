import java.util.Arrays;

public class LongestStreak {

	public static void main(String[] args) {

		int[] lo = longestStreak(new int[] { 1, 2, 3, 4, 4, 4, 5, 5, 5, 3, 3, 3, 3, 3, 2, 2, 1 }, 5);
		System.out.println(Arrays.toString(lo));

		lo = longestStreak(new int[] { 1, 2, 3, 3, 3, 4 }, 5);
		System.out.println(Arrays.toString(lo));

		lo = longestStreak(new int[] { 1, 2, 3, 3, 3 }, 5);
		System.out.println(Arrays.toString(lo));

		lo = longestStreak(new int[] { 1, 2, 3, 4, 5 }, 5);
		System.out.println(Arrays.toString(lo));
	}

	public static int[] longestStreak(int[] arr, int k) {
		int[] longestStreak = new int[k + 1];
		int left = 0;
		int right = 1;
		while (left < right && right < arr.length) {
			if (arr[left] == arr[right]) {
				right += 1;
			} else {
				longestStreak[arr[left]] = Integer.max(longestStreak[arr[left]], right - left);
				left = right;
				right += 1;
			}
		}
		if (left < right && right == arr.length) {
			longestStreak[arr[left]] = Integer.max(longestStreak[arr[left]], right - left);
		}
		return longestStreak;
	}

}

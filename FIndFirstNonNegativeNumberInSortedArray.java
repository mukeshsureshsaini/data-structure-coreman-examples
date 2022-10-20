
public class FIndFirstNonNegativeNumberInSortedArray {

	public static int linerSearch(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0)
				return i;
		}
		return -1;
	}

	public static int binarySearch(int[] arr) {
		int lo = 0;
		int hi = arr.length;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > 0) {
				hi = mid - 1;
			} else if (arr[mid] < 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}

		return lo;
	}

	public static int firstNonNegativeNumberIdx(int[] arr) {
		if (arr.length < 10) {
			return linerSearch(arr);
		}
		return binarySearch(arr);
	}

	public static void main(String[] args) {
		int[] arr = { -4, -1, 0, 3, 10 };
		arr = new int[] { -1 };
		System.out.println(firstNonNegativeNumberIdx(arr));

	}
}

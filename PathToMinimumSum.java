

//leetcode-120
public class PathToMinimumSum {

	public static int path2MimimumSum(int[][] arr) {

		int length = arr.length;
		int cache[] = new int[arr[length - 1].length + 1];
		for (int i = length - 1; i >= 0; i--) {
			int a[] = arr[i];
			for (int j = 0; j < a.length; j++) {
				cache[j] = a[j] + Integer.min(cache[j], cache[j + 1]);
			}
		}

		return cache[0];
	}

	public static void main(String[] args) {
		int[][] arr = { { 2 }, { 3, 4 }, { 6, 5, 4 }, { 4, 1, 8, 3 } };

		System.out.println(path2MimimumSum(arr));
	}
}

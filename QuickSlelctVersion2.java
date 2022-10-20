import java.util.Arrays;

// 

public class QuickSlelctVersion2 {

	public static int partition(int arr[], int lo, int hi) {

		int i = lo;
		int j = hi + 1;
		int pivot = arr[lo];

		while (i < j) {

			while (arr[++i] < pivot) {
				if (i == hi)
					break; // at boundary
			}
			while (arr[--j] > pivot) {
				if (j == lo)
					break; // left boundary
			}
			swap(arr, i, j);
		}
		swap(arr, lo, j);

		return j;
	}

	public static int quickSelect(int[] arr, int k) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			int p = partition(arr, lo, hi);
			if (p > k) {
				hi = p - 1;
			} else if (p < k) {
				lo = p + 1;
			} else
				return arr[p];
		}
		return arr[lo];

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void main(String[] args) {
		int arr[] = { 2, 8, 7, 1, 3, 5, 6, 4 };
		System.out.println(quickSelect(arr, 5));
		System.out.println(Arrays.toString(arr));
	
		
	}

}

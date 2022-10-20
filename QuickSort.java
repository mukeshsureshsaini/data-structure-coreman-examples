import java.util.Arrays;

/**
 * 
 * 
 * from Coreman
 * 
 */

public class QuickSort {

	public static void sort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int p = partition(arr, 0, hi);
		sort(arr, lo, p - 1);
		sort(arr, p + 1, hi);

	}

	public static int partition(int arr[], int lo, int hi) {
		int k = lo - 1;
		int p = arr[hi];

		for (int i = lo; i < hi; i++) {
			if (arr[i] < p) {
				k += 1;
				swap(arr, k, i);
			}
		}
		swap(arr, k + 1, hi);
		return k + 1;
	}

	public static void swap(int[] arr, int p, int q) {
		if (p == q)
			return;
		int temp = arr[p];
		arr[p] = arr[q];
		arr[q] = temp;
	}

	public static int quickSelect(int[] arr, int n) {
		return 0;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 8, 7, 1, 3, 5, 6, 4 };

		sort(arr, 0, 7);
		System.out.println(Arrays.toString(arr));

	}

}

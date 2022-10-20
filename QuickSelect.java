import java.util.Arrays;

public class QuickSelect {

	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		int pivot = a[lo];
		while (i < j) {

			while (a[++i] < pivot) {
				if (i == hi)
					break;
			}

			while ((pivot < a[--j])) {
				if (j == lo)
					break;
			}

			swap(a, i, j);
		}

		swap(a, lo, j);

		return j;
	}

	public static int select(int arr[], int k) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo < hi) {
			int p = partition(arr, lo, hi);
			if (p < k)
				lo = p + 1;
			else if (p > k)
				hi = p - 1;
			else
				return arr[p];

		}
		return arr[lo];
	}

	// exchange a[i] and a[j]
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 8, 7, 1, 3, 5, 6, 4 };
		System.out.println(select(arr, 5));
		System.out.println(Arrays.toString(arr));
	}
	
	
}

package com.alpha.misc;

public class Quick3Way {

	public static void sort(int[] arr, int hi, int lo) {
		int lt = lo;
		int gt = hi;

		int pivot = arr[lo];
		int i = lo + 1;

		while (i <= gt) {

			if (arr[i] < pivot) {
				swap(arr, lt++, i++);
			} else if (arr[i] > pivot) {
				swap(arr, i, gt--);
			} else
				i++;

		}

		sort(arr, lo, lt - 1);
		sort(arr, gt + 1, hi);
	}

	public static void swap(int[] arr, int i, int j) {
		if (i == j)
			return;
		int x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
	}

}

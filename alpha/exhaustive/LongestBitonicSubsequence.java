package com.alpha.exhaustive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestBitonicSubsequence {

	public static int lis(int[] arr) {
		List<Integer> seq = new ArrayList<Integer>();
		seq.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > seq.get(seq.size() - 1)) {
				seq.add(arr[i]);
			} else {
				int index = Collections.binarySearch(seq, arr[i]);
				if (index < 0) {
					index = ~index;
					seq.remove(index);
					seq.add(index, arr[i]);
				}
			}
		}
		return seq.size();
	}

	public static int LDS(int[] arr) {
		int aux[] = new int[arr.length];
		int i = 0;

		for (int e : arr) {
			aux[i++] = -1*e;
		}

		return lis(aux);

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 25, 36, 40, 59, 48, 34, 20, 5 };

		System.out.println(lis(arr) + LDS(arr) - 1);

	}

}

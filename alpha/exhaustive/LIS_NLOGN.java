package com.alpha.exhaustive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author a13218298
 *
 *         check patience sort
 *         https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence-2x2.pdf
 */
public class LIS_NLOGN {

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
					seq.set(index,arr[i]);
				}
			}
		}

		System.out.println(seq);

		return seq.size();
	}

	/***
	 * 
	 * @param arr
	 * @return
	 * 
	 *         logest decreasing subsequence can be acheived by negative value of
	 *         lis
	 */
	public static int lds(int[] arr) {
		int aux[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			aux[i] = -1 * arr[i];
		}
		return lis(aux);
	}

	public static void main(String[] args) {

		int[] arr = { 5, 8, 7, 2, 9 ,1 };
		// arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };

		arr = new int[] { 10, 25, 36, 40, 59, 48, 34, 20, 5 };

		System.out.println(lis(arr));
		System.out.println(lds(arr));
	}

}

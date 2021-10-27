package com.alpha.exhaustive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author a13218298
 *
 *check patience sort https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence-2x2.pdf
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
					seq.remove(index);
					seq.add(index, arr[i]);
				}
			}

		}

		System.out.println(seq);

		return seq.size();
	}

	public static void main(String[] args) {

		int[] arr = { 5, 8, 7, 1, 9 };
		// arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };

		System.out.println(lis(arr));
	}

}

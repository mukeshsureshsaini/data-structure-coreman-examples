package com.alpha.exhaustive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// patience sort for both LIS ,LDS
/***
 * 
 * 
 * @author a13218298
 *
 *	use logest increasing subsequence with array value replacing its negative
 * means for an array (x1,x2,x3,.....xn) convert the array to (-x1,-x2,-x3,-x4 , ...., -xn) and find the LIS length
 *
 */


public class LongestDecreasingSubsequence_NLOGN {

	public static void LDS(int[] arr) {
		List<Integer> aux = new ArrayList<>();
		List<List<Integer>> stacks = new ArrayList<>();
		stacks.add(new ArrayList<>());
		stacks.get(0).add(arr[0]);
		aux.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > aux.get(aux.size() - 1)) {

				aux.add(arr[i]);
				List<Integer> s = new ArrayList<Integer>();
				s.add(arr[i]);
				stacks.add(s);

			} else {
				int idx = Collections.binarySearch(aux, arr[i]);
				if (idx < 0) {
					idx = ~idx;
					aux.remove(idx);
					aux.add(idx, arr[i]);

					stacks.get(idx).add(arr[i]);
				}

			}

		}
		 System.out.println(stacks.stream().mapToInt(st->st.size()).max().getAsInt());
		 
		
	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, 7, 1, 9 };
		arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		
		arr = new int[] {6,3,5,10,11,2,9,14,13,7,4,8,13};

		LDS(arr);

	}
}

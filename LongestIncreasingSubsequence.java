package com.alpha.exhaustive;

import java.util.Arrays;

// complexcity n^2
public class LongestIncreasingSubsequence {

	private int len;

	private int[] aux;

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public LongestIncreasingSubsequence(int[] arr) {
		len = LIS(arr);
	}

	private int LIS(int[] arr) {

		int len = arr.length;
		aux = new int[len];
		Arrays.fill(aux, 1);
		int max = 1;

		for (int cur = 1; cur < len; cur++) {
			for (int pre = 0; pre < cur; pre++) {

				if (arr[cur] > arr[pre] && aux[cur] <= aux[pre]) {
					aux[cur] = aux[cur] + 1;
					max = Math.max(aux[cur], max);
				}

			}
		}

		System.out.println(Arrays.toString(aux));
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, 7, 1, 9 };
		//arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };

		LongestIncreasingSubsequence lisLen = new LongestIncreasingSubsequence(arr);
		System.out.println(lisLen.getLen());
	}
}

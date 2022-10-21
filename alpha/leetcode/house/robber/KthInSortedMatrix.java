package com.alpha.leetcode.house.robber;

public class KthInSortedMatrix {

	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;

		int left = matrix[0][0];
		int right = matrix[n - 1][n - 1];

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (check(matrix, mid, k, n)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static boolean check(int[][] matrix, int target, int k, int n) {
		int i = n - 1;
		int j = 0;
		int num = 0;

		while (i >= 0 && j < n) {
			if (matrix[i][j] <= target) {
				num += i + 1;
				j++;
			} else {
				i--;
			}
		}

		return num >= k;
	}

	public static void main(String[] args) {
		
		int[][] arr= {{1,5,9},{10,11,13},{12,13,15}};
		
		System.out.println(kthSmallest(arr, 8));
	}
}

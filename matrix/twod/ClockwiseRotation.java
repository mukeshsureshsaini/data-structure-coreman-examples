package com.alpha.matrix.twod;

import java.util.Arrays;

public class ClockwiseRotation {

	public static void clockWiseRotation(int[][] array, int length) {
		/**
		 * since it is a square matrix row== cols==length
		 */

		int left = 0;
		int right = length - 1;

		while (left < right) {

			int top = left;
			int bottom = right;

			for (int i = 0; i < (right - left); i++) {
				int temp = array[top][left + i];
				array[top][left + i] = array[bottom - i][left];
				array[bottom - i][left] = array[bottom][right - i];
				array[bottom][right - i] = array[top + i][right];
				array[top + i][right] = temp;
			}

			left += 1;
			right -= 1;
		}
	}
	
	
	public static void antiClockWiseRotation(int[][] array, int length) {
		/**
		 * since it is a square matrix row== cols==length
		 */

		int left = 0;
		int right = length - 1;

		while (left < right) {

			int top = left;
			int bottom = right;

			for (int i = 0; i < (right - left); i++) {
				int temp = array[top][left + i];
				array[top][left + i] = array[bottom - i][left];
				array[bottom - i][left] = array[bottom][right - i];
				array[bottom][right - i] = array[top + i][right];
				array[top + i][right] = temp;
			}

			left += 1;
			right -= 1;
		}
	}

	public static void main(String[] args) {

		int x[][] = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		clockWiseRotation(x, x.length);
		for(int [] arr : x) {
			System.out.println(Arrays.toString(arr));
		}
	}

}

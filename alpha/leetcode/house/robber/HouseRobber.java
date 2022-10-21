package com.alpha.leetcode.house.robber;

public class HouseRobber {

	public int rob(int[] nums) {
		return Integer.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
	}

	public int helper(int[] arr, int i, int j) {
		int withoutPrevious = 0;
		int withprevious = 0;

		//[wo,w, n ,n+1]
		while (i <= j) {
			int temp = Integer.max(arr[i++] + withoutPrevious, withprevious);
			withoutPrevious = withprevious;
			withprevious = temp;
		}
		return withprevious;

	}

	public static void main(String[] args) {
		HouseRobber robber = new HouseRobber();
		System.out.println(robber.rob(new int[] {1,2,3,1}));
	}
}

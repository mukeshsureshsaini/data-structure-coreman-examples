package com.recursion.dp;
/**
 * 
 * https://massivealgorithms.blogspot.com/2018/04/leetcode-790-domino-and-tromino-tiling.html
 * https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116581/Detail-and-explanation-of-O(n)-solution-why-dpn2*dn-1+dpn-3
 * 
 * 
 * @author a13218298
 *
 */


public class TilePlacementWithLShapeTiles {

	private int N;
	public int[] cache;

	public TilePlacementWithLShapeTiles(int N) {

		this.N = N;
		cache = new int[N + 1];
		preprocess();
	}

	public void preprocess() {
		cache[0] = 1;
		cache[1] = 1;
		cache[2] = 2;

		for (int i = 3; i <= N; i++) {
			cache[i] = 2 * cache[i - 1] + cache[i - 3]; // how we reached this formula check above explanation
		}
	}
	
	
	public int noOfWays() {
		return cache[N];
	}

	
	public static void main(String[] args) {
		TilePlacementWithLShapeTiles m = new TilePlacementWithLShapeTiles(4);
		System.out.println(m.noOfWays());
	}
	
	
}

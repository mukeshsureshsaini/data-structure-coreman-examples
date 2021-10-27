package com.recursion.dp;

// @formatter:off


//given a plot of 2*N (H*W) and Tiles/dominos of 2*1 .  find the number of ways to place the tiles .
 
// @formatter:on

public class TilePlacement {

	private int slots;
	public int[] cache;
	

	public TilePlacement(int slots) {
		if(slots < 2) throw new IllegalArgumentException("slots must be greater than 1");
		this.slots = slots;
		cache = new int[slots + 1];
		preprocess(slots);

	}

	private void preprocess(int n) {

		cache[0] = 0;
		cache[1] = 1;
		cache[2] = 2;
		
		for(int s= 3; s <= slots; s++) {
			cache[s] = cache[s-1]+cache[s-2];
		}

	}
	
	public int noOfWays() {
		return cache[slots];
		
	}
	
	public static void main(String[] args) {
		
		TilePlacement t = new TilePlacement(1);
		System.out.println(t.noOfWays());
	}

}

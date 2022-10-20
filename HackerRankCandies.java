import java.util.Arrays;

public class HackerRankCandies {

	public static long candies(int n, int[] arr) {
		int[] candies = new int[n];
		candies[0] = 1;
		long sum = 0;
		int lastElement = arr[0];
		for (int i = 1; i < n; i++) {
			int thisElement = arr[i];
			candies[i] = 1;
			if (thisElement > lastElement) {
				candies[i] = candies[i - 1] + 1;
			}
			lastElement = thisElement;
		}
		
		for (int i = n - 2; i >= 0; i--) {
			int thisElement = arr[i];
			int nextElement = arr[i + 1];
			if (thisElement > nextElement && candies[i] <= candies[i + 1]) {
				candies[i] = candies[i + 1] + 1;
			}
		}

		System.out.println(Arrays.toString(candies));

		for (int candy : candies)
			sum += candy;
		return sum;

	}

	public static void main(String[] args) {
	//	System.out.println(candies(3, new int[] { 1, 2, 2 }));

		System.out.println(candies(10, new int[] { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 }));
	}

}

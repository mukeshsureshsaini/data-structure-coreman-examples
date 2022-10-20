
public class CandyDistribution {

	public static int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		candies[0] = 1;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else
				candies[i] = 1;
		}

		for (int i = ratings.length - 1 - 1; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = candies[i+1] + 1;
			}
		}
		int sum = 0;

		for (int c : candies) {
			sum += c;
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println(candy(new int[] { 1,3,2,2,1 }));
	}
}

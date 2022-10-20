
public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int price : prices) {
			maxProfit = Integer.max(maxProfit, price - minPrice);
			minPrice = Integer.min(price, minPrice);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(arr));

		arr = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(arr));

	}
}

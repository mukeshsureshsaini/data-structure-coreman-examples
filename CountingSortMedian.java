import java.util.Arrays;

public class CountingSortMedian {

	public static void main(String[] args) {

		int[] ar = { 1, 1, 1, 3, 3, 4, 4, 4, 5, 5, 5, 5 };
		System.out.println(Arrays.toString(ar));
		int k = ar.length;
		System.out.println("length : "+ k);
		int[] count = getCounts(ar);
		double median = getMedian(count, k);
		System.out.println(median);
	}

	private static int[] getCounts(int[] ar) {
		int[] count = new int[10+1];
		for (int i = 0; i < ar.length; i++) {
			count[ar[i]]++;
		}
		return count;
	}
	
	//basic but clever idea

	private static double getMedian(int[] count, int d) {
		int sum = 0;
		for (int i = 0; i < count.length; i++) {
			sum += count[i];
			if (2 * sum < d)
				continue;
			else if (2 * sum == d)
				return (2 * i + 1) / 2.0;
			else
				return i * 1.0;
		}
		return -1.0;
	}

}

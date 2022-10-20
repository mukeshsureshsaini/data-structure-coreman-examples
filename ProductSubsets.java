import java.util.Arrays;
import java.util.List;

public class ProductSubsets {

	public static long productSubsets(List<Integer> numbers, int k) {

		long count = 0;
		int len = numbers.size();
		int[][] cache = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {

				int num = numbers.get(i);

				// for diagonal
				if (i == j) {
					if (num <= k) {
						count += 1;
						cache[i][i] =num;
					} else {
						cache[i][i] = Integer.MAX_VALUE;
					}
				}else if(i<j) {
					int previousElement = cache[i][j - 1];
					if (previousElement == Integer.MAX_VALUE) {
						cache[i][j] = Integer.MAX_VALUE;
					} else {
						int mul = previousElement * num;
						if (mul <= k) {
							count += 1;
							cache[i][j] = mul;
						}
					}
				}

			}

		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(productSubsets(Arrays.asList(2,3,4), 6));
		System.out.println(productSubsets(Arrays.asList(2,3,4), 1));
	}

}

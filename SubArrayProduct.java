import java.util.Arrays;

public class SubArrayProduct {

	public static int countSubArrays(int arr[], int k) {

		int len = arr.length;
		int[][] cache = new int[len][len];
		int count = 0;
		int lopCounter = 0;
		for (int i = 0; i < len; i++) {
			in: for (int j = i; j < len; j++) {
				lopCounter+=1;
				if (i == j) {
					if (arr[j] <= k) {
						cache[i][j] = arr[j];
						count += 1;
					} else {
						cache[i][j] = -1;
						break in;
					}
				} else {
					if (cache[i][j - 1] != -1 && cache[i][j - 1] < k && arr[j] < k) {
						int temp = cache[i][j - 1] * arr[j];
						if (temp <= k) {
							cache[i][j] = temp;
							count += 1;
						} else {
							cache[i][j] = -1;
							break in;
						}
					}

				}
			}
		}
		for(int[] counts: cache)System.out.println(Arrays.toString(counts));
			
		System.out.println("loopExecuted :: "+lopCounter);
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4 };
		
		//System.out.println(countSubArrays(arr, 6));
		
		System.out.println(countSubArrays(new int[] {1,2,3,4}, 3));
	}
}

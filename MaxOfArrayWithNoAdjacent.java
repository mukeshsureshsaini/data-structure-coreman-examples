
public class MaxOfArrayWithNoAdjacent {

	public static int maxWithNoAdjacent(int arr[]) {
		int withIt = arr[0];
		int withoutIt = 0;

		for (int i = 1; i < arr.length; i++) {

			int maxTillLast = Math.max(withIt, withoutIt);
			withIt = withoutIt + arr[i]; // if a[i] included we need to exclude previous
			withoutIt = maxTillLast;

		}
		return Math.max(withIt, withoutIt);
	}

	public static void main(String[] args) {
		int arr[] = new int[] {5, 5, 10, 100, 10, 5};
		System.out.println(maxWithNoAdjacent(arr));
	}

}

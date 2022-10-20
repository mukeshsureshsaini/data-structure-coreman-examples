
public class SearchInSortedRotatedArray {

	public static int searchSmallestItemIdx(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		if (arr[lo] <= arr[hi]) // if it is not rotated
			return 0;
		while (lo + 2 <= hi) { // why +2 because we need at left ,self , right to check the order
			int mid = (lo + hi) / 2;
			if (arr[mid] < arr[hi])
				hi = mid;
			else if (arr[mid] > arr[hi])
				lo = mid;
		}
		return hi;

	}

	public static void main(String[] args) {
		int[] arr = { 80, 85, 90, 95, 20, 30, 35, 50, 60, 65, 67, 75 };
		System.out.println(searchSmallestItemIdx(arr));
	}

}


public class MedianOfSortedArray {

	static public double median(int[] arr1, int[] arr2) {

		int[] A = arr1;
		int[] B = arr2;

		int totalLength = arr1.length + arr2.length;
		int mid = totalLength / 2;

		if (arr2.length <= arr1.length) {
			A = arr2;
			B = arr1;
		}

		int l = 0, r = A.length-1;

		while (true) {
			int i = (l + r) / 2; // we are dealing with indices not no of elements
			// why total length-1 because if length is 3 than index is 2
			// why i-1 because mid gives is index in case of smaller but number of
			// elements in case of bigger

			int j = mid - i - 1 - 1;

			int Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
			int Aright = (i + 1) < A.length ? A[i + 1] : Integer.MAX_VALUE;
			int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
			int BRight = (j + 1 ) < B.length ? B[j + 1] : Integer.MAX_VALUE;

			// we are having best partition
			if (Aleft <= BRight && Bleft <= Aright) {

				// if total length in even
				if (totalLength % 2 == 0) {
					return Integer.sum(Integer.min(Bleft, Aleft), Integer.max(Aright, BRight)) / 2.0;
				} else // total length is odd
					return Integer.min(Aright, BRight);

			}

			else if (Aleft > BRight)
				r = r - 1;
			else
				l = i + 1;
		}

	}

	public static void main(String[] args) {
		//System.out.println(median(new int[] { 1,3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1,3 }, new int[] { 2 }));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// assume nums1 is smaller
		int l1 = nums1.length;
		int l2 = nums2.length;
		if(l1 ==0 ) return median(nums2);
		if(l2 ==0 ) return median(nums1);
		if (l1 > l2) {
			return findMedianSortedArrays(nums2, nums1);

		}
		// means l1 < l2
		int total = l1 + l2;
		int half = total / 2;

		// binary search on smaller array

		int left = 0, right = l1 - 1;

		while (true) {
			int mid = (left + right) / 2;
			int secondMid = half - mid - 2;

			int sMid = (mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
			int sMidPlusOne = ((mid + 1) < l1) ? nums1[mid + 1] : Integer.MAX_VALUE;

			int bMid = (secondMid >= 0) ? nums2[secondMid] : Integer.MIN_VALUE;
			int bMidPlusOne = ((secondMid + 1)) < l2 ? nums2[secondMid + 1] : Integer.MAX_VALUE;

			// check if partition is correct
			if (sMid <= bMidPlusOne && bMid <= sMidPlusOne) {

				// if even no of elemets in both of array
				if ((total) % 2 == 0)
					return (Integer.max(sMid, bMid) + Integer.min(sMidPlusOne, bMidPlusOne)) / 2.0;
				else
					return Integer.min(sMidPlusOne, bMidPlusOne);

			} else if (sMid > bMidPlusOne) {
				right = right - 1;
			} else {
				left = left + 1;
			}
		}


	}

	public static double median(int [] arr) {
		int len = arr.length;
		int mid = len>>1;
		if(len%2 == 0) return Integer.sum(arr[mid-1], arr[mid])/2.0;
		return 1.0 * arr[mid];
	}
}

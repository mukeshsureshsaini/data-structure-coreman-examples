import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FraudantActivityNotification {

//	 public static int activityNotifications2(List<Integer> expenditure, int d) {
//		// Write your code here
//		int size = expenditure.size();
//		List<Integer> backedExpenditure = new LinkedList<>();
//		for (int i = 0; i < d; i++)
//			backedExpenditure.add(expenditure.get(i));
//		Collections.sort(backedExpenditure);
//		int notifications = 0;
//		int lo = 0;
//		int hi = 0;
//		boolean isEven = (d % 2 == 0);
//		for (int i = d; i < size; i++) {
//			
//
//			int mid = (d) / 2;
//			int median = 0;
//			if (isEven) {
//				median = backedExpenditure.get(mid) + backedExpenditure.get(mid + 1);
//				notifications += (expenditure.get(i) >= (median) ? 1 : 0);
//			} else {
//				median = backedExpenditure.get(mid);
//				notifications += (expenditure.get(i) >= (2 * median) ? 1 : 0);
//			}
//			// update backedExpediture to update the median
//			backedExpenditure.add(expenditure.get(i));
//			backedExpenditure.remove(expenditure.get(i - d));
//		}
//
//		return notifications;
//}

//	public static int activityNotifications2(int[] expenditure, int d) {
//		// Write your code here
//		int size = expenditure.length;
//		int[] backedExpenditure = new int[d];
//		for (int i = 0; i < d; i++)
//			backedExpenditure[i] = expenditure[i];
//		Arrays.sort(backedExpenditure);
//		int notifications = 0;
//		boolean isEven = (d % 2 == 0);
//		for (int i = d; i < size; i++) {
//			int mid = (d) / 2;
//			int median = 0;
//			if (isEven) {
//				median = backedExpenditure[mid] + backedExpenditure[mid + 1];
//				notifications += (expenditure[i] >= (median) ? 1 : 0);
//			} else {
//				median = backedExpenditure[mid];
//				notifications += (expenditure[i] >= (2 * median) ? 1 : 0);
//			}
//			// update backedExpediture to update the median
//			findAndUpdateFirstOccurance(expenditure, backedExpenditure, i, i - d);
//		}
//
//		return notifications;
//	}
//
//	private static void findAndUpdateFirstOccurance(int[] arr, int[] backedArr, int idx, int idy) {
//		int itemTOBeFound = arr[idy];
//		int itemTOBeAdded = arr[idx];
//		if (itemTOBeAdded == itemTOBeFound) {
//			return;
//		}
//
//		int itemIndex = Arrays.binarySearch(backedArr, itemTOBeFound);
//		int insertionIndex = Arrays.binarySearch(backedArr, itemTOBeAdded);
//		System.out.println("=======>" + insertionIndex);
//		insertionIndex = insertionIndex < 0 ? ~insertionIndex : insertionIndex;
//		System.out.println("xxxxxxxxxxxxx" + insertionIndex);
//		swapTillRange(backedArr, itemIndex, insertionIndex - 1, itemTOBeAdded);
//
//	}
//
//	private static void swapTillRange(int[] backedArr, int itemFOundIndex, int insertionIndex, int itemToBeAdded) {
//
//		if (itemFOundIndex < insertionIndex) { // element to be inserted on right
//			for (int i = itemFOundIndex; i < insertionIndex; i++) {
//				backedArr[i] = backedArr[i + 1];
//			}
//			backedArr[insertionIndex] = itemToBeAdded;
//		} else {
//			for (int i = itemFOundIndex; i - 1 > insertionIndex; i--) {
//				backedArr[i] = backedArr[i - 1];
//			}
//			backedArr[insertionIndex] = itemToBeAdded;
//		}
//
//	}

	public static int activityNotifications(int[] expenditure, int d) {
		int count = 0;
		// this freq array will have only d elements having values 1 and those indices
		// are the values which we are considering
		int Freq[] = new int[201]; // why because we will have value till 200
		for (int i = 0; i < expenditure.length; i++) {
			if (i >= d) {
				if (expenditure[i] >= twiceOfMedian(Freq, d)) {
					count += 1;
				}
				Freq[expenditure[i - d]] -= 1; // this i-d th element is out of range now

			}
			Freq[expenditure[i]] += 1; // this item is in range now
		}

		return count;
	}

	public static int twiceOfMedian(int[] freq, int d) {
		int numberOfElementsLessThanOrEquals = 0;
		for (int i = 0; i < freq.length; i++) {
			numberOfElementsLessThanOrEquals += freq[i];
			if (2 * numberOfElementsLessThanOrEquals < d) { // we have not reached median keep walking

			} else if (2 * numberOfElementsLessThanOrEquals == d) {
				// loop until we find next non zero element and check the median since
				// it is exact multiple of 2 hence we have two elements taking part in median

				for (int j = i + 1;; j++) {
					if (freq[j] != 0) {
						return i + j;
					}
				}
				// median is divide by 2 but we are returning twice of it
			} else
				return 2 * i;
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}

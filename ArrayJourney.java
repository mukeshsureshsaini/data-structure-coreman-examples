import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ArrayJourney {

	public static int arrayMaxInSlidingWindow(int[] arr, int windowSize) {
		int res = arr[0];

		List<Integer> max = slidingWindowMax(arr, 1, windowSize);
		for (int x : max)
			res += x;

		return res;

	}

	public static List<Integer> slidingWindowMax(int arr[], int startIndx, int windowSize) {

		List<Integer> res = new ArrayList<Integer>();
		Deque<Integer> deq = new ArrayDeque<>();

		for (int i = 1; i <= windowSize; i++) {
			maintainQueueForMax(deq, arr, i);
			deq.addLast(i);
		}

		res.add(arr[deq.peekFirst()]);

		for (int i = windowSize + 1; i < arr.length; i++) {
			removeOutOfBoundIndex(deq, windowSize, i);
			maintainQueueForMax(deq, arr, i);
			deq.addLast(i);
			res.add(arr[deq.peekFirst()]);
		}

		return res;

	}

	public static void maintainQueueForMax(Deque<Integer> deq, int[] arr, int idx) {
		while (!deq.isEmpty() && arr[deq.peekLast()] <= arr[idx]) {
			deq.pollLast();
		}
	}

	public static void removeOutOfBoundIndex(Deque<Integer> deq, int windowSize, int idx) {

		while (!deq.isEmpty() && deq.peekFirst() <= idx - windowSize) {
			deq.pollFirst();
		}

	}

	public static void main(String[] args) {
		System.out.println(arrayMaxInSlidingWindow(new int[] { 10, 2, -10, 5, 20 }, 2));
	}
}

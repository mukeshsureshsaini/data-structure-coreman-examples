import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindow {

	public static List<Integer> slidingWindowMax(int[] arr, int windowSize) {
		int length = arr.length;
		List<Integer> res = new ArrayList<>(); // will maintain the result
		Deque<Integer> deq = new ArrayDeque<>(); // will maintain the index

		for (int i = 0; i < windowSize; i++) {
			maintainQueueForMax(deq, arr, i);
			deq.addLast(i);
		}
		res.add(arr[deq.peekFirst()]);
		for (int i = windowSize; i < length; i++) {
			// remove index those are out of boundary
			removeOutOfIndexIndices(deq, windowSize, i);
			maintainQueueForMax(deq, arr, i);
			deq.addLast(i);
			res.add(arr[deq.peekFirst()]);

		}
		return res;

	}

	public static List<Integer> slidingWindowMin(int[] arr, int windowSize) {
		int length = arr.length;
		List<Integer> res = new ArrayList<>();
		Deque<Integer> deq = new ArrayDeque<>();

		for (int i = 0; i < windowSize; i++) {
			maintainQueueForMin(deq, arr, i);
			deq.addLast(i);
		}
		res.add(arr[deq.peekFirst()]);

		for (int i = windowSize; i < length; i++) {
			// remove index those are out of current window bound
			removeOutOfIndexIndices(deq, windowSize, i);
			// maintain the decreasing order
			maintainQueueForMin(deq, arr, i);
			deq.addLast(i);
			res.add(arr[deq.peekFirst()]);

		}
		return res;

	}

	public static void maintainQueueForMax(Deque<Integer> deq, int arr[], int idx) {
		while (!deq.isEmpty() && arr[deq.peekLast()] <= arr[idx]) { // we have bigger element incoming
			deq.pollLast();
		}
	}

	public static void maintainQueueForMin(Deque<Integer> deq, int arr[], int idx) {
		while (!deq.isEmpty() && arr[deq.peekLast()] >= arr[idx]) { // we have smaller element incoming
			deq.pollLast();
		}
	}

	private static void removeOutOfIndexIndices(Deque<Integer> deq, int windowSize, int idx) {
		while (!deq.isEmpty() && deq.peekFirst() <= idx - windowSize) {
			deq.pollFirst();
		}
	}

	public static List<Integer> slidingWindowMaxUsingPQ(int[] arr, int k) {
		List<Integer> res = new ArrayList<>();

		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

			q.add(arr[windowEnd]);
			if (windowEnd - windowStart + 1 == k) { // window ended here
				res.add(q.peek());

				// if the largest element is at windowStart position we need to remove it from
				// queue because now window start will be moving to next item

				if (arr[windowStart] == q.peek())
					q.remove();

				windowStart += 1; // as this will be out of window
			}

		}
		return res;
	}

	public static int[] slidingWindowMin2(int[] array, int window) {

		int[] result = new int[array.length - window + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < array.length; i++) { // Range end index (inclusive)
			int val = array[i];
			while (!deque.isEmpty() && val < deque.getLast())
				deque.removeLast();
			deque.addLast(val);

			int j = i + 1 - window; // Range start index, does not overflow
			if (j >= 0) {
				result[j] = deque.getFirst();
				if (array[j] == result[j]) // why this condition because remove this only if we are done with complete
											// processing from this removing element means this element is not part of
											// sliding window
					deque.removeFirst();
			}
		}
		return result;
	}

	public static void main(String[] args) {

		// System.out.println(slidingWindowMax(new int[] { 177, 329, 133, 414, 57, 224,
		// 219 }, 3));

		// System.out.println(slidingWindowMin(new int[] { 177, 329, 133, 414, 57, 224,
		// 219 }, 3));

		System.out.println(Arrays.toString(slidingWindowMin2(new int[] { 177, 329, 133, 414, 57, 224, 219 }, 3)));

		// System.out.println(slidingWindowMax(new int[] { 10, 2, -10, 5, 20 }, 2));

	}

}

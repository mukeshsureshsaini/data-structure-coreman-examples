import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplate {
	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> leftFeq = new HashMap<>();
		Map<Long, Long> rightFeq = new HashMap<>();
		long result = 0;
		int s = arr.size();
		for (long e : arr) {
			incrementMapValue(rightFeq, e);
		}
		for (int i = 0; i < s; i++) {
			long element = arr.get(i);

			if (element % r == 0) {
				decrementMapValue(rightFeq, element);
				long leftValue = element / r;
				long rightValue = element * r;
				result += (leftFeq.getOrDefault(leftValue, 0L) * rightFeq.getOrDefault(rightValue, 0L));
			}
			incrementMapValue(leftFeq, element);

		}
		return result;

	}

	private static void incrementMapValue(Map<Long, Long> map, Long targetValue) {
		map.put(targetValue, map.getOrDefault(targetValue, 0L) + 1);
	}

	private static void decrementMapValue(Map<Long, Long> map, Long targetValue) {
		if (map.containsKey(targetValue) && map.get(targetValue) != 0) {
			map.put(targetValue, map.get(targetValue) - 1);
		}

	}

	public static void main(String[] args) {
		List<Long> li = new ArrayList<>();
		int n = 0;
		while (n < 100000) {
			li.add(1237L);
			n++;

		}

		System.out.println(countTriplets(li, 1));

		// 166661666700000
		// 5394234669792
		
		
		int x = 1000000000;

	}

	static long countTriplets2(List<Long> arr, long r) {

		Map<Long, Integer> secondTerm = new HashMap<>();
		Map<Long, Integer> thirdTerm = new HashMap<>();
		long result = 0;
		for (Long key : arr) {
			// this key is 3rd term hence increase the count
			result += thirdTerm.getOrDefault(key, 0);
			// this key is second term , hence 3rd term will be multipied by r
			thirdTerm.put(key * r, thirdTerm.getOrDefault(key * r, 0) + secondTerm.getOrDefault(key, 0));
			// neither first term nor second term so it is first term .
			// it second term will be this*r
			secondTerm.put(key * r, secondTerm.getOrDefault(key * r, 0) + 1);

		}
		return result;

	}
}

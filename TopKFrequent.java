import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

	public static int[] topKFrequent(int[] nums, int k) {

		Map<Integer, EF> frequency = new HashMap<>();
		PriorityQueue<EF> pq = new PriorityQueue<>();
		int[] res = new int[k];
		for (int num : nums) {
			EF ef = frequency.getOrDefault(num, new EF(num, 0));
			ef.f += 1;
			frequency.put(num, ef);
		}

		frequency.forEach((key, v) -> {
			pq.add(v);
		});

		for (int x = 0; x < k; x++) {
			res[x] = pq.poll().e;
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
	}

	// [1,1,1,2,2,3]
}

class EF implements Comparable<EF> {
	int e;
	int f;

	public EF(int e, int f) {
		this.e = e;
		this.f = f;
	}

	@Override
	public int compareTo(EF o) {
		return o.f - this.f;
	}

}

import java.util.Arrays;

public class IndexMinPriorityQueue {

	private int count;

	private int maxCnt;

	private int[] pq;

	private int[] qp;

	private int[] keys; // key[i] == priority of i

	public IndexMinPriorityQueue(int maxN) {
		this.maxCnt = maxN;
		this.pq = new int[maxN + 1]; // why +1 because we will have first element at index 1 for simplicity
		this.qp = new int[maxN + 1];
		this.keys = new int[maxN + 1];

		Arrays.fill(qp, -1);
	}

	public boolean isEmpty() {
		return count == 0;
	}

}


// The idea in fenwick tree is that every integer can be represented in power of two 
//so that range can also be represented of power of 2

/**
 * 
 * 
 * Fenwick tree can only be used for 
 * 	range sum queries
 * 
 * @author a13218298
 * 
 *check brillient.org https://brilliant.org/wiki/fenwick-tree/ 
 *
 */
public class FenwickTree {
	private int size;
	private int fenwickTree[];

	public FenwickTree(int[] arr) {
		this.size = arr.length;
		this.fenwickTree = new int[this.size + 1]; // 1 index based fenwick tree,because of simplifying calculation
		for (int i = 0; i < size; i++) {
			update(i, arr[i]);
		}

	}

	public int rangeSumQuery(int idx) {
		idx += 1;
		int sum = 0;
		while (idx > 0) {
			sum += fenwickTree[idx]; // add sum to this
			idx -= idx & (-idx); // go up to its parents
		}

		return sum;
	}

	public int rangeSumQuery(int a, int b) {
		assert b >= a && a > 0 && b > 0;

		return rangeSumQuery(b) - rangeSumQuery(a - 1);
	}

	public void update(int idx, int value) {
		// index is one based for us
		idx += 1;

		while (idx < fenwickTree.length) {
			fenwickTree[idx] += value; // add the value at given index
			idx += idx & (-idx); // go to its children in the tree view
		}
	}
	
	
	public static void main(String[] args) {
		
		FenwickTree ft = new FenwickTree(new int[] {2, 3, -1, 0, 6});
		System.out.println(ft.rangeSumQuery(1,3));
		
	}

}

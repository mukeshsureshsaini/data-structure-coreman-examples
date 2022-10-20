import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int subsets = 1 << nums.length;
		for (int val = 0; val < subsets; val++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if (isBitSet(val, j)) {
					subset.add(nums[j]);
				}
			}
			res.add(subset);
		}
		return res;
	}

	public static boolean isBitSet(int value, int k) {
		return (value & (1 << k)) != 0;
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());

		for (int x : nums) {
			List<Integer> li;
			for (int i = 0; i < res.size(); i++) {
				li = new ArrayList<>(res.get(i).size());
				Collections.copy(li, res.get(i));
				li.add(x);
			}
		}

		return res;

	}

	public static void main(String[] args) {
		//System.out.println(subsets(new int[] { 1, 2, 3 }));
		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
	}
}

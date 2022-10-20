import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static int longestConsecutiveSequence(int[] arr) {

		Set<Integer> numbers = new HashSet<>();
		int maxLen = 1;

		for (int num : arr)
			numbers.add(num);

		for (int num : arr) {
			int leftNum = num - 1;
			int rightNum = num + 1;
			int seqLen = 1;

			// expand left length

			while (numbers.contains(leftNum)) {
				seqLen++;
				numbers.remove(leftNum);
				leftNum -= 1;
			}

			// expand right length

			while (numbers.contains(rightNum)) {
				seqLen++;
				numbers.remove(rightNum);
				rightNum += 1;
			}

			maxLen = Integer.max(seqLen, maxLen);
		}

		return maxLen;

	}

	public static void main(String[] args) {

		System.out.println(longestConsecutiveSequence(new int[] { 100, 4, 200, 1, 3, 2 }));

	}

}

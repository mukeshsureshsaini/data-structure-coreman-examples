import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DefaultDemo {

	public static void main(String[] args) {

		String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		String pattern = "abb";

		findOut(words, pattern).forEach(System.out::println);
	}

	public static List<String> findOut(String[] words, String pattern) {

		LinkedList<Integer> patternList = buildMap(pattern);
		List<String> res = new ArrayList<>();

		for (String word : words) {
			LinkedList<Integer> wordList = buildMap(word);
			if (patternList.equals(wordList)) {
				res.add(word);
			}
		}
		return res;
	}

	public static LinkedList<Integer> buildMap(String str) {
		LinkedList<Integer> patList = new LinkedList<Integer>();
		patList.add(1);
		char previous = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == previous) {
				int v = patList.removeLast();
				patList.add(v + 1);
			} else {
				patList.add(1);
				previous = current;
			}
		}
		return patList;

	}

}

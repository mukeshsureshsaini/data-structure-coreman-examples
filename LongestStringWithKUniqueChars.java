import java.util.HashSet;
import java.util.Set;

public class LongestStringWithKUniqueChars {

	public static String longestStringWithKUniqueChars(String s, int k) {
		Set<Character> window = new HashSet<>();

		int low = 0, high = 0;

		int SLen = s.length();
		for (char c : s.toCharArray()) {

			if (window.contains(c)) {

			}
		}
		return null;

	}

	public static void main(String[] args) {

	}
}

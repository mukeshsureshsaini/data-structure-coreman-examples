import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TelephoneNumberString {

	private Map<Integer, String> buildMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		return map;
	}

	public List<String> buildList(String digits) {

		Deque<String> res = new ArrayDeque<String>();
		Deque<String> temStck = new ArrayDeque<>();
		Map<Integer, String> map = buildMap();

		for (char c : map.get(digits.charAt(0) - '0').toCharArray()) {
			res.add("" + c);
		}

		for (int i = 1; i < digits.length(); i++) {
			String str = map.get(digits.charAt(i) - '0');
			
			for (char ch : str.toCharArray()) {
				
			}

		}

		return null;
	}
}

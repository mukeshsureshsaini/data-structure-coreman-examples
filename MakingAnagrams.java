import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakingAnagrams {

	public static List<Integer> makingAnagrams(List<String> l1, List<String> li2) {

		List<Integer> li = new ArrayList<>();

		for (int i = 0; i < l1.size(); i++) {
			li.add(diff(l1.get(i), li2.get(i)));
		}
		return li;
	}

	public static int diff(String s1, String s2) {
		if (s1.length() != s2.length())
			return -1;
		int s1F[] = new int[26];
		int s2F[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			s1F[s1.charAt(i) - 'a'] += 1;
			s2F[s2.charAt(i) - 'a'] += 1;
		}
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (s1F[i] != 0 && s2F[i] != 0)
				cnt += Math.abs(s1F[i] - s2F[i]);
			else
				cnt += s1F[i];
		}
		return cnt;

	}

	public static void main(String[] args) {
		System.out.println(makingAnagrams(Arrays.asList("tea", "tea", "act", "mn", "bab"),
				Arrays.asList("ate", "toe", "acts", "oo", "aba")));
	}

}

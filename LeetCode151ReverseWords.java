
public class LeetCode151ReverseWords {
	public static String reverseWords(String s) {
		int len = s.length();
		if (len == 1)
			return s;
		else {
			String res = "";
			int i = 0;
			int j = 1;

			//s = s.trim();
			while (j < len) {
				char cur = s.charAt(j);
				char prev = s.charAt(j - 1);
				if (cur == ' ' && prev == ' ') { // continue space
					i = j;
					j = i + 1;
				} else if (cur == ' ' && prev != ' ') { // word end here
					res = s.substring(i, j) + " " + res;
					i = j + 1;
					j = i + 1;
				} else if (cur != ' ' && prev == ' ') { // new word is starting
					i = j;
					j = i + 1;
				} else
					j++;
			}
			res = s.substring(i, j) + " " + res;

			return res.trim();
		}

	}

	static public boolean isSpace(char c) {
		return c == ' ';
	}

	public static void main(String[] args) {
		String s = "the sky is blue";
		s = "  Bob    Loves  Alice   ";
		System.out.println(reverseWords(s));
	}
}

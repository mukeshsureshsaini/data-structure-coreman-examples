
public class ReverseWordsInString {
	public static String reverseWords(String s) {
		int i = 0;
		StringBuilder res = new StringBuilder();
		String temp = "";

		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == ' ') {
				res.append(temp).append(" ");
				temp = "";
			} else {
				temp = "" + c + temp;
			}
			
			i+=1;
			
		}
		res.append(temp);
		return res.toString();
	}
	
	
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}
}

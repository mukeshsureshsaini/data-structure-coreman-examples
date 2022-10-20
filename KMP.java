import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
 * 
 * @author a13218298
 * 
 * 
 *         CLRS ch :32 Rule 1 : In prefix table value of elements can be
 *         increased only by one
 * 
 *         KMP is useful when there are too much repeated chars in patterns and
 *         in text
 *
 */

public class KMP {

	private String pattern;
	private String text;
	private int[] pf;
	private int idx;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public KMP(String pattern, String text) {
		this.pattern = pattern;
		this.text = text;
		this.pf = prefixArr(pattern);
	}

	public KMP(String pattern) {
		this.pattern = pattern;
		this.pf = prefixArr(pattern);
	}

	private int[] prefixArr(String pattern) {
		int len = pattern.length();
		int prefixTable[] = new int[len];
		prefixTable[0] = 0; // this line is redundant but important for understanding purpose
		// j representing the length of longest prefix suffix of pattern
		int j;
		for (int i = 1; i < len; i++) {

			j = prefixTable[i - 1]; // start with last i prefix table and try to extend it by 1

			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = prefixTable[j - 1]; // try smaller j
			}

			if (pattern.charAt(j) == pattern.charAt(i)) {
				prefixTable[i] = j + 1;
			} else
				prefixTable[i] = 0; // this is redundant as array elements are initialize to 0
		}

		return prefixTable;

	}

	public boolean match(String txt) {
		// Tries to find an occurence of the pattern in the string
		int j = 0;
		if (txt.length() == 0)
			return false;

		for (int i = 0; i < txt.length(); i++) {
			while (j > 0 && pattern.charAt(j) != txt.charAt(i)) {
				j = pf[j - 1];
			}
			if (pattern.charAt(j) == txt.charAt(i)) {
				j++;
			}
			if (j == pattern.length()) {
				setIdx(i - pattern.length() + 1);
				return true;
			}
		}
		return false;
	}

	public int search(String text) {
		int M = pattern.length();
		int N = text.length();
		int i = 0, j = 0;
		while (i < M && j < N) {
			if (pattern.charAt(i) == text.charAt(j)) {
				i++;
				j++;
			} else if (i == 0) // lps == 0 do a minimum char shift
				j++;
			else {
				j = this.pf[j - 1] + 1;
			}
		}

		return 0;

	}

	private List<Integer> getAllIndices() {
		return searchAll(this.pattern, this.text);
	}

	private List<Integer> searchAll(String pattern, String text) {

		int N = pattern.length();
		int M = text.length();
		List<Integer> indices = new ArrayList<>();
		String s = pattern + "#" + text;

		int pi[] = prefixArr(s);

		for (int j = N + 1; j < N + M + 1; j++) {
			if (pi[j] == N) {

				indices.add(j - (N << 1));
			}
		}

		return indices;

	}

	public static void main(String[] args) {

//		KMP kmp = new KMP("AABA", "AABAACAADAABAABA");
//
//		for (int idx : kmp.getAllIndices()) {
//			System.out.println(kmp.getText().substring(idx, idx + 4));
//		}
		

		KMP kmp = new KMP("AABA");

		if (kmp.match("AABAACAADAABAABA"))
			System.out.println(kmp.getIdx());

	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	
	
	
}

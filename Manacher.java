public class Manacher {

	private String txt;
	private char[] transformed;
	private int[] P; // p is representing palindrome length of string centered at ith index

	public Manacher(String s) {
		this.txt = s;
		this.transformed = infuse();
		P = new int[(this.txt.length() << 1) + 3];
		preporcess();

	}

	private char[] infuse() {

		int n = this.txt.length();
		int x = (n << 1) + 3;
		char ch[] = new char[x];
		ch[0] = '^';
		ch[x - 2] = '#';
		ch[x - 1] = '@';

		for (int i = 0; i < n; i++) {
			ch[2 * i + 1] = '#';
			ch[2 * i + 2] = txt.charAt(i);

		}

		return ch;
	}

	private void preporcess() {

		int currentCentre = 0; // center
		int right= 0; // right , we don't need left as we have center and right and we use Symmetry
					// then
					// left is dist(C - dist(R-C))
		int len = transformed.length;

		for (int cntr = 1; cntr < len - 1; cntr++) { // why length-1 because we have added ^@ at terminals and we have to ignore
											// them by start from 1 to len-1

			int left = (currentCentre << 1) - cntr; // 2*currentCentr-cntr

			// if we are under boundaries symmetry will follow

			if (right > cntr) // we is the min chars we dont need to compare as we have done them previously
				P[cntr] = Math.min(right - cntr, P[left]);

			// expand around current centre 
			while (transformed[cntr + P[cntr] + 1] == transformed[cntr - (P[cntr] + 1)])
				P[cntr]++;

			// check if ( current center at i and length of palindrome centered at i) crossed the right
			// boundary we found a new palindrome at i hence update the centre and update the right bounry
			//we dont need left as we have symetry around the centre
			if (cntr + P[cntr] > right) {
				// update the center
				currentCentre = cntr;

				// update right boundary

				right = cntr + P[cntr];
			}
		}

	}

	public String lps() {

		int centre = 0;
		int maxLength = P[centre];
		for (int i = 1; i < P.length; i++) {

			if (P[i] > maxLength) {
				centre = i;
				maxLength = P[i];
			}
		}

		return txt.substring((centre - 1 - maxLength) / 2, (centre - 1 + maxLength) / 2);
	}

	public static void main(String[] args) {

		Manacher m = new Manacher("abba");
		System.out.println(m.lps());
	}
}

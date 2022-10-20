
public class SparseTableRMQ {

	int[][] st;
	int[] blog;

	public SparseTableRMQ(int[] data) {

		preporcess(data);
	}

	private void preporcess(int[] data) {
		int len = data.length;
		blog(len);
		int k = (int) (Math.log(len) / Math.log(2));
		st = new int[len][k+1];

		// filling the first column as we are findinding max for len 1
		for (int i = 0; i < len; i++)
			st[i][0] = data[i];

		for (int j = 1; j <= k; j++) {

			// use previously stored value to calculate

			for (int i = 0; i + (1 << j) <=len; i++) {
				st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
			}

		}
		
		

	}

	public int rangeMin(int left, int right) {
		int k = blog[right - left + 1];
		return Math.min(st[left][k], st[right - (1 << k) + 1][k]);
	}

	private void blog(int value) {
		blog = new int[value + 1];
		blog[1] = 0;
		for (int i = 2; i <= value; i++)
			blog[i] = blog[i / 2] + 1;

	}

	public static int nextPowerOf2(int x) {
		x--;
		x |= x >> 1;
		x |= x >> 2;
		x |= x >> 4;
		x |= x >> 8;
		x |= x >> 16;
		x++;
		return x;
	}

	public static int lesserPowerOf2(int x) {
		x--;
		x |= x >> 1;
		x |= x >> 2;
		x |= x >> 4;
		x |= x >> 8;
		x |= x >> 16;
		x++;
		return (x >>= 1);

	}

	public static void main(String[] args) {

		SparseTableRMQ stRMQ = new SparseTableRMQ(
				new int[] { 31, 41, 59, 26, 53, 58, 97, 93, 23, 84, 62, 43, 33, 83, 27, 95, 2, 88, 41, 97 });

		System.out.println(stRMQ.rangeMin(1, 7));
	}

}


public class FindMajorityElementCOnstantSpace {

	public static int findMajority(int[] arr) {
		int element = 0;
		int count = 0;

		for (int e : arr) {
			if (count == 0)
				element = e;
			if (e == element)
				count += 1;
			else
				count -= 1;
		}

		return element;
	}

	public static void main(String[] args) {

		System.out.println(findMajority(new int[] {2,2,1,1,1,1,2}));
	}
}

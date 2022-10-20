import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FormLargestNumberFromArray {

	public static String formLargetNumberFromArray(int[] arr) {

		String[] strArray = Arrays.stream(arr).boxed().map(String::valueOf).collect(Collectors.toList())
				.toArray(new String[arr.length]);

		Comparator<String> cmp = (s, t) -> {
			String st = s.concat(t);
			String ts = t.concat(s);
			return ts.compareTo(st);
		};

		Arrays.sort(strArray, cmp);

		System.out.println(Arrays.toString(strArray));
		return Arrays.stream(strArray).collect(Collectors.joining());

	}

	public static void main(String[] args) {

		System.out.println(formLargetNumberFromArray(new int[] { 3, 30, 34, 5, 9 }));
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringcomparisonWithoutConvertingInIngteger {

	public static List<String> getBigger(List<String> li) {

		Comparator<String> comp = (x, y) -> {
			int s1Length = x.length();
			int s2Length = y.length();
			if (s1Length == s2Length) {
				return x.compareTo(y);
			} else
				return s1Length - s2Length;
		};

		Collections.sort(li, comp);

		return li;

	}

	public static void main(String[] args) {
		List<String> li = Arrays.asList("1", "2", "100", "12303479849857341718340192371", "3084193741082937",
				"3084193741082938", "111", "200","100");
		
		System.out.println(getBigger(li));
	}

}

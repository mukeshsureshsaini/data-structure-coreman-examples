import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class MaxSumModuloM {

	public static long maximumSumModouloM(List<Long> a, long m) {

		long arr[] = new long[a.size()];
		arr[0] = a.get(0);
		long MAX = arr[0];
		NavigableSet<Long> set = new TreeSet<>();
		set.add(arr[0]);

		for (int i = 1; i < a.size(); i++) {
			arr[i] = (arr[i - 1] + a.get(i))%m;
			long justHigherElement =  nextGreaterElement(set, arr[i]);
			MAX = Math.max(MAX, (arr[i]-justHigherElement+m)%m);
			set.add(arr[i]);

		}
		
		
		return MAX;

	}

	public static long nextGreaterElement(NavigableSet<Long> set, long value) {
		Long nexHigher = set.higher(value);
		return nexHigher == null ? 0 : nexHigher.longValue();
	}

	public static void main(String[] args) {
		List<Long> a = Arrays.asList(3L, 3L, 9L, 9L, 5L);
		System.out.println(maximumSumModouloM(a, 7));

	}
	
	
	
	public long solve( List<Long> li , long modulo) {
		

			int n = li.size();
			long m = modulo;
			long[] a = new long[n];
			TreeSet<Long> set = new TreeSet<>();
			long ans = 0;
			for (int i = 0; i < n; i++) {
				a[i] = li.get(i) % m;
				if (i > 0) {
					a[i] = (a[i - 1] + a[i]) % m;
				}
				ans = Math.max(ans, a[i]);

				Long higher = set.higher(a[i]);
				if (higher != null) {
					ans = Math.max(ans, ((a[i] - higher) % m + m) % m);
				}

				set.add(a[i]);
			}
	return ans;
	}
}

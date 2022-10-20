
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<int[]> queries) {
		Map<Integer, Integer> freq = new HashMap<>();
		Map<Integer, Integer> Revfreq = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (int[] query : queries) {
			int type = query[0];
			int element = query[1];
			if (type == 1) {
				increaseFreq(freq, Revfreq, element);
			} else if (type == 2) {
				decrementFreq(freq, Revfreq, element);
			} else if (type == 3) {
				result.add(queryFreq(Revfreq, element));
			}
		}
		return result;

	}

	public static void increaseFreq(Map<Integer, Integer> freq, Map<Integer, Integer> revFreq, int element) {
		Integer oldF = freq.getOrDefault(element, 0);
		freq.put(element, oldF + 1);
		Integer revF = revFreq.getOrDefault(oldF + 1, 0);
		revFreq.put(oldF + 1, revF + 1);
		if (oldF > 0 && revFreq.getOrDefault(oldF, 0) > 0) {
			revFreq.put(oldF, revFreq.get(oldF) - 1);
		}

	}

	public static void decrementFreq(Map<Integer, Integer> freq, Map<Integer, Integer> revFreq, int element) {

		freq.putIfAbsent(element, 0);
		Integer f = freq.get(element);
		freq.put(element, f > 0 ? f - 1 : 0);

		if (revFreq.getOrDefault(f, 0) > 0) {
			revFreq.put(f, revFreq.get(f) - 1);
		}

		revFreq.put(f - 1, revFreq.getOrDefault(f - 1, 0) + 1);

	}

	public static int queryFreq(Map<Integer, Integer> map, int freq) {
		if (map.containsKey(freq) && map.get(freq) != null && map.get(freq) > 0) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
				Files.newInputStream(Paths.get("/Users/a13218298/Desktop/input.txt"), StandardOpenOption.READ)))) {
			int q = Integer.parseInt(bufferedReader.readLine().trim());
			List<int[]> queries = new ArrayList<>(q);
			Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
			for (int i = 0; i < q; i++) {
				int[] query = new int[2];
				Matcher m = p.matcher(bufferedReader.readLine());
				if (m.matches()) {
					query[0] = Integer.parseInt(m.group(1));
					query[1] = Integer.parseInt(m.group(2));
					queries.add(query);
				}
			}
			String s = "000000000000000100101011101100010000000100100010111111010110000010110000001110111"
					+ "0110111110010011001101110111000100100110010010001100000101010100"
					+ "0000101001000111111111111111111010100111101111111011111110101111"
					+ "0111111111111111111111111111011101111111111111111111111111111111"
					+ "111111111111111111111111111111111111111111111111101111111111";

			List<Integer> output = new ArrayList<>();

			for (char c : s.toCharArray()) {

				output.add(Character.getNumericValue(c));
			}
			List<Integer> ans = freqQuery(queries);
			System.out.println(ans);
			System.out.println(output);
			
		}
	}

}

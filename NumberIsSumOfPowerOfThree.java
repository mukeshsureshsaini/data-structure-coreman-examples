import java.util.ArrayDeque;
import java.util.Deque;

public class NumberIsSumOfPowerOfThree {

	public static boolean checkPowersOfThree(int n) {
		if (n == 0 || n < 3)
			return false;
		Deque<Integer> stack = new ArrayDeque<>();
		int i = 1;
		while (i <= n) {
			stack.push(i);
			i = i * 3;
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			if (sum + stack.peek() <= n) {
				sum += stack.peek();
			}
			stack.pop();
		}
		return sum == n;

	}

	public static void main(String[] args) {

		System.out.println(checkPowersOfThree(91));

		System.out.println(checkPowersOfThree(12));

		System.out.println(checkPowersOfThree(243));
	}
}

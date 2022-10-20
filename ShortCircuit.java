
public class ShortCircuit {

	public static boolean secondCondition() {

		System.out.println("Second condition");
		return true;
	}

	public static boolean firstCondition() {

		System.out.println("first condition");
		return true;
	}

	public static void main(String[] args) {

		if (firstCondition() || secondCondition()) {
			System.out.println("Hrrah");
		}else {
			
			System.out.println("no way");
		}
	}
}

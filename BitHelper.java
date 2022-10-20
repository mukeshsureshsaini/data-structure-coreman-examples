
public class BitHelper {

	public static long setBit(long value, int idx) {
		long mask = 1L << idx;
		return value | mask;

	}

	public static long clearBit(long value, int idx) {
		long mask = ~(1L << idx);
		return value & mask;
	}

	public static boolean isBitSet(long value, int idx) {
		long mask = value >> idx;
		return (mask & 1L) == 1L;
	}

	public static long toggleBit(long value, int idx) {
		return value ^ (1L << idx);
	}

	public static boolean onlyBitSet(long value) {
		if (value == 0)
			return false;
		return (value & value - 1L) == 0;
	}
}

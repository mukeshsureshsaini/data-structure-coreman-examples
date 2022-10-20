import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/******************************************************************************
 * Compilation: javac Queens.java Execution: java Queens n
 * 
 * Solve the 8 queens problem using recursion and backtracing. Prints out all
 * solutions.
 *
 * Limitations: works for n <= 25, but slows down considerably for larger n.
 *
 * Remark: this program implicitly enumerates all n^n possible placements
 * (instead of n!), but the backtracing prunes off most of them, so it's not
 * necessarily worth the extra complication of enumerating only permutations.
 *
 *
 * % java Queens 3
 *
 * % java Queens 4 * Q * * * * * Q Q * * * * * Q *
 *
 * * * Q * Q * * * * * * Q * Q * *
 *
 * % java Queens 8 Q * * * * * * * * * * * Q * * * * * * * * * * Q * * * * * Q *
 * * * * Q * * * * * * * * * * * Q * * Q * * * * * * * * * Q * * * *
 *
 * ...
 * 
 * 
 * 
 * 
 * https://stackoverflow.com/questions/60473211/diagonally-check-the-n-queen-java   // how digonality constraint obtained 
 * 
 *  The queens are in same diagonal if their horizontal distance (difference in column)  and vertical distance (difference in row) is same
 *
 ******************************************************************************/

public class Queens {

	public static int totalConf = 0;

	/***************************************************************************
	 * Return true if queen placement q[n] does not conflict with other queens q[0]
	 * through q[n-1]
	 ***************************************************************************/
	public static boolean isConsistent(int[] q, int row) {
		for (int ithRow = 0; ithRow < row; ithRow++) {
			if (q[ithRow] == q[row])
				return false; // same column
			if ((q[ithRow] - q[row]) == (row - ithRow))
				return false; // same major diagonal
			if ((q[row] - q[ithRow]) == (row - ithRow))
				return false; // same minor diagonal
		}
		return true;
	}

	/***************************************************************************
	 * Prints n-by-n placement of queens from permutation q in ASCII.
	 ***************************************************************************/
	public static void printQueens(int[] q) {
		totalConf++;
		int n = q.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (q[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/***************************************************************************
	 * Try all permutations using backtracking
	 ***************************************************************************/
	public static void enumerate(int n) {
		int[] a = new int[n];	
		enumerate(a, 0);
	}

	public static void enumerate(int[] q, int row) {
		int n = q.length;
		if (row == n)
			printQueens(q);
		else {
			for (int col = 0; col < n; col++) {
				 
				q[row] = col; // try to place queen for row in col column
				if (isConsistent(q, row)) // is placement is consistent
					enumerate(q, row + 1); // go to next row and try to place next queen 
			}
		}
	}

	public static void main(String[] args) {

			enumerate(8);

	}

	public static int bitCount(int i) {
		i = i - ((i >>> 1) & 0x55555555);
		i = ((i >>> 2) & 0x33333333) + (i & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		return i & 0x3f;
	}

	public String toBinary(int a) {

		if (a < 2)
			return String.valueOf(a);
		return toBinary(a / 2) + a % 2;

	}
	
	
	

	/*
	 * 
	 * 
	 * v = v - ((v >> 1) & 0x55555555); v = (v & 0x33333333) + ((v >> 2) &
	 * 0x33333333); c = ((v + (v >> 4) & 0xF0F0F0F) * 0x1010101) >> 24;
	 * 
	 */
}
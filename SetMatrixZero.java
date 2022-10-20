import java.util.Arrays;

public class SetMatrixZero {

	public static void setZeroes(int[][] matrix) {

		int r = matrix.length;
		int c = matrix[0].length;
		boolean rowZero = false;
		boolean colZero = false;

		// zero th col zero
		for (int row = 0; row < r; row++) {
			if (matrix[row][0] == 0) {
				rowZero = true;
				break;
			}
		}

		// zero th row zero
		for (int col = 0; col < c; col++) {
			if (matrix[0][col] == 0) {
				colZero = true;
				break;
			}
		}

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// make row zero and column zero

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}

		// check [0,0]
		// if it was originally zero then make zero only else it has been already
		// handled
		if (rowZero) {
			for (int i = 0; i < r; i++) {
				matrix[i][0] = 0;
			}
			if(colZero) {
				for (int j = 0; j < c; j++) {
					matrix[0][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) {

		int mat[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

		int[][] mat1 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

//		for(int [] x : mat) {
//			System.out.println(Arrays.toString(x));
//		}

		setZeroes(mat1);

		for (int[] x : mat1) {
			System.out.println(Arrays.toString(x));
		}
	}

}

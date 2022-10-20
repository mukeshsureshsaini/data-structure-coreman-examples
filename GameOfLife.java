import java.util.Arrays;

public class GameOfLife {

	public static final int WAS_DEAD_IS_DEAD = 2;
	public static final int WAS_LIVE_IS_DEAD = 4;
	public static final int WAS_DEAD_IS_LIVE = 6;
	public static final int WAS_LIVE_IS_LIVE = 8;

	public static void gameOfLife(int[][] board) {
		int[] upperMainDiag = { -1, -1 };
		int[] lowerMainDiag = { 1, 1 };
		int[] upperOffDiag = { -1, +1 };
		int[] loweOffDiag = { 1, -1 };
		int[] up = { -1, 0 };
		int[] down = { 1, 0 };
		int[] left = { 0, -1 };
		int[] right = { 0, 1 };

		int[][] eightNeighbors = {
				upperMainDiag, lowerMainDiag,
				upperOffDiag, loweOffDiag, 
				up, down, 
				left, right };

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveNeighbors = liveCount(board, i, j, m, n, eightNeighbors);
				if (board[i][j] == 1) {
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						board[i][j] = WAS_LIVE_IS_DEAD;
					} else if (liveNeighbors == 2 || liveNeighbors == 3) {
						board[i][j] = WAS_LIVE_IS_LIVE;
					}
				} else {
					if (liveNeighbors == 3) {
						board[i][j] = WAS_DEAD_IS_LIVE;
					} else {
						board[i][j] = WAS_DEAD_IS_DEAD;
					}
				}

			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == WAS_LIVE_IS_DEAD || board[i][j] == WAS_DEAD_IS_DEAD) { // was live became dead or was dead is dead
					board[i][j] = 0;
				} else if (board[i][j] == WAS_DEAD_IS_LIVE || board[i][j] == WAS_LIVE_IS_LIVE) { // was live is live ||
																									// was dead became
																									// live

					board[i][j] = 1;
				}
			}
		}
	}

	public static int liveCount(int[][] board, int i, int j, int m, int n, int[][] eightNeighbors) {
		int live = 0;
		for (int[] direction : eightNeighbors) {
			int row = i + direction[0];
			int col = j + direction[1];
			if (isValidDirection(row, col, m, n) && wasOrIsCellLive(board, row, col)) {
				live += 1;
			}
		}
		return live;
	}

	public static boolean isValidDirection(int x, int y, int r, int c) {
		return (x >= 0 && x < r) && (y >= 0 && y < c);
	}

	public static boolean wasOrIsCellLive(int[][] board, int row, int col) {
		return board[row][col] == WAS_LIVE_IS_DEAD || board[row][col] == WAS_LIVE_IS_LIVE || board[row][col] == 1;
	}

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		gameOfLife(arr);

		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}

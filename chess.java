package Class10_3Feb;

public class chess {
	public static boolean isitsafe(boolean[][] board, int row, int col) {
		int c = 0, r = 0;
		// vertically up
		r = row - 1;
		c = col;
		while (r >= 0) {
			if (board[r][c] == true)
				return false;

			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true)
				return false;

			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c] == true)
				return false;

			r--;
			c++;
		}

		return true;
	}

	public static int nqueens(int row, boolean[][] board, String ans) {

		if (row >= board.length) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;
		for (int col = 0; col < board[0].length; col++) {
			board[row][col] = true;
			if (isitsafe(board, row, col))
				count += nqueens(row + 1, board, ans + "(" + row + "," + col + ")");
				board[row][col] = false;
			
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(nqueens(0, new boolean[4][4], ""));
	}

}

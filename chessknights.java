package Class10_3Feb;

public class chessknights {

	public static boolean isitsafe(boolean[][] board, int row, int col) {
		int c = 0, r = 0;
		r = row - 1;
		c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true)
				return false;

			r -= 2;
			c--;
		}

		r = row + 1;
		c = col;
		while (r <= board.length && c <= board[0].length) {
			if (board[r][c] == true)
				return false;

			r += 2;
			c++;
		}

		r = row + 1;
		c = col;
		while (r <= board.length && c >= 0) {
			if (board[r][c] == true)
				return false;

			r += 2;
			c--;
		}

		r = row - 1;
		c = col;
		while (r >= 0 && c <= board[0].length) {
			if (board[r][c] == true)
				return false;

			r -= 2;
			c++;
		}
		return true;
	}

	public static int knights(int row, boolean[][] board, String ans) {

		if (row >= board.length) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;
		for (int col = 0; col < board[0].length; col++) {
			board[row][col] = true;
//			if (isitsafe(board, row, col))
				count += knights(row + 1, board, ans + "(" + row + "," + col + ")");
			board[row][col] = false;

		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		knights(0, new boolean[2][2], "");
	}

}

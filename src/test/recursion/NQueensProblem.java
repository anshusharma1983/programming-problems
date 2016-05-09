package test.recursion;

/*
 We have discussed Knight’s tour and Rat in a Maze problems in Set 1 and Set 2 respectively. Let us discuss N Queen as another example problem that can be solved using Backtracking.

 The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. For example, following is a solution for 4 Queen problem.

 The expected output is a binary matrix which has 1s for the blocks where queens are placed. For example following is the output matrix for above 4 queen solution.

 { 0,  1,  0,  0}
 { 0,  0,  0,  1}
 { 1,  0,  0,  0}
 { 0,  0,  1,  0}
 */
public class NQueensProblem {
	static int N = 4;

	public static void printSolution(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * More efficient than mine
	 */
	static boolean isSafe2(int board[][], int row, int col) {
		int i, j;

		/* Check this row on left side */
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	public static boolean isSafe(int[][] board, int row, int col) {
		// false if a queen in same column
		for (int i = 0; i <= row; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}
		// false if a queen in same row
		for (int i = 0; i <= col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		// false if queen in same diagonal
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {
				if (board[i][j] == 1) {
					if (Math.abs(col - j) == Math.abs(row - i)) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static boolean solveNQueen(int[][] board, int col) {
		if (col >= N) {
			return true;
		}
		// iterate rows
		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col)) {
				// System.out.println("placing queen at:" + i + ":" + col);
				board[i][col] = 1;
				// check if the solution exists
				if (solveNQueen(board, col + 1) == true) {
					return true;
				}else {
					// backtrack
					// System.out.println("removing queen at:" + i + ":" + col);
					board[i][col] = 0;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } };
		if (solveNQueen(board, 0)) {
			printSolution(board);
		} else {
			System.out.println("Solution does not exist");
		}
		// for (int i = 0; i < N; i++) {
		// for (int j = 0; j < N; j++) {
		// System.out.print(" " + isSafe(board, i, j));
		// }
		// System.out.println();
		// }
	}
}

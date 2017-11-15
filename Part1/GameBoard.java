import java.util.*;
public class GameBoard {
	private int[][] board;
	private boolean[][] unCovered; // stores whether a cell is uncovered (revealed)
	private boolean[][] flagged; // stores whether a cell is marked as having a nettle
	private int neetleCount; // total count of nettles in the board
	private int coveredCount; // total cells yet to be revealed

	public GameBoard(int[][] board) {
		this.board = board;
		this.unCovered = new boolean[board.length][board.length];
		this.flagged = new boolean[board.length][board.length];
		int count = 0;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board.length; ++j) {
				if (board[i][j] == -1) ++count;
			}
		}
		this.neetleCount = count;
		this.coveredCount = board.length * board.length;
	}

	public int uncover(int x, int y) { // returns the number under the cell and marks it as revealed
		if (!unCovered[x][y]) {
			unCovered[x][y] = true;
			--coveredCount;
		}
		return board[x][y];
	}

	public int getSize() {
		return board.length;
	}

	public boolean isUncovered(int x, int y) {
		return unCovered[x][y];
	}

	public int getNeetleCount() {
		return neetleCount;
	}

	public int getCoveredCount() {
		return coveredCount;
	}

	public void flag(int x, int y) { // marks the cell as having a nettle
		flagged[x][y] = true;
	}

	public boolean isFlagged(int x, int y) {
		return flagged[x][y];
	}
}
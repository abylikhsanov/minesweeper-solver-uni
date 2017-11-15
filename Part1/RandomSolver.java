import java.util.*;
public class RandomSolver {
	GameBoard board;
	List<Position> coveredPositions; // collection of cells yet to be revealed

	class Position { // position of a cell
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public RandomSolver(GameBoard board) {
		this.board = board;
		coveredPositions = new ArrayList<Position>();

		for (int i = 0; i < board.getSize(); ++i) {
			for (int j = 0; j < board.getSize(); ++j) {
				if (!board.isUncovered(i, j)) {
					coveredPositions.add(new Position(i, j));
				}
			}
		}
	}

	boolean start() {
		if (!reveal(0, 0)) return false; // start revealing cells from 0,0
		while (board.getCoveredCount() > board.getNeetleCount()) {
			int random = (int) (Math.random() * coveredPositions.size());
			if (!reveal(coveredPositions.get(random).x, coveredPositions.get(random).y)) {
				return false; // found nettle
			}
		}
		return true;
	}

	boolean reveal(int x, int y) {
		if (board.isUncovered(x, y)) return true; // already revealed
		// remove from the collection of covered positions
		for (int i = 0; i < coveredPositions.size(); ++i) {
			if (coveredPositions.get(i).x == x && coveredPositions.get(i).y == y) {
				coveredPositions.remove(i);
				break;
			}
		}

		System.out.println("reveal " + x + " " + y);
		int i = board.uncover(x, y);
		if (i == -1) return false; // found neetle, game over
		if (i == 0) { // safe to reveal all adjacent cells
			if (x - 1 >= 0) {
				if (!reveal(x - 1, y)) return false;
			}
			if (x + 1 < board.getSize()) {
				if (!reveal(x + 1, y)) return false;
			}
			if (y - 1 >= 0) {
				if (!reveal(x, y - 1)) return false;
			}
			if (y + 1 < board.getSize()) {
				if (!reveal(x, y + 1)) return false;
			}
			if (x - 1 >= 0 && y - 1 >= 0) {
				if (!reveal(x - 1, y - 1)) return false;
			}
			if (x - 1 >= 0 && y + 1 < board.getSize()) {
				if (!reveal(x - 1, y + 1)) return false;
			}
			if (x + 1 < board.getSize() && y - 1 >= 0) {
				if (!reveal(x + 1, y - 1)) return false;
			}
			if (x + 1 < board.getSize() && y + 1 < board.getSize()) {
				if (!reveal(x + 1, y + 1)) return false;
			}
		}
		return true;
	}
}
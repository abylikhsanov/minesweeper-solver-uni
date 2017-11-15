import java.util.*;
public class ProbabilitySolver {
	GameBoard board;
	int flagCount;

	class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public ProbabilitySolver(GameBoard board) {
		this.board = board;
		this.flagCount = 0;
	}

	boolean start() {
		if (!reveal(0, 0)) return false;
		while (board.getCoveredCount() > board.getNeetleCount() && flagCount < board.getNeetleCount()) {
			flag();
			// reveal safe cells and mark unsafe cells for having mine until no
			// more obvious safe/unsafe cells are left
			while(revealSafeCells() && flag());
			// if all nettles are marked, game won
			if(!(board.getCoveredCount() > board.getNeetleCount() && flagCount < board.getNeetleCount())) {
				break;
			}
			Position nextReveal = getNextReveal();
			if (!reveal(nextReveal.x, nextReveal.y)) {
				return false; // found nettle
			}
		}
		return true;
	}

	boolean revealSafeCells() {
		for (int i = 0; i < board.getSize(); ++i) {
			for (int j = 0; j < board.getSize(); ++j) {
				if (board.isUncovered(i, j) && board.uncover(i, j) != 0) {
					int c = 0;
					if (i - 1 >= 0) {
						if (board.isFlagged(i - 1, j)) ++c;
					}
					if (i + 1 < board.getSize()) {
						if (board.isFlagged(i + 1, j)) ++c;
					}
					if (j - 1 >= 0) {
						if (board.isFlagged(i, j - 1)) ++c;
					}
					if (j + 1 < board.getSize()) {
						if (board.isFlagged(i, j + 1)) ++c;
					}
					if (i - 1 >= 0 && j - 1 >= 0) {
						if (board.isFlagged(i - 1, j - 1)) ++c;
					}
					if (i - 1 >= 0 && j + 1 < board.getSize()) {
						if (board.isFlagged(i - 1, j + 1)) ++c;
					}
					if (i + 1 < board.getSize() && j - 1 >= 0) {
						if (board.isFlagged(i + 1, j - 1)) ++c;
					}
					if (i + 1 < board.getSize() && j + 1 < board.getSize()) {
						if (board.isFlagged(i + 1, j + 1)) ++c;
					}
					if (c == board.uncover(i, j)) {
						boolean check = false;
						if (i - 1 >= 0) {
							if (!board.isFlagged(i - 1, j) && !board.isUncovered(i - 1, j)) {
								reveal(i - 1, j);
								check = true;
							}
						}
						if (i + 1 < board.getSize()) {
							if (!board.isFlagged(i + 1, j) && !board.isUncovered(i + 1, j)) {
								reveal(i + 1, j);
								check = true;
							}
						}
						if (j - 1 >= 0) {
							if (!board.isFlagged(i, j - 1) && !board.isUncovered(i, j - 1)) {
								reveal(i, j - 1);
								check = true;
							}
						}
						if (j + 1 < board.getSize()) {
							if (!board.isFlagged(i, j + 1) && !board.isUncovered(i, j + 1)) {
								reveal(i, j + 1);
								check = true;
							}
						}
						if (i - 1 >= 0 && j - 1 >= 0) {
							if (!board.isFlagged(i - 1, j - 1) && !board.isUncovered(i - 1, j - 1)) {
								reveal(i - 1, j - 1);
								check = true;
							}
						}
						if (i - 1 >= 0 && j + 1 < board.getSize()) {
							if (!board.isFlagged(i - 1, j + 1) && !board.isUncovered(i - 1, j + 1)) {
								reveal(i - 1, j + 1);
								check = true;
							}
						}
						if (i + 1 < board.getSize() && j - 1 >= 0) {
							if (!board.isFlagged(i + 1, j - 1) && !board.isUncovered(i + 1, j - 1)) {
								reveal(i + 1, j - 1);
								check = true;
							}
						}
						if (i + 1 < board.getSize() && j + 1 < board.getSize()) {
							if (!board.isFlagged(i + 1, j + 1) && !board.isUncovered(i + 1, j + 1)) {
								reveal(i + 1, j + 1);
								check = true;
							}
						}
						if (check) {
							revealSafeCells();
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	Position getNextReveal() {
		// calculates the probability for each cell having a nettle
		// and returns the position of the cell with minimum probability
		double[][] probabilities = new double[board.getSize()][board.getSize()];
		double min = Double.MAX_VALUE;
		for (int i = 0; i < board.getSize(); ++i) {
			for (int j = 0; j < board.getSize(); ++j) {
				if (board.isUncovered(i, j) && board.uncover(i, j) != 0) {
					int c = 0;
					int fc = 0;
					if (i - 1 >= 0) {
						if (!board.isUncovered(i - 1, j)) {
							if (board.isFlagged(i - 1, j)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					if (i + 1 < board.getSize()) {
						if (!board.isUncovered(i + 1, j)) {
							if (board.isFlagged(i + 1, j)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					if (j - 1 >= 0) {
						if (!board.isUncovered(i, j - 1)) {
							if (board.isFlagged(i, j - 1)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					if (j + 1 < board.getSize()) {
						if (!board.isUncovered(i, j + 1)) {
							if (board.isFlagged(i, j + 1)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					if (i - 1 >= 0 && j - 1 >= 0) {
						if (!board.isUncovered(i - 1, j - 1)) {
							if (board.isFlagged(i - 1, j - 1)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					if (i - 1 >= 0 && j + 1 < board.getSize()) {
						if (!board.isUncovered(i - 1, j + 1)) {
							if (board.isFlagged(i - 1, j + 1)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					if (i + 1 < board.getSize() && j - 1 >= 0) {
						if (!board.isUncovered(i + 1, j - 1)) {
							if (board.isFlagged(i + 1, j - 1)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					if (i + 1 < board.getSize() && j + 1 < board.getSize()) {
						if (!board.isUncovered(i + 1, j + 1)) {
							if (board.isFlagged(i + 1, j + 1)) {
								++fc;
							} else {
								++c;
							}
						}
					}
					double probability = c == 0 ? 0.0 : ((board.uncover(i, j) - fc) * 1.0) / (c * 1.0);
					if (i - 1 >= 0) {
						if (!board.isFlagged(i - 1, j) && !board.isUncovered(i - 1, j)) {
							probabilities[i - 1][j] += probability;
						}
					}
					if (i + 1 < board.getSize()) {
						if (!board.isFlagged(i + 1, j) && !board.isUncovered(i + 1, j)) {
							probabilities[i + 1][j] += probability;
						}
					}
					if (j - 1 >= 0) {
						if (!board.isFlagged(i, j - 1) && !board.isUncovered(i, j - 1)) {
							probabilities[i][j - 1] += probability;
						}
					}
					if (j + 1 < board.getSize()) {
						if (!board.isFlagged(i, j + 1) && !board.isUncovered(i, j + 1)) {
							probabilities[i][j + 1] += probability;
						}
					}
					if (i - 1 >= 0 && j - 1 >= 0) {
						if (!board.isFlagged(i - 1, j - 1) && !board.isUncovered(i - 1, j - 1)) {
							probabilities[i - 1][j - 1] += probability;
						}
					}
					if (i - 1 >= 0 && j + 1 < board.getSize()) {
						if (!board.isFlagged(i - 1, j + 1) && !board.isUncovered(i - 1, j + 1)) {
							probabilities[i - 1][j + 1] += probability;
						}
					}
					if (i + 1 < board.getSize() && j - 1 >= 0) {
						if (!board.isFlagged(i + 1, j - 1) && !board.isUncovered(i + 1, j - 1)) {
							probabilities[i + 1][j - 1] += probability;
						}
					}
					if (i + 1 < board.getSize() && j + 1 < board.getSize()) {
						if (!board.isFlagged(i + 1, j + 1) && !board.isUncovered(i + 1, j + 1)) {
							probabilities[i + 1][j + 1] += probability;
						}
					}
				}
			}
		}

		for (int i = 0; i < probabilities.length; ++i) {
			for (int j = 0; j < probabilities.length; ++j) {
				if (probabilities[i][j] > 0.0) {
					min = Math.min(min, probabilities[i][j]);
				}
			}
		}
		ArrayList<Position> probablePositions = new ArrayList<Position>();
		for (int i = 0; i < probabilities.length; ++i) {
			for (int j = 0; j < probabilities.length; ++j) {
				if (probabilities[i][j] == min && !board.isFlagged(i, j) && !board.isUncovered(i, j)) {
					probablePositions.add(new Position(i, j));
				}
			}
		}
		if (probablePositions.size() == 0) {
			for (int i = 0; i < probabilities.length; ++i) {
				for (int j = 0; j < probabilities.length; ++j) {
					if (!board.isFlagged(i, j) && !board.isUncovered(i, j)) {
						probablePositions.add(new Position(i, j));
					}
				}
			}
		}
		Position p = probablePositions.get((int) (Math.random() * probablePositions.size()));
		return p;
	}

	boolean flag() { // marks cells which definitely have nettles
		int oldFC = flagCount;
		for (int i = 0; i < board.getSize(); ++i) {
			for (int j = 0; j < board.getSize(); ++j) {
				if (board.isUncovered(i, j) && board.uncover(i, j) != 0) {
					int c = 0;
					if (i - 1 >= 0) {
						if (!board.isUncovered(i - 1, j)) ++c;
					}
					if (i + 1 < board.getSize()) {
						if (!board.isUncovered(i + 1, j)) ++c;
					}
					if (j - 1 >= 0) {
						if (!board.isUncovered(i, j - 1)) ++c;
					}
					if (j + 1 < board.getSize()) {
						if (!board.isUncovered(i, j + 1)) ++c;
					}
					if (i - 1 >= 0 && j - 1 >= 0) {
						if (!board.isUncovered(i - 1, j - 1)) ++c;
					}
					if (i - 1 >= 0 && j + 1 < board.getSize()) {
						if (!board.isUncovered(i - 1, j + 1)) ++c;
					}
					if (i + 1 < board.getSize() && j - 1 >= 0) {
						if (!board.isUncovered(i + 1, j - 1)) ++c;
					}
					if (i + 1 < board.getSize() && j + 1 < board.getSize()) {
						if (!board.isUncovered(i + 1, j + 1)) ++c;
					}
					if (c <= board.uncover(i, j)) {
						if (i - 1 >= 0) {
							if (!board.isFlagged(i - 1, j) && !board.isUncovered(i - 1, j)) {
								board.flag(i - 1, j);
								System.out.println("mark " + (i - 1) + " " + (j));
								++flagCount;
							}
						}
						if (i + 1 < board.getSize()) {
							if (!board.isFlagged(i + 1, j) && !board.isUncovered(i + 1, j)) {
								board.flag(i + 1, j);
								System.out.println("mark " + (i + 1) + " " + (j));
								++flagCount;
							}
						}
						if (j - 1 >= 0) {
							if (!board.isFlagged(i, j - 1) && !board.isUncovered(i, j - 1)) {
								board.flag(i, j - 1);
								System.out.println("mark " + (i) + " " + (j - 1));
								++flagCount;
							}
						}
						if (j + 1 < board.getSize()) {
							if (!board.isFlagged(i, j + 1) && !board.isUncovered(i, j + 1)) {
								board.flag(i, j + 1);
								System.out.println("mark " + (i) + " " + (j + 1));
								++flagCount;
							}
						}
						if (i - 1 >= 0 && j - 1 >= 0) {
							if (!board.isFlagged(i - 1, j - 1) && !board.isUncovered(i - 1, j - 1)) {
								board.flag(i - 1, j - 1);
								System.out.println("mark " + (i - 1) + " " + (j - 1));
								++flagCount;
							}
						}
						if (i - 1 >= 0 && j + 1 < board.getSize()) {
							if (!board.isFlagged(i - 1, j + 1) && !board.isUncovered(i - 1, j + 1)) {
								board.flag(i - 1, j + 1);
								System.out.println("mark " + (i - 1) + " " + (j + 1));
								++flagCount;
							}
						}
						if (i + 1 < board.getSize() && j - 1 >= 0) {
							if (!board.isFlagged(i + 1, j - 1) && !board.isUncovered(i + 1, j - 1)) {
								board.flag(i + 1, j - 1);
								System.out.println("mark " + (i + 1) + " " + (j - 1));
								++flagCount;
							}
						}
						if (i + 1 < board.getSize() && j + 1 < board.getSize()) {
							if (!board.isFlagged(i + 1, j + 1) && !board.isUncovered(i + 1, j + 1)) {
								board.flag(i + 1, j + 1);
								System.out.println("mark " + (i + 1) + " " + (j + 1));
								++flagCount;
							}
						}
					}
				}
			}
		}
		return flagCount > oldFC;
	}

	boolean reveal(int x, int y) {
		if (board.isUncovered(x, y)) return true; // already revealed

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
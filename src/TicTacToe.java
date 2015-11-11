public class TicTacToe {
	public static int SIZE = 3;
	private char[][] grid;
	private char turn;

	public enum Status {
		ILLEGAL(0), ONGOING(1), TIE(2), X_WON(3), O_WON(4);
		private int value;

		private Status(int value) {
			this.value = value;
		}
	};

	public TicTacToe() {
		grid = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = '_';
			}
		}
		turn = 'x';
	}

	public void toggleTurn() {
		if (turn == 'x')
			turn = 'o';
		else
			turn = 'x';
	}

	public char getTurn() {
		return turn;
	}

	private boolean canPlay(Move m) {
		int row = m.getRow();
		int col = m.getCol();
		if ((row < 0) || (row >= SIZE) || (col < 0) || (col >= SIZE))
			return false;
		if (grid[row][col] != '_')
			return false;
		return true;
	}

	public int play(Move m) {
		if (!canPlay(m)) {
			displayStatus(Status.ILLEGAL.value);
			return Status.ILLEGAL.value;
		}

		int row = m.getRow();
		int col = m.getCol();

		grid[row][col] = turn;
		if (checkRow(row) || checkCol(col) || checkFirstDiag() || checkSecondDiag()) {
			if (turn == 'x') {
				displayStatus(Status.X_WON.value);
				return Status.X_WON.value;
			} else {
				displayStatus(Status.O_WON.value);
				return Status.O_WON.value;
			}
		}
		// TODO check for ties
		displayStatus(Status.ONGOING.value);
		return Status.ONGOING.value;
	}

	private void displayStatus(int s) {
		if (s == Status.X_WON.value) {
			System.out.println("X won!");
		} else if (s == Status.O_WON.value) {
			System.out.println("O won!");
		} else if (s == Status.TIE.value) {
			System.out.println("It's a tie!");
		} else if (s == Status.ILLEGAL.value) {
			System.out.println("Illegal move!");
		}

	}

	private boolean checkRow(int i) {
		for (int j = 0; j < SIZE; j++) {
			if (grid[i][j] != turn)
				return false;
		}
		return true;
	}

	private boolean checkCol(int i) {
		for (int j = 0; j < SIZE; j++) {
			if (grid[j][i] != turn)
				return false;
		}
		return true;
	}

	private boolean checkFirstDiag() {
		for (int i = 0; i < SIZE; i++) {
			if (grid[i][i] != turn)
				return false;
		}
		return true;
	}

	private boolean checkSecondDiag() {
		for (int i = 0; i < SIZE; i++) {
			if (grid[i][SIZE - i - 1] != turn)
				return false;
		}
		return true;
	}
}
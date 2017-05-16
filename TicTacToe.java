public class TicTacToe implements Board {

	private PlayingPiece[][] board;

	public TicTacToe() {
		board = new PlayingPiece[3][3];
	}

	@Override
	public void endTurn() {

	}

	@Override
	public PlayingPiece interact(int[] coordinates) {
		boolean X = true;
		if (X) {
			board[coordinates[0]][coordinates[1]] = new Mark(new int[] { coordinates[0], coordinates[1] }, "X");
			X = false;
		}

		else {
			board[coordinates[0]][coordinates[1]] = new Mark(new int[] { coordinates[0], coordinates[1] }, "O");
			X = true;
		}

		return board[coordinates[0]][coordinates[1]];
	}

	public boolean isFieldEmpty(int[] coordinates) {
		return board[coordinates[0]][coordinates[1]] == null;
	}
}


public class TicTacToe implements Board {

	private PlayingPiece[][] board;
	private boolean X;
	
	public TicTacToe() {
		board = new PlayingPiece[3][3];
		X = true;
	}

	@Override
	public void endTurn() {

	}

	@Override
	public PlayingPiece interact(int[] coordinates) {
		
		if (X) {
			board[coordinates[0]][coordinates[1]] = new Mark(new int[] { coordinates[0], coordinates[1] }, "X");
			System.out.println(coordinates[0] + "test" + coordinates[1]);
			X = false;
		}
		else {
			board[coordinates[0]][coordinates[1]] = new Mark(new int[] { coordinates[0], coordinates[1] }, "O");
			System.out.println(coordinates[0] + "test" + coordinates[1]);
			X = true;
		}

		return board[coordinates[0]][coordinates[1]];
	}

	public boolean isFieldEmpty(int[] coordinates) {
		return board[coordinates[0]][coordinates[1]] == null;
	}
}


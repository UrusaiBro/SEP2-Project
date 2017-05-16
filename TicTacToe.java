public class TicTacToe implements Boards{

	private PlayingPiece[][] board;
	
	public TicTacToe()
	{
		board = new PlayingPiece[3][3];
	}
	
	@Override
	public void endTurn() 
	{
		
	}

	@Override
	public PlayingPiece interact(int x, int y) {
		boolean X = true;
		if(X)
			board[x][y] = new Mark(new int[]{x,y},"X");
		else
			board[x][y] = new Mark(new int[]{x,y},"O");
		
		return board[x][y];
	}

	public boolean isFieldEmpty(int x, int y)
	{
		return board[x][y] == null;
	}
}

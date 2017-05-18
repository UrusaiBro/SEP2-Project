
public class ModelManager implements Model 
{
	private Board board;
	
	public ModelManager()
	{
		board = new TicTacToe();
	}
	
	public void createGame()
	{
		board = new TicTacToe();
	}
	
	public PlayingPiece interact(int[] coordinates)
	{
		
		return board.interact(coordinates);
	}

}

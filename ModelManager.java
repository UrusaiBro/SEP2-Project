
public class ModelManager implements Model {
	private Board board;
	
	public ModelManager(Board board){
		this.board=board;
	}
	
	public PlayingPiece interact(int[] coordinates){
		return board.interact(coordinates);
	}
	

}

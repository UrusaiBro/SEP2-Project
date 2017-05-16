
public class Mark implements PlayingPiece{
	
	private int[] coordinates;
	private String type;
	public Mark(int[] coordinates, String type){
		this.coordinates=coordinates;
		this.type=type;
	}
	
	@Override
	public int[] getCoordinates(){
		return coordinates;
	}
	
	@Override
	public String getType(){
		return type;
	}
	
	
	
		
}

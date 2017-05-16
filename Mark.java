
public class Mark implements PlayingPiece{
	
	private int[] coordinates;
	private String type;
	public Mark(int[] coordinates, String type){
		this.coordinates=coordinates;
		this.type=type;
	}
	
	public int[] getCoordinates(){
		return coordinates;
	}
	public String getType(){
		return type;
	}
	
	
	
		
}

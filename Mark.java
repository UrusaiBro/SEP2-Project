
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
	
	public void setCoordinates(int[] coordinates){
		this.coordinates=coordinates;
	}
	public void setType(String type){
		this.type=type;
	}
	
		
}

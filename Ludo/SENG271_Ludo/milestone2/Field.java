package milestone2;

public class Field {
	private Pawn occupant;
	private Field next;
	private int boardIndex;
	
	public Field(int i){
		boardIndex=i;
	}
	public int getBoardIndex(){
		return boardIndex;
	}
	
	public boolean hasOccupant(){
		if(occupant != null){
			return true;
		}else{
			return false;
		}
	}
	
	public Pawn getOccupant() {
		if(hasOccupant()){
			return occupant;
		}else{
			System.err.println("No occupant available");
			return null;
		}
	}
	
	public void setOccupant(Pawn newOccupant) {
		if(newOccupant == null){
			this.occupant=null;
		}else{
			if(this.hasOccupant()){
				this.occupant.kickToHome();
			}
			this.occupant = newOccupant;
			//Clear the pawns old location
			if(!newOccupant.isAtHome()){
				newOccupant.getLocation().setOccupant(null);
			}
			newOccupant.movePawn(this);
		}
	}

	public void setNext(Field next) {
		this.next = next;	
	}

	public Field getNext() {
		return this.next;	
	}
}

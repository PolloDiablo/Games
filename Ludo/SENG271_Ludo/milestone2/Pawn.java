package milestone2;

public class Pawn {
	private final Player owner;
	
	/**A number between 1-4, used to label the pawn*/
	private final int ID;
	Field location;
	private int distanceTravelled;
	private boolean atHome;
	
	public Pawn(Player owner, int ID){
		this.owner=owner;
		this.ID=ID;
		atHome=true;
		setDistanceTravelled(0);
	}
	
	public Player getOwner(){
		return owner;
	}
	public int getID(){
		return ID;
	}
	
	/**
	 * Moves the pawn to the given location.
	 * NOTE: We DO NOT keep referential integrity here (setting the occupant of the Field).
	 * 	This is because when we calculate the available moves to a player, we move fake "temporary pawns" around.
	 * 	The Field does not need to know about these.
	 * @param location
	 */
	public void movePawn(Field location) {
		this.atHome=false;
		this.location=location;
	}
	
	/**
	 * @param eyes
	 * @return null if this move is NOT valid. The target location if this move IS valid.
	 */
	public Field checkMoveValidity(int eyes){
		Pawn temporaryPawn=new Pawn(null,8);
    	temporaryPawn.movePawn(location);
        //Move exact number of eyes
        for(int i=0;i<eyes;i++){
        	temporaryPawn.movePawn(temporaryPawn.getLocation().getNext());
            	//If you went past the end of the goal field, then this move is not valid
            	if(temporaryPawn.getLocation()==null){
            			return null;
            	}
            	//If the targetLocation is the entry of the player, they must turn into the goal area instead
            	if (temporaryPawn.getLocation()==owner.getEntry()){
            		temporaryPawn.movePawn(owner.getFirstGoal());
            	}
		    //Cannot skip over or land on a pawn in the goal field
		    if(temporaryPawn.getLocation()instanceof Goal && temporaryPawn.getLocation().hasOccupant()){
		        return null;
		    }

        }
        //Now that we have the final targetLocation:
        if(temporaryPawn.getLocation().hasOccupant()){
        	//Cannot land on your own pawn;
        	if(temporaryPawn.getLocation().getOccupant().getOwner().equals(owner)){
        		return null;
		    }
        }
        //Final case, the move will be valid
        return temporaryPawn.getLocation();
	}
	
	
	public Field getLocation() {
		return location;
	}

	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
	
	/**
	 * Returns this pawn to home.
	 */
	public void kickToHome() {
		movePawn(null);
		setDistanceTravelled(0);
		atHome=true;
	}
	public boolean isAtHome(){
		return atHome;
	}
}

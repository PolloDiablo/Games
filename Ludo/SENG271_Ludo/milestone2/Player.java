package milestone2;

public class Player {
	private String myName;
	private int myPlayerNumber;
	private Pawn[] myPawns;
	private Entry myEntry;
	private Goal[] myGoals;
	private Strategy myStrategy;
	private Die myDie;
	
	
	public Player(String name, int playerNumber, Strategy strategy, Field entry){
		myName=name;
		myPlayerNumber=playerNumber;
		myStrategy=strategy;
		myEntry=(Entry) entry;
		myEntry.setOwner(this);
		myPawns = new Pawn[4];
		for (int i=0;i<4;i++){
			myPawns[i] = new Pawn(this,i+1);
		}
		myGoals = new Goal[4];
		setupGoals();
		myDie = new Die();
	}
	
	private void setupGoals(){
		for(int i=0;i<4;i++){
			myGoals[i]=new Goal(i);
			myGoals[i].setOwner(this);
		}
		myGoals[0].setNext(myGoals[1]);
		myGoals[1].setNext(myGoals[2]);
		myGoals[2].setNext(myGoals[3]);
		myGoals[3].setNext(null);
	}
	
	public Field getEntry() {
		return myEntry;
	}

	/**
	 * Roll the die and make a move (if one is available).
	 * @return true if the game was won during this turn. Else return false.
	 */
	public boolean runPlay(){
		int dieRoll = myDie.throwDie();
		if(dieRoll==6){
			//If we roll a six, attempt to bring a pawn out of home
		    if(!attemptEntry()){
		    	//If we cannot bring a pawn from home, use the 6 as a roll
		    	attemptMove(dieRoll); 
		    }
		    Board.displayGameBoard();
		    //If you roll a six you get another turn
		    this.runPlay();
		}else{
			//If we do not roll a six, then choose a move
			attemptMove(dieRoll);
		}	
		
		return testWin();
	}
		
	/**
	 * Assuming a 6 was just rolled. Attempts to move a pawn from Home onto the board.
	 * @return True this move was possible. False if no pawn was moved.
	 */
	private boolean attemptEntry() {
		Pawn pawnToEnter=null;
		
		//Check if we have any pawns left at home
		for(Pawn p : myPawns){
			if(p.isAtHome()){
				pawnToEnter =p;
				break;
			}
		}
		//No pawns left at home
		if(pawnToEnter == null){
			return false;
		}	
		
		//Check that our entry is not occupied by one of our own pawns.
		if(myEntry.hasOccupant() && myEntry.getOccupant().getOwner()==this){
			return false;
		}	
		//Move the pawn out of home
		myEntry.setOccupant(pawnToEnter);
		return true;			
	}
	
	/**
	 * Chooses a move and makes the move (if there is a valid move available).
	 * @param dieRoll
	 */
	private void attemptMove(int dieRoll){
        Pawn pawnToMove = myStrategy.makeDecision(this,dieRoll);
        if(pawnToMove!=null){
        	Field targetLocation = pawnToMove.checkMoveValidity(dieRoll);
        	targetLocation.setOccupant(pawnToMove);
        	pawnToMove.setDistanceTravelled(pawnToMove.getDistanceTravelled()+dieRoll);
        }else{
        	//Do nothing (i.e. Pass) if no pawn can be moved
        }
	}
	

	/**
	 * @return true if all of the Goals are occupied by pawns. Else returns false.
	 */
	private boolean testWin(){
		for(Goal g : myGoals){
			if(!g.hasOccupant()){
				return false;
			}
		}
		return true;
	}

	public Pawn[] getMyPawns() {
		return myPawns;
	}

	public String getName() {
		return myName;
	}

	public Field getFirstGoal() {
		return myGoals[0];
	}

	public int getPlayerNumber() {
		return myPlayerNumber;
	}

}

package milestone2;

import java.util.ArrayList;

public abstract class Strategy {
	
	int[] weights;
	
	/**
	 * @param player
	 * @param dieRoll
	 * @return Which one of the pawns the player wants to move.
	 */
	public Pawn makeDecision(Player player, int dieRoll){
		ArrayList <Pawn> moveablePawns = new ArrayList<Pawn>();
		ArrayList <Field> pawnDestinations = new ArrayList<Field>();
		//For each pawn, if it is not at home, see if we can move it the the distance specified by the die roll.
		//	If so, add its destination to the list of possible moves
		for(Pawn p : player.getMyPawns()){
			if(!p.isAtHome()){
				Field possibleDestination=p.checkMoveValidity(dieRoll);  	
		    	//If this pawn cane make a valid move, add it to our possibilities
		    	if(possibleDestination!=null){
		    		moveablePawns.add(p);
		    		pawnDestinations.add(possibleDestination);
		    	}	
			}
		}
		
		//If no valid moves are available, return null
		if(moveablePawns.isEmpty()){
			return null;
		}else{
			//Weight moves based on strategy, return pawn/move with the highest weighting
			weights=new int[moveablePawns.size()];
			for(int i : weights){
				weights[i]=0;
			}
			weightMoves(player,moveablePawns,pawnDestinations);
			return moveablePawns.get(getHighestWeightIndex());
		}
		
	}
	
	/**
	 * Applies weightings to each of the available moves based on the player's strategy.
	 * In the case of a Human player, we ask them to choose a move.
	 * @param player
	 * @param moveablePawns
	 * @param pawnDestinations
	 */
	protected abstract void weightMoves(Player player,ArrayList<Pawn> moveablePawns,ArrayList<Field> pawnDestinations);

	/**
	 * Adds values to the current weights array
	 * @param newWeights An array of 1's and 0's
	 * @param weighting How highly each '1' is weighted (based on the concrete strategy)
	 */
	protected void addWeights(int[] newWeights, int weighting){
		for(int i=0;i<newWeights.length;i++){
			weights[i] += weighting*newWeights[i];
		}
	}
	
	/**
	 * @return The index of the highest weighted move
	 */
	private int getHighestWeightIndex(){	
		int max=weights[0];
		int maxIndex=0;
		for(int i=1;i<weights.length;i++){
			if(weights[i]>max){
				max=weights[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	
	/**
	 * Do we land on an opponent's piece?
	 * @param pawnDestinations
	 * @return An array of 1's and 0's corresponding to each possible move: meaning true and false respectively
	 */
	protected int[] checkAggressiveMove(ArrayList<Field> pawnDestinations, Player player){
		int[] weightings = new int[pawnDestinations.size()];
		
		for(int i=0;i<pawnDestinations.size();i++){
			if(pawnDestinations.get(i).hasOccupant() && pawnDestinations.get(i).getOccupant().getOwner() != player){
				weightings[i]=1;
			}else{
				weightings[i]=0;
			}
		}	
		return weightings;
	}

	/**
	 * Do we land on a goal field?
	 * @param pawnDestinations
	 * @return An array of 1's and 0's corresponding to each possible move: meaning true and false respectively
	 */
	public int[] checkDefensiveMove(ArrayList<Field> pawnDestinations) {
		int[] weightings = new int[pawnDestinations.size()];
		
		for(int i=0;i<pawnDestinations.size();i++){
			if(pawnDestinations.get(i) instanceof Goal){
				weightings[i]=1;
			}else{
				weightings[i]=0;
			}
		}	
		return weightings;
	}

	/**
	 * Cautious, do we NOT land on an opponent's piece?
	 * @param pawnDestinations
	 * @return An array of 1's and 0's corresponding to each possible move: meaning true and false respectively
	 */
	public int[] checkCautiousMove(ArrayList<Field> pawnDestinations, Player player) {
		int[] weightings = new int[pawnDestinations.size()];
		
		for(int i=0;i<pawnDestinations.size();i++){
			if(pawnDestinations.get(i).hasOccupant() && pawnDestinations.get(i).getOccupant().getOwner() != player){
				weightings[i]=0;
			}else{
				weightings[i]=1;
			}
		}	
		return weightings;
	}

	/**
	 * Move-first, are we moving the foremost pawn?
	 * @param pawnDestinations
	 * @return An array of 1's and 0's corresponding to each possible move: meaning true and false respectively
	 */
	public int[] checkForeMostMove(ArrayList<Pawn> moveablePawns) {
		int[] weightings = new int[moveablePawns.size()];
		
		int furthestDistance=moveablePawns.get(0).getDistanceTravelled();
		int indexOfFurthest=0;
		
		for(int i=0;i<moveablePawns.size();i++){
			if(moveablePawns.get(i).getDistanceTravelled()>furthestDistance){
				furthestDistance=moveablePawns.get(i).getDistanceTravelled();
				indexOfFurthest=i;
			}
		}	
		
		for(int i=0;i<weightings.length;i++){
			if(i==indexOfFurthest){
				weightings[i]=1;
			}else{
				weightings[i]=0;
			}
		}
		
		return weightings;
	}

	/**
	 * Are we moving the hindmost pawn?
	 * @param pawnDestinations
	 * @return An array of 1's and 0's corresponding to each possible move: meaning true and false respectively
	 */
	public int[] checkHindMostMove(ArrayList<Pawn> moveablePawns) {
		int[] weightings = new int[moveablePawns.size()];
		
		int hindMostDistance=moveablePawns.get(0).getDistanceTravelled();
		int indexOfHindMost=0;
		
		for(int i=0;i<moveablePawns.size();i++){
			if(moveablePawns.get(i).getDistanceTravelled()<hindMostDistance){
				hindMostDistance=moveablePawns.get(i).getDistanceTravelled();
				indexOfHindMost=i;
			}
		}	
		
		for(int i=0;i<weightings.length;i++){
			if(i==indexOfHindMost){
				weightings[i]=1;
			}else{
				weightings[i]=0;
			}
		}
		
		return weightings;
	}
	
}

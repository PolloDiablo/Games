package milestone2;

import java.util.ArrayList;

public class DefensiveStrategy extends Strategy{

	@Override
	protected void weightMoves(Player player, ArrayList<Pawn> moveablePawns,
			ArrayList<Field> pawnDestinations) {

		addWeights(checkDefensiveMove(pawnDestinations),10);
		addWeights(checkForeMostMove(moveablePawns),1);	
	}

}

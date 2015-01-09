package milestone2;

import java.util.ArrayList;

public class AggressiveMoveFirstStrategy extends Strategy {

	@Override
	protected void weightMoves(Player player, ArrayList<Pawn> moveablePawns,
			ArrayList<Field> pawnDestinations) {

		addWeights(checkAggressiveMove(pawnDestinations,player),10);
		addWeights(checkForeMostMove(moveablePawns),1);	
	}

}

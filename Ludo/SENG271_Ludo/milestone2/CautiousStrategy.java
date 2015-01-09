package milestone2;

import java.util.ArrayList;

public class CautiousStrategy extends Strategy{

	@Override
	protected void weightMoves(Player player, ArrayList<Pawn> moveablePawns,
			ArrayList<Field> pawnDestinations) {

		addWeights(checkCautiousMove(pawnDestinations,player),10);
		addWeights(checkForeMostMove(moveablePawns),1);	
	}

}

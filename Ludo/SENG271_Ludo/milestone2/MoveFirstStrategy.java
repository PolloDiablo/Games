package milestone2;

import java.util.ArrayList;

public class MoveFirstStrategy extends Strategy{

	@Override
	protected void weightMoves(Player player, ArrayList<Pawn> moveablePawns,
			ArrayList<Field> pawnDestinations) {

		addWeights(checkForeMostMove(moveablePawns),10);
	}

}

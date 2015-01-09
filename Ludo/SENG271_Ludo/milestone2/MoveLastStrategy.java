package milestone2;

import java.util.ArrayList;

public class MoveLastStrategy extends Strategy{

	@Override
	protected void weightMoves(Player player, ArrayList<Pawn> moveablePawns,
			ArrayList<Field> pawnDestinations) {

		addWeights(checkHindMostMove(moveablePawns),10);
	}

}

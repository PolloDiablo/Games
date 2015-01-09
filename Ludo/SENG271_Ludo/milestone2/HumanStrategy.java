package milestone2;

import java.util.ArrayList;

public class HumanStrategy extends Strategy {

	@Override
	protected void weightMoves(Player player, ArrayList<Pawn> moveablePawns,
			ArrayList<Field> pawnDestinations) {
		
		addWeights(Controller.getHumanMove(pawnDestinations,moveablePawns),1);
	}

}

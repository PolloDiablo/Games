package milestone2;


import java.awt.Color;
import java.util.ArrayList;

public class Controller {

	static GameJFrame gameFrame;
	static MenuJFrame menuFrame;
	
	/**
	 * True if there are no Human players in the game, in this case we run a simulation,
	 *  rather than starting up the gameFrame.
	 */
	private static boolean simulation;
	
	private static String[] playerNames;
	private static Strategy[] playerStrategies;
	
	public static void main(String args[]){

		menuFrame = new MenuJFrame();
		gameFrame = new GameJFrame();
		
		//Keep looping between the menu and the game, until the player exits
		while(true){
			//Display the menu
			menuFrame.setVisible(true);		
			//Wait for the user to press the "Start Game" button
			while(true){
				try {
					Thread.sleep(100);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				if(menuFrame.getButtonPressed()){
					break;
				}			
			}	
			

			//Get the player's menu choices
			int numberOfPlayers=menuFrame.getNumberOfPlayers();
			playerNames= menuFrame.getPlayerNames(numberOfPlayers);
			playerStrategies=menuFrame.getPlayerStrategies(numberOfPlayers);
			
			simulation=true;
			//If there are any human players, then we are not running a simulation
			for(Strategy s : playerStrategies){
				if(s instanceof HumanStrategy){
					simulation=false;
				}
			}
			
			
			if(!simulation){
				menuFrame.setVisible(false);
				//If this is not a simulation, just run the game once
				playGame();		
				//The game is now finished, wait for the player to return to the menu from the game
				while(true){
					try {
						Thread.sleep(100);
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					if(gameFrame.getButtonPressed()){
						break;
					}			
				}	
				//Hide the gameFrame as the user has returns to the menu
				gameFrame.getButton().setVisible(false);
				gameFrame.setVisible(false);
				
			}else{
				//If this is a simulation run the game many times
				int[] playerScores = new int[numberOfPlayers];
				String winner;
				Board gameBoard= new Board();
				for(int i=0;i<10000;i++){	
					winner = gameBoard.playGame(playerNames,playerStrategies);
					//Update player scores
					for(int z=0;z<numberOfPlayers;z++){
						if(winner.equals(playerNames[z])){
							playerScores[z]++;
							break;
						}
					}
				}
				SimulationPanel simulationPanel= new SimulationPanel();
				simulationPanel.displayScores(playerNames, playerScores,menuFrame.getStrategyStrings(numberOfPlayers));
				simulationPanel.setAlwaysOnTop(true);
				simulationPanel.setVisible(true);
			}
		}
		
	}

	/**
	 * Call this function to begin a game with human players.
	 */
	public static void playGame(){

		Board gameBoard= new Board();
		
		gameFrame.getBoardPanel().setPlayerNames(playerNames);
		gameFrame.setVisible(true);	

		//Start the game
		String winnerName = gameBoard.playGame(playerNames,playerStrategies);
		//Display winner of the game
		gameFrame.getTitlePanel().setText(winnerName + " Has Won!");
		gameFrame.getButton().setVisible(true);
	}
	
	
	
	/**
	 * @param roll [1-6] The eyes rolled by the die
	 */
	public static void displayRoll(int roll){		
		//Don't draw anything if we are running a simulation
		if(!simulation){
			gameFrame.getDicePanel().paintEyes(roll);
			try {
			    Thread.sleep(500);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}
	
	/**
	 * Set the title-text to show the current player's name. Also change the colour of the die to match the player.
	 * @param player The player who's turn it currently is.
	 */
	public static void displayCurrentPlayerName(Player player){
		//Don't draw anything if we are running a simulation
		if(!simulation){
			//Display current player's name in the top corner
			gameFrame.getTitlePanel().setText(player.getName()+"'s Turn");
			//Set the colour of the die based on the current player
			switch(player.getPlayerNumber()){
				case 0: gameFrame.getDiceBackgroundPanel().setBackground(Color.blue); break;
				case 1: gameFrame.getDiceBackgroundPanel().setBackground(Color.yellow); break;
				case 2: gameFrame.getDiceBackgroundPanel().setBackground(Color.green); break;
				case 3: gameFrame.getDiceBackgroundPanel().setBackground(Color.red); break;
			}
		}
	}
	
	/**
	 * Refreshes the board and draws in all of the pawns
	 * @param players
	 */
	public static void displayCurrentGameBoard(Player[] players){
		//Don't draw anything if we are running a simulation
		if(!simulation){
			gameFrame.getBoardPanel().paintBoard();
			for(Player p : players){
				int atHomeCounter=0;
				for(Pawn pawn : p.getMyPawns()){
					if(pawn.isAtHome()){
						gameFrame.getBoardPanel().paintPawnAtHome(p.getPlayerNumber(),atHomeCounter++,pawn.getID());
					}else if(pawn.getLocation() instanceof Goal){
						gameFrame.getBoardPanel().paintPawnOnGoal(p.getPlayerNumber(),pawn.getLocation().getBoardIndex(),pawn.getID());
					}else{
						gameFrame.getBoardPanel().paintPawnOnBoard(p.getPlayerNumber(),pawn.getLocation().getBoardIndex(),pawn.getID());
					}
				}
			}
		}
	}
	
	/**
	 * Display the list of available moves to the player.
	 * @param moveablePawns
	 * @return The index of the move which the player chooses.
	 */
	private static int displayAvailableMoves(ArrayList<Pawn> moveablePawns){
		for(Pawn pawn : moveablePawns){
			GameJFrame.drawBoardDestination(pawn.getID());
		}	
		return GameJFrame.getMoveChoice();
	}
	
	/**
	 * Called by HumanStrategy. Displays available moves and returns a weighting array representing the user's choice.
	 * @param pawnDestinations
	 * @param moveablePawns
	 * @return
	 */
	public static int[] getHumanMove(ArrayList<Field> pawnDestinations, ArrayList<Pawn> moveablePawns) {
		int[] weightings = new int[pawnDestinations.size()];
		int indexOfChoice=0;	
		
		indexOfChoice = displayAvailableMoves(moveablePawns);
		
		for(int i=0;i<weightings.length;i++){
			if(i==indexOfChoice){
				weightings[i]=1;
			}else{
				weightings[i]=0;
			}
		}	
		return weightings;
	}
}

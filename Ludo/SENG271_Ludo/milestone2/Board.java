package milestone2;

public class Board {
	
    /**
     * The 40 fields that make up the board.
     * This does not include goals which are associated with each player individually.
     */
    Field[] gameBoard;
    
    /**
     * The 2-4 players that are currently playing the game.
     */
    static Player[] players;
    
    public Board(){ 	
        //Construct the board
        gameBoard= new Field[40];
        //Every tenth field is an Entry, all the others are just regular Fields
        for(int i=0;i<40;i++){
        	if(i==0 || i==10 || i==20 || i==30){
            	gameBoard[i]=new Entry(i);
            }else{
            	gameBoard[i] = new Field(i);
            }
        }     
        //Setup the gameBoard links
        for(int i=0;i<39;i++){
            gameBoard[i].setNext(gameBoard[i+1]);
        }
        gameBoard[39].setNext(gameBoard[0]);
    }

    /**
     * @param playerNames: an array of 2-4 player names
     * @param playerStrategies an array of 2-4 player strategies (which correspond to the player names)
     * @return the name of the winner of the game
     */
    public String playGame(String[] playerNames, Strategy[] playerStrategies){
        //Check for an invalid number of players
    	if(playerNames.length >4 || playerNames.length<2){
            System.err.println("Invalid number of players");
            return "";
        }
    	
    	
    	//Assign each player their location and pieces:
        players = new Player[playerNames.length];
		if(players.length==2){
		    //If there are two players, make them diagonal to each other
			players[0] = new Player(playerNames[0],0, playerStrategies[0], gameBoard[0]);
			players[1] = new Player(playerNames[1],2, playerStrategies[1], gameBoard[20]);
		}else{
			//If there are 3 or 4 players, go around the board assigning them places.
			for(int index=0;index<players.length;index++){
				players[index] = new Player(playerNames[index],index, playerStrategies[index], gameBoard[index*10]);
			}
		}
		
		//Play the game
		boolean winner=false;	
		String winnerName="";	
		//Keep looping until someone has won the game
	    while(!winner){
	    	for (int i=0;i<players.length;i++){
	    		//Display the name of the player who's turn it is
	    		Controller.displayCurrentPlayerName(players[i]);
	    		winner = players[i].runPlay();
	    		displayGameBoard();
	    		if(winner){
	    			winnerName=players[i].getName();
	    			break;
			    }
	    	}       
	    }   
		return winnerName;
    }
   
    
    /**
     * 
     * Tells the controller to update the visual board display based on current pawn location.
     */
    public static void displayGameBoard(){
    	Controller.displayCurrentGameBoard(players);
    }
   
    
}

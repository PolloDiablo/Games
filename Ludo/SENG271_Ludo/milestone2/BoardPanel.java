package milestone2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class BoardPanel extends Panel{
	
	private String[] playerNames;
	
	public void setPlayerNames(String[] names){
		playerNames=names;
	}
	
	
	/**
	 * Default size of a field on the board
	 */
	private static final int circleSize=14;
	
	/**
	 * Default distance between fields on the board
	 */
	private static final int circleOffset=28;
	
	
	/**
	 * Provides a mapping between an integer which represents each field on the board,
	 *  and its corresponding x coordinate in the panel
	 */
	Map <Integer,Integer> xMapping;
	
	/**
	 * Provides a mapping between an integer which represents each field on the board,
	 *  and its corresponding y coordinate in the panel
	 */
	Map <Integer,Integer> yMapping;	
	
	//Same as above, but tese mappings are for the Goal fields and the Home fields
	Map <Integer,Integer> p1GoalxMap;
	Map <Integer,Integer> p1GoalyMap;
	Map <Integer,Integer> p1HomexMap;
	Map <Integer,Integer> p1HomeyMap;
	Map <Integer,Integer> p2GoalxMap;
	Map <Integer,Integer> p2GoalyMap;
	Map <Integer,Integer> p2HomexMap;
	Map <Integer,Integer> p2HomeyMap;
	Map <Integer,Integer> p3GoalxMap;
	Map <Integer,Integer> p3GoalyMap;
	Map <Integer,Integer> p3HomexMap;
	Map <Integer,Integer> p3HomeyMap;
	Map <Integer,Integer> p4GoalxMap;
	Map <Integer,Integer> p4GoalyMap;
	Map <Integer,Integer> p4HomexMap;
	Map <Integer,Integer> p4HomeyMap;
	
	
	@Override
	public void setBounds(int a,int b, int c, int d){
		super.setBounds(a,b,c,d);
		
		//Now that the bounds of the panel have been set,
		//	set all of the main board mappings:
		xMapping=new  HashMap<Integer,Integer>();
		yMapping=new  HashMap<Integer,Integer>();
		int i;
		for(i=0;i<5;i++){
			xMapping.put(i, getWidth()/2-circleSize/2-circleOffset*5+circleOffset*i);
			yMapping.put(i, getHeight()/2-circleSize/2-circleOffset);
		}
		for(i=5;i<9;i++){
			xMapping.put(i, getWidth()/2-circleSize/2-circleOffset);
			yMapping.put(i, getHeight()/2-circleSize/2+circleOffset*(3-i));
		}
		xMapping.put(9, getWidth()/2-circleSize/2);	
		yMapping.put(9, getHeight()/2-circleSize/2-circleOffset*5);
		for(i=10;i<15;i++){
			xMapping.put(i, getWidth()/2-circleSize/2+circleOffset);
			yMapping.put(i, getHeight()/2-circleSize/2+circleOffset*(-15+i));
		}
		for(i=15;i<19;i++){
			xMapping.put(i, getWidth()/2-circleSize/2+circleOffset*(i-13));
			yMapping.put(i, getHeight()/2-circleSize/2-circleOffset);
		}	
		xMapping.put(19, getWidth()/2-circleSize/2+circleOffset*5);
		yMapping.put(19, getHeight()/2-circleSize/2);		
		for(i=20;i<25;i++){
			xMapping.put(i, getWidth()/2-circleSize/2+circleOffset*5-circleOffset*(i-20));
			yMapping.put(i, getHeight()/2-circleSize/2+circleOffset);
		}
		for(i=25;i<29;i++){
			xMapping.put(i, getWidth()/2-circleSize/2+circleOffset);
			yMapping.put(i, getHeight()/2-circleSize/2+circleOffset*(i-23));
		}
		xMapping.put(29, getWidth()/2-circleSize/2);	
		yMapping.put(29, getHeight()/2-circleSize/2+circleOffset*5);
		for(i=30;i<35;i++){
			xMapping.put(i, getWidth()/2-circleSize/2-circleOffset);
			yMapping.put(i, getHeight()/2-circleSize/2+circleOffset*(35-i));
		}
		for(i=35;i<39;i++){
			xMapping.put(i, getWidth()/2-circleSize/2+circleOffset*(33-i));
			yMapping.put(i, getHeight()/2-circleSize/2+circleOffset);
		}	
		xMapping.put(39, getWidth()/2-circleSize/2-circleOffset*5);
		yMapping.put(39, getHeight()/2-circleSize/2);
		
		//Initialize the Goal and Home maps
		p1GoalxMap = new HashMap<Integer,Integer>();
		p1GoalyMap = new HashMap<Integer,Integer>();
		p1HomexMap = new HashMap<Integer,Integer>();
		p1HomeyMap = new HashMap<Integer,Integer>();
		p2GoalxMap = new HashMap<Integer,Integer>();
		p2GoalyMap = new HashMap<Integer,Integer>();
		p2HomexMap = new HashMap<Integer,Integer>();
		p2HomeyMap = new HashMap<Integer,Integer>();
		p3GoalxMap = new HashMap<Integer,Integer>();
		p3GoalyMap = new HashMap<Integer,Integer>();
		p3HomexMap = new HashMap<Integer,Integer>();
		p3HomeyMap = new HashMap<Integer,Integer>();
		p4GoalxMap = new HashMap<Integer,Integer>();
		p4GoalyMap = new HashMap<Integer,Integer>();
		p4HomexMap = new HashMap<Integer,Integer>();
		p4HomeyMap = new HashMap<Integer,Integer>();
		
		for(i=0;i<4;i++){
			//Set player 1 mappings
			p1GoalxMap.put(i,getWidth()/2-circleSize/2-circleOffset*4+circleOffset*i);
			p1GoalyMap.put(i,getHeight()/2-circleSize/2);
			p1HomexMap.put(i,getWidth()/2-180+circleOffset*i);
			p1HomeyMap.put(i,getHeight()/2-100);
			//Set player 2 mappings
			p2GoalxMap.put(i,getWidth()/2-circleSize/2);
			p2GoalyMap.put(i,getHeight()/2-circleSize/2-circleOffset*(4-i));
			p2HomexMap.put(i,getWidth()/2+220-circleOffset*(5-i));
			p2HomeyMap.put(i,getHeight()/2-100);
			//Set player 3 mappings
			p3GoalxMap.put(i,getWidth()/2-circleSize/2+circleOffset*4-circleOffset*i);
			p3GoalyMap.put(i,getHeight()/2-circleSize/2);
			p3HomexMap.put(i,getWidth()/2+220-circleOffset*(5-i));
			p3HomeyMap.put(i,getHeight()/2+100);
			//Set player 4 mappings
			p4GoalxMap.put(i,getWidth()/2-circleSize/2);
			p4GoalyMap.put(i,getHeight()/2-circleSize/2+circleOffset*(4-i));
			p4HomexMap.put(i,getWidth()/2-180+circleOffset*i);
			p4HomeyMap.put(i,getHeight()/2+100);
		}
		
	}
	
	
    /**
     * Re-paints the empty game board (none of the pawns)
     */
    public void paintBoard(){
		Graphics g=this.getGraphics();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		//Draw the paths around the board
		g.setColor(Color.black);
		g.drawLine(getWidth()/2-circleOffset*5, getHeight()/2-circleOffset,
				getWidth()/2-circleOffset, getHeight()/2-circleOffset);
		g.drawLine(getWidth()/2-circleOffset*5, getHeight()/2+circleOffset,
				getWidth()/2-circleOffset*5, getHeight()/2-circleOffset);
		g.drawLine(getWidth()/2-circleOffset*5, getHeight()/2+circleOffset,
				getWidth()/2-circleOffset, getHeight()/2+circleOffset);	
		g.drawLine(getWidth()/2-circleOffset, getHeight()/2-circleOffset*5,
				getWidth()/2-circleOffset, getHeight()/2-circleOffset);
		g.drawLine(getWidth()/2+circleOffset, getHeight()/2-circleOffset*5,
				getWidth()/2+circleOffset, getHeight()/2-circleOffset);
		g.drawLine(getWidth()/2-circleOffset, getHeight()/2-circleOffset*5,
				getWidth()/2+circleOffset, getHeight()/2-circleOffset*5);			
		g.drawLine(getWidth()/2+circleOffset*5, getHeight()/2-circleOffset,
				getWidth()/2+circleOffset, getHeight()/2-circleOffset);
		g.drawLine(getWidth()/2+circleOffset*5, getHeight()/2+circleOffset,
				getWidth()/2+circleOffset*5, getHeight()/2-circleOffset);
		g.drawLine(getWidth()/2+circleOffset*5, getHeight()/2+circleOffset,
				getWidth()/2+circleOffset, getHeight()/2+circleOffset);	
		g.drawLine(getWidth()/2-circleOffset, getHeight()/2+circleOffset*5,
				getWidth()/2-circleOffset, getHeight()/2+circleOffset);
		g.drawLine(getWidth()/2+circleOffset, getHeight()/2+circleOffset*5,
				getWidth()/2+circleOffset, getHeight()/2+circleOffset);
		g.drawLine(getWidth()/2-circleOffset, getHeight()/2+circleOffset*5,
				getWidth()/2+circleOffset, getHeight()/2+circleOffset*5);
		
		//Draw the coloured paths, entries and backgrounds for each player
		g.setColor(Color.blue);
		g.drawLine(getWidth()/2-circleOffset*5, getHeight()/2,
				getWidth()/2-circleOffset, getHeight()/2);
		g.fillOval(getWidth()/2-(circleSize+2)/2-circleOffset*5,
				getHeight()/2-(circleSize+2)/2-circleOffset, circleSize+2, circleSize+2);	
		g.setColor(Color.yellow);
		g.drawLine(getWidth()/2, getHeight()/2-circleOffset*5,
				getWidth()/2, getHeight()/2-circleOffset);
		g.fillOval(getWidth()/2-(circleSize+2)/2+circleOffset,
				getHeight()/2-(circleSize+2)/2-circleOffset*5, circleSize+2, circleSize+2);			
		g.setColor(Color.green);
		g.drawLine(getWidth()/2+circleOffset*5, getHeight()/2,
				getWidth()/2+circleOffset, getHeight()/2);
		g.fillOval(getWidth()/2-(circleSize+2)/2+circleOffset*5,
				getHeight()/2-(circleSize+2)/2+circleOffset, circleSize+2, circleSize+2);
		g.setColor(Color.red);
		g.drawLine(getWidth()/2, getHeight()/2+circleOffset*5,
				getWidth()/2, getHeight()/2+circleOffset);
		g.fillOval(getWidth()/2-(circleSize+2)/2-circleOffset,
				getHeight()/2-(circleSize+2)/2+circleOffset*5, circleSize+2, circleSize+2);
		
		//Draw the outer path fields
		for(int i=0;i<40;i++){
			g.setColor(Color.black);	
			g.drawOval(xMapping.get(i),yMapping.get(i),circleSize,circleSize);
			g.setColor(Color.white);	
			g.fillOval(xMapping.get(i)+1,yMapping.get(i)+1,circleSize-2,circleSize-2);
		}		
		//Draw the Goal fields
		for(int i=0;i<4;i++){
			g.setColor(Color.black);	
			g.drawOval(p1GoalxMap.get(i),p1GoalyMap.get(i),circleSize,circleSize);
			g.drawOval(p2GoalxMap.get(i),p2GoalyMap.get(i),circleSize,circleSize);
			g.drawOval(p3GoalxMap.get(i),p3GoalyMap.get(i),circleSize,circleSize);
			g.drawOval(p4GoalxMap.get(i),p4GoalyMap.get(i),circleSize,circleSize);
			g.setColor(Color.white);	
			g.fillOval(p1GoalxMap.get(i)+1,p1GoalyMap.get(i)+1,circleSize-2,circleSize-2);
			g.fillOval(p2GoalxMap.get(i)+1,p2GoalyMap.get(i)+1,circleSize-2,circleSize-2);
			g.fillOval(p3GoalxMap.get(i)+1,p3GoalyMap.get(i)+1,circleSize-2,circleSize-2);
			g.fillOval(p4GoalxMap.get(i)+1,p4GoalyMap.get(i)+1,circleSize-2,circleSize-2);
		}	
		
		//Draw the Home fields
		for(int i=0;i<4;i++){
			g.setColor(Color.blue);
			g.fillOval(p1HomexMap.get(i)-1,p1HomeyMap.get(i)-1, circleSize+2, circleSize+2);
			g.setColor(Color.yellow);
			g.fillOval(p2HomexMap.get(i)-1,p2HomeyMap.get(i)-1, circleSize+2, circleSize+2);
			g.setColor(Color.green);
			g.fillOval(p3HomexMap.get(i)-1,p3HomeyMap.get(i)-1, circleSize+2, circleSize+2);
			g.setColor(Color.red);
			g.fillOval(p4HomexMap.get(i)-1,p4HomeyMap.get(i)-1, circleSize+2, circleSize+2);			
			g.setColor(Color.black);	
			g.drawOval(p1HomexMap.get(i),p1HomeyMap.get(i),circleSize,circleSize);
			g.drawOval(p2HomexMap.get(i),p2HomeyMap.get(i),circleSize,circleSize);
			g.drawOval(p3HomexMap.get(i),p3HomeyMap.get(i),circleSize,circleSize);
			g.drawOval(p4HomexMap.get(i),p4HomeyMap.get(i),circleSize,circleSize);
			g.setColor(Color.white);	
			g.fillOval(p1HomexMap.get(i)+1,p1HomeyMap.get(i)+1,circleSize-2,circleSize-2);
			g.fillOval(p2HomexMap.get(i)+1,p2HomeyMap.get(i)+1,circleSize-2,circleSize-2);
			g.fillOval(p3HomexMap.get(i)+1,p3HomeyMap.get(i)+1,circleSize-2,circleSize-2);
			g.fillOval(p4HomexMap.get(i)+1,p4HomeyMap.get(i)+1,circleSize-2,circleSize-2);
		}
	
		//Draw the player names
		g.setColor(Color.black);
		switch(playerNames.length){
			case 4:
				g.drawChars(playerNames[3].toCharArray(),0,playerNames[3].length(), 22, 244);
			case 3:
				g.drawChars(playerNames[0].toCharArray(),0,playerNames[0].length(), 22, 44);
				g.drawChars(playerNames[1].toCharArray(),0,playerNames[1].length(), 282, 44);
				g.drawChars(playerNames[2].toCharArray(),0,playerNames[2].length(), 282, 244);
				break;
			case 2:
				g.drawChars(playerNames[0].toCharArray(),0,playerNames[0].length(), 22,44);
				g.drawChars(playerNames[1].toCharArray(),0,playerNames[1].length(), 282, 244);
			break;	
		}
		
	}	
		
	/**
	 * Use this function to draw a pawn that is on the board (not at Home or in a Goal field)
	 * @param playerNumber [0,3] used to determine the colour of the pawn to draw
	 * @param pawnLocationIndex [0,39]
	 * @param pawnIDNumber [1,4]
	 */
	public void paintPawnOnBoard(int playerNumber, int pawnLocationIndex, int pawnIDNumber){
		Graphics g = this.getGraphics();
		char[] text = Integer.toString(pawnIDNumber).toCharArray();

		switch( playerNumber){
			case 0:
				g.setColor(Color.blue);
				break;
			case 1:
				g.setColor(Color.yellow);
				break;
			case 2:
				g.setColor(Color.green);
				break;
			case 3:
				g.setColor(Color.red);
			break;
		}
		g.fillOval(xMapping.get(pawnLocationIndex),yMapping.get(pawnLocationIndex),circleSize,circleSize);		

		switch(playerNumber){
			case 0: case 3: g.setColor(Color.white);
			break;	
			case 1: case 2: g.setColor(Color.black);
			break;	
		}
		g.drawChars(text, 0, 1, xMapping.get(pawnLocationIndex)+4, yMapping.get(pawnLocationIndex)+12);
	}
	
	/**
	 * Use this function to draw a pawn that is in a Home field
	 * @param playerNumber [0,3] used to determine the colour of the pawn to draw
	 * @param pawnLocationIndex [0,3]
	 * @param pawnIDNumber [1,4]
	 */
	public void paintPawnAtHome(int playerNumber, int pawnLocationIndex, int pawnIDNumber){
		Graphics g = this.getGraphics();		
		char[] text = Integer.toString(pawnIDNumber).toCharArray();

		switch( playerNumber){
			case 0:
				g.setColor(Color.blue);
				g.fillOval(p1HomexMap.get(pawnLocationIndex),p1HomeyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.white);
				g.drawChars(text, 0, 1, p1HomexMap.get(pawnLocationIndex)+4, p1HomeyMap.get(pawnLocationIndex)+12);
				break;
			case 1:
				g.setColor(Color.yellow);
				g.fillOval(p2HomexMap.get(pawnLocationIndex),p2HomeyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.black);
				g.drawChars(text, 0, 1, p2HomexMap.get(pawnLocationIndex)+4, p2HomeyMap.get(pawnLocationIndex)+12);
				break;
			case 2:
				g.setColor(Color.green);
				g.fillOval(p3HomexMap.get(pawnLocationIndex),p3HomeyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.black);
				g.drawChars(text, 0, 1, p3HomexMap.get(pawnLocationIndex)+4, p3HomeyMap.get(pawnLocationIndex)+12);
				break;
			case 3:
				g.setColor(Color.red);
				g.fillOval(p4HomexMap.get(pawnLocationIndex),p4HomeyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.white);
				g.drawChars(text, 0, 1, p4HomexMap.get(pawnLocationIndex)+4, p4HomeyMap.get(pawnLocationIndex)+12);
			break;
		}
	}
	
	/**
	 * Use this function to draw a pawn that is in a Goal field
	 * @param playerNumber [0,3] used to determine the colour of the pawn to draw
	 * @param pawnLocationIndex [0,3]
	 * @param pawnIDNumber [1,4]
	 */
	public void paintPawnOnGoal(int playerNumber, int pawnLocationIndex, int pawnIDNumber){
		Graphics g = this.getGraphics();
		char[] text = Integer.toString(pawnIDNumber).toCharArray();
		
		switch( playerNumber){
			case 0:
				g.setColor(Color.blue);
				g.fillOval(p1GoalxMap.get(pawnLocationIndex),p1GoalyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.white);
				g.drawChars(text, 0, 1, p1GoalxMap.get(pawnLocationIndex)+4, p1GoalyMap.get(pawnLocationIndex)+12);
				break;
			case 1:
				g.setColor(Color.yellow);
				g.fillOval(p2GoalxMap.get(pawnLocationIndex),p2GoalyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.black);
				g.drawChars(text, 0, 1, p2GoalxMap.get(pawnLocationIndex)+4, p2GoalyMap.get(pawnLocationIndex)+12);
				break;
			case 2:
				g.setColor(Color.green);
				g.fillOval(p3GoalxMap.get(pawnLocationIndex),p3GoalyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.black);
				g.drawChars(text, 0, 1, p3GoalxMap.get(pawnLocationIndex)+4, p3GoalyMap.get(pawnLocationIndex)+12);
				break;
			case 3:
				g.setColor(Color.red);
				g.fillOval(p4GoalxMap.get(pawnLocationIndex),p4GoalyMap.get(pawnLocationIndex),circleSize,circleSize);
				g.setColor(Color.white);
				g.drawChars(text, 0, 1, p4GoalxMap.get(pawnLocationIndex)+4, p4GoalyMap.get(pawnLocationIndex)+12);
			break;
		}
	}
	
}

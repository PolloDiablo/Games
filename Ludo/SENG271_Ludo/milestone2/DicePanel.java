package milestone2;

import java.awt.Graphics;
import java.awt.Panel;

@SuppressWarnings("serial")
public class DicePanel extends Panel {
	
	/**
	 * Default dice eye size
	 */
	private static final int diceSize=10;
	
	/**
	 * Default dice eye separation 
	 */
	private static final int diceOffset=16;
	
    /**
     * Draws the die based on the number of eyes.
     * @param eyes
     */
    public void paintEyes(int eyes) {
		Graphics g = this.getGraphics();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		switch(eyes){
		case 5:
			g.fillOval(this.getWidth()/2-diceOffset-diceSize/2, this.getHeight()/2-diceOffset-diceSize/2, diceSize,diceSize);
			g.fillOval(this.getWidth()/2+diceOffset-diceSize/2, this.getHeight()/2+diceOffset-diceSize/2, diceSize,diceSize);
		case 3:
			g.fillOval(this.getWidth()/2-diceOffset-diceSize/2, this.getHeight()/2+diceOffset-diceSize/2, diceSize,diceSize);
			g.fillOval(this.getWidth()/2+diceOffset-diceSize/2, this.getHeight()/2-diceOffset-diceSize/2, diceSize,diceSize);
		case 1:
			g.fillOval(this.getWidth()/2-diceSize/2, this.getHeight()/2-diceSize/2, diceSize,diceSize);
			break;		
		case 6:	
			g.fillOval(this.getWidth()/2-diceOffset-diceSize/2, this.getHeight()/2-diceSize/2, diceSize,diceSize);
			g.fillOval(this.getWidth()/2+diceOffset-diceSize/2, this.getHeight()/2-diceSize/2, diceSize,diceSize);		
		case 4:	
			g.fillOval(this.getWidth()/2-diceOffset-diceSize/2, this.getHeight()/2-diceOffset-diceSize/2, diceSize,diceSize);
			g.fillOval(this.getWidth()/2+diceOffset-diceSize/2, this.getHeight()/2+diceOffset-diceSize/2, diceSize,diceSize);
		case 2:
			g.fillOval(this.getWidth()/2-diceOffset-diceSize/2, this.getHeight()/2+diceOffset-diceSize/2, diceSize,diceSize);
			g.fillOval(this.getWidth()/2+diceOffset-diceSize/2, this.getHeight()/2-diceOffset-diceSize/2, diceSize,diceSize);
			break;	
		}	
	}
}

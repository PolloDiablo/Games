package milestone2;

import javax.swing.JFrame;
import java.awt.List;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GameJFrame extends JFrame {

	/**
	 * The title bar which displays the current player or winner.
	 */
	private JTextPane titlePane;
	
	/**
	 * The panel behind the die, can be coloured to represent the player who's turn it is.
	 */
	private JPanel diceBackgroundPanel;
	
	/**
	 * The die display.
	 */
	private DicePanel dicePanel;
	
	/**
	 * The main game board panel.
	 */
	private BoardPanel boardPanel;
	
	/**
	 * The list of moves on the left-hand side of the screen
	 */
	private static List moveList;
	
	private static boolean menuButtonPressed=false;
	
	private JButton btnExitToMenu;
	
	public JButton getButton(){
		return btnExitToMenu;
	}
	
	public boolean getButtonPressed(){
		boolean temp=menuButtonPressed;
		menuButtonPressed=false;
		return temp;
	}

	public GameJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 400);
		getContentPane().setLayout(null);
		
		titlePane = new JTextPane();
		titlePane.setFont(new Font("Tahoma", Font.BOLD, 12));
		titlePane.setEditable(false);
		titlePane.setBounds(10, 11, 308, 20);
		getContentPane().add(titlePane);
		

		moveList = new List();
		moveList.setBounds(427, 177, 110, 175);
		getContentPane().add(moveList);
		
		diceBackgroundPanel = new JPanel();
		diceBackgroundPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		diceBackgroundPanel.setBounds(442, 47, 72, 75);
		getContentPane().add(diceBackgroundPanel);
		diceBackgroundPanel.setLayout(null);
		
		dicePanel = new DicePanel();
		dicePanel.setBounds(5, 5, 62, 64);
		diceBackgroundPanel.add(dicePanel);
		dicePanel.setBackground(Color.WHITE);
		
		boardPanel = new BoardPanel(){};
		boardPanel.setBackground(Color.WHITE);
		boardPanel.setBounds(10, 37, 402, 315);
		getContentPane().add(boardPanel);
		
		TextField textField = new TextField();
		textField.setEditable(false);
		textField.setText("Choose Your Move");
		textField.setBounds(427, 154, 110, 20);
		getContentPane().add(textField);
		
		btnExitToMenu = new JButton("Exit To Menu");
		btnExitToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuButtonPressed=true;
			}
		});
		btnExitToMenu.setBounds(427, 8, 110, 23);
		getContentPane().add(btnExitToMenu);
		btnExitToMenu.setVisible(false);
		
	}
	
	public JTextPane getTitlePanel(){
		return titlePane;
	}
	
	public JPanel getDiceBackgroundPanel(){
		return diceBackgroundPanel;
	}
	
	public DicePanel getDicePanel(){
		return dicePanel;
	}
	
	public BoardPanel getBoardPanel(){
		return boardPanel;
	}
	
	public static void drawBoardDestination(int pawnID) {
		moveList.add("Move Pawn "+ pawnID);
	}

	/**
	 * Checks the moveList for the human player's selection
	 */
	public static int getMoveChoice() {
		//moveList.get
		int result=-1;
		
		while(result == -1){
			try {
				Thread.sleep(200);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			result=moveList.getSelectedIndex();
		}	
		moveList.removeAll();
		return result;
	}
}

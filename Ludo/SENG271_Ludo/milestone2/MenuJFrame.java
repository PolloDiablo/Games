package milestone2;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuJFrame extends JFrame {

	private JPanel contentPane;

	TextField player1NameChoice;
	TextField player2NameChoice;
	TextField player3NameChoice;
	TextField player4NameChoice;
	Choice player1DropDownChoice;
	Choice player2DropDownChoice;
	Choice player3DropDownChoice;
	Choice player4DropDownChoice;
	
	private JLayeredPane player2Pane;
	private JLayeredPane player3Pane;
	private JLayeredPane player4Pane;
	private Choice numberOfPlayersChoice;
	
	public int getNumberOfPlayers(){
		return numberOfPlayersChoice.getSelectedIndex()+2;
	}
	
	private Button startGameButton;
	
	private static boolean startGameButtonPressed=false;
	
	public boolean getButtonPressed(){
		boolean temp=startGameButtonPressed;
		startGameButtonPressed=false;
		return temp;
	}

	/**
	 * Create the frame.
	 */
	public MenuJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 449);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnLudo = new JTextPane();
		txtpnLudo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnLudo.setBackground(Color.WHITE);
		txtpnLudo.setEditable(false);
		txtpnLudo.setText("LUDO");
		txtpnLudo.setBounds(216, 11, 128, 32);
		contentPane.add(txtpnLudo);
		
		//Player 1
		JLayeredPane player1Pane = new JLayeredPane();
		player1Pane.setBorder(new LineBorder(Color.BLUE, 4, true));
		player1Pane.setBounds(35, 54, 175, 156);
		contentPane.add(player1Pane);
		
		player1DropDownChoice = new Choice();
		player1DropDownChoice.setBounds(22, 126, 130, 20);
		player1Pane.add(player1DropDownChoice);
		
		player1NameChoice = new TextField();
		player1NameChoice.setBounds(22, 74, 130, 20);
		player1Pane.add(player1NameChoice);
		populateDropDownList(player1DropDownChoice);
		
		JTextPane player1TypeText = new JTextPane();
		player1TypeText.setText("Type:");
		player1TypeText.setBounds(22, 100, 130, 20);
		player1Pane.add(player1TypeText);
		
		JTextPane player1NameText = new JTextPane();
		player1NameText.setText("Name:");
		player1NameText.setBounds(22, 48, 130, 20);
		player1Pane.add(player1NameText);
		
		JTextPane player1TitleText = new JTextPane();
		player1TitleText.setFont(new Font("Tahoma", Font.BOLD, 13));
		player1TitleText.setText("Player 1");
		player1TitleText.setBounds(22, 11, 130, 36);
		player1Pane.add(player1TitleText);
		
		//Player 2
		player2Pane = new JLayeredPane();
		player2Pane.setBorder(new LineBorder(Color.GREEN, 4, true));
		player2Pane.setBounds(283, 54, 175, 156);
		contentPane.add(player2Pane);
		
		JTextPane player2TitleText = new JTextPane();
		player2TitleText.setFont(new Font("Tahoma", Font.BOLD, 13));
		player2TitleText.setText("Player 2");
		player2TitleText.setBounds(22, 11, 130, 36);
		player2Pane.add(player2TitleText);
		
		JTextPane player2NameText = new JTextPane();
		player2NameText.setText("Name:");
		player2NameText.setBounds(22, 48, 130, 20);
		player2Pane.add(player2NameText);
		
		player2NameChoice = new TextField();
		player2NameChoice.setBounds(22, 74, 130, 20);
		player2Pane.add(player2NameChoice);
		
		JTextPane player2TypeText = new JTextPane();
		player2TypeText.setText("Type:");
		player2TypeText.setBounds(22, 100, 130, 20);
		player2Pane.add(player2TypeText);
		
		player2DropDownChoice = new Choice();
		player2DropDownChoice.setBounds(22, 126, 130, 20);
		player2Pane.add(player2DropDownChoice);
		populateDropDownList(player2DropDownChoice);
		
		//Player 3
		player3Pane = new JLayeredPane();
		player3Pane.setBorder(new LineBorder(Color.GREEN, 4, true));
		player3Pane.setBounds(35, 239, 175, 161);
		contentPane.add(player3Pane);
		
		JTextPane player3TitleText = new JTextPane();
		player3TitleText.setBounds(23, 11, 130, 36);
		player3Pane.add(player3TitleText);
		player3TitleText.setFont(new Font("Tahoma", Font.BOLD, 13));
		player3TitleText.setText("Player 3");
		
		JTextPane player3NameText = new JTextPane();
		player3NameText.setText("Name:");
		player3NameText.setBounds(23, 48, 130, 20);
		player3Pane.add(player3NameText);		
		
		player3NameChoice = new TextField();
		player3NameChoice.setBounds(23, 74, 130, 20);
		player3Pane.add(player3NameChoice);		
		
		JTextPane player3TypeText = new JTextPane();
		player3TypeText.setText("Type:");
		player3TypeText.setBounds(23, 100, 130, 20);
		player3Pane.add(player3TypeText);	
		
		player3DropDownChoice = new Choice();
		player3DropDownChoice.setBounds(23, 126, 130, 20);
		player3Pane.add(player3DropDownChoice);
		populateDropDownList(player3DropDownChoice);
		
		//Player 4
		player4Pane = new JLayeredPane();
		player4Pane.setBorder(new LineBorder(Color.RED, 4, true));
		player4Pane.setBounds(283, 239, 175, 161);
		contentPane.add(player4Pane);
		
		JTextPane player4TitleText = new JTextPane();
		player4TitleText.setFont(new Font("Tahoma", Font.BOLD, 13));
		player4TitleText.setText("Player 4");
		player4TitleText.setBounds(20, 11, 130, 36);
		player4Pane.add(player4TitleText);
		
		JTextPane player4NameText = new JTextPane();
		player4NameText.setText("Name:");
		player4NameText.setBounds(20, 48, 130, 20);
		player4Pane.add(player4NameText);
		
		player4NameChoice = new TextField();
		player4NameChoice.setBounds(20, 74, 130, 20);
		player4Pane.add(player4NameChoice);
		
		JTextPane player4TypeText = new JTextPane();
		player4TypeText.setText("Type:");
		player4TypeText.setBounds(20, 100, 130, 20);
		player4Pane.add(player4TypeText);
		
		player4DropDownChoice = new Choice();
		player4DropDownChoice.setBounds(20, 126, 130, 20);
		player4Pane.add(player4DropDownChoice);
		populateDropDownList(player4DropDownChoice);
		
		//Outside
		startGameButton = new Button("START GAME");
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGameButtonPressed=true;
			}
		});
		startGameButton.setBounds(493, 274, 103, 80);
		contentPane.add(startGameButton);
		
		numberOfPlayersChoice = new Choice();
		numberOfPlayersChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				setPaneVisibility();
			}
		});
		
		numberOfPlayersChoice.setBounds(493, 190, 103, 20);
		contentPane.add(numberOfPlayersChoice);
		numberOfPlayersChoice.add("2");
		numberOfPlayersChoice.add("3");
		numberOfPlayersChoice.add("4");
		
		JTextPane txtpnNumberOfPlayers = new JTextPane();
		txtpnNumberOfPlayers.setText("Number of Players:");
		txtpnNumberOfPlayers.setBounds(493, 167, 103, 20);
		contentPane.add(txtpnNumberOfPlayers);
		
		player3Pane.setVisible(false);
		player4Pane.setVisible(false);
		
	}
	
	private void populateDropDownList(Choice c){
		c.add("Human");
		c.add("AggressiveMoveFirst");
		c.add("AggressiveMoveLast");
		c.add("Cautious");
		c.add("Defensive");
		c.add("MoveFirst");
		c.add("MoveLast");
	}
	
	/**
	 * Sets the visibility of the player-customization panes, based on the current # of players selected
	 */
	private void setPaneVisibility(){
		switch(Integer.parseInt(numberOfPlayersChoice.getSelectedItem())){
		case 2:
			player2Pane.setBorder(new LineBorder(Color.GREEN, 4, true));
			player3Pane.setVisible(false);
			player4Pane.setVisible(false);
		break;
		case 3:
			player2Pane.setBorder(new LineBorder(Color.YELLOW, 4, true));
			player3Pane.setVisible(true);
			player4Pane.setVisible(false);
		break;
		case 4:
			player2Pane.setBorder(new LineBorder(Color.YELLOW, 4, true));
			player3Pane.setVisible(true);
			player4Pane.setVisible(true);
		break;
		}
	}
	
	/**
	 * @param numberOfPlayers
	 * @return The user's chosen player names as a String[]
	 */
	public String[] getPlayerNames(int numberOfPlayers){
		String[] output = new String[numberOfPlayers];
		
		switch(numberOfPlayers){
			case 4:
				output[3]=formatString(player4NameChoice.getText());
			case 3:	
				output[2]=formatString(player3NameChoice.getText());
			case 2:
				output[0]=formatString(player1NameChoice.getText());
				output[1]=formatString(player2NameChoice.getText());
			break;
		}	
		for(int i=0;i<numberOfPlayers;i++){
			if(output[i].equals(null) || output[i].equals("")){
				int temp = i+1;
				output[i]= "Player " + temp;
			}
		}	
		return output;
	}
	
	/**
	 * @param string
	 * @return The string cut down to a limited size and with non-alphanumeric characters removed. Spaces are allowed.
	 */
	private String formatString(String string){
		string=string.replaceAll("[^A-Za-z0-9 ]", "");
		if(string.length()>15){
			string=string.substring(0, 14);
		}
		return string;
	}
	
	/**
	 * @param numberOfPlayers
	 * @return The user's chosen player strategies as a String[]
	 */
	public String[] getStrategyStrings(int numberOfPlayers){
		String[] output = new String[numberOfPlayers];
		switch(numberOfPlayers){
			case 4:
				output[3]=player4DropDownChoice.getSelectedItem();
			case 3:	
				output[2]=player3DropDownChoice.getSelectedItem();
			case 2:
				output[0]=player1DropDownChoice.getSelectedItem();
				output[1]=player2DropDownChoice.getSelectedItem();
			break;
		}
		return output;
	} 
	
	/**
	 * @param numberOfPlayers
	 * @return The user's chosen player strategies as a Strategy[]
	 */
	public Strategy[] getPlayerStrategies(int numberOfPlayers){
		Strategy[] output = new Strategy[numberOfPlayers];
		
		switch(numberOfPlayers){
			case 4:
				output[3]=stringToStrategy(this.player4DropDownChoice.getSelectedItem());
			case 3:	
				output[2]=stringToStrategy(this.player3DropDownChoice.getSelectedItem());
			case 2:
				output[0]=stringToStrategy(this.player1DropDownChoice.getSelectedItem());
				output[1]=stringToStrategy(this.player2DropDownChoice.getSelectedItem());
			break;
		}		
		return output;
	}
		
	/**
	 * @param A String which matches one of the concrete strategies
	 * @return The Strategy corresponding to the given String
	 */
	private Strategy stringToStrategy(String input){
		Strategy output;

		switch(input){
			case "Human": output = new HumanStrategy(); break;
			case "AggressiveMoveFirst": output = new AggressiveMoveFirstStrategy(); break;
			case "AggressiveMoveLast": output = new AggressiveMoveLastStrategy(); break;
			case "Cautious": output = new CautiousStrategy(); break;
			case "Defensive": output = new DefensiveStrategy(); break;
			case "MoveFirst": output = new MoveFirstStrategy(); break;
			case "MoveLast": output = new MoveLastStrategy(); break;
			default:
				System.err.println("Invalid Strategy:" + input);
				output = new HumanStrategy();
		}
		
		return output;
	}
			
}

package milestone2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SimulationPanel extends JFrame {

	private JPanel contentPane;
	private JTextPane playerInfoTextPane;
	private JTextPane scoreTextPane;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public SimulationPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		playerInfoTextPane = new JTextPane();
		playerInfoTextPane.setBounds(10, 11, 270, 115);
		playerInfoTextPane.setEditable(false);
		contentPane.add(playerInfoTextPane);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(217, 137, 113, 33);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		scoreTextPane = new JTextPane();
		scoreTextPane.setBounds(279, 11, 51, 115);
		contentPane.add(scoreTextPane);
		contentPane.add(btnClose);
		
		label = new JLabel("");
		label.setBounds(217, 131, 212, 126);
		contentPane.add(label);
	}
	
	/**
	 * @param playerNames [2-4] List of player names.
	 * @param playerScores [2-4] The number of wins of each player.
	 * @param playerStrategies [2-4] The strategy of each player.
	 */
	public void displayScores(String[] playerNames, int[] playerScores, String[] playerStrategies){
		String output = "Number of Wins\n";
		for(int i=0;i<playerNames.length;i++){
			output += playerNames[i] + " (" + playerStrategies[i] + "):\n";
		}
		playerInfoTextPane.setText(output);
		
		output = "\n";
		for(int i=0;i<playerNames.length;i++){
			output += playerScores[i]+"\n";
		}
		scoreTextPane.setText(output);
	}

}

package Minesweeper.MinesweeperView;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextPanel extends JPanel {
	private JLabel textLabel;
	
	public TextPanel(String nome) {
		textLabel = new JLabel(nome);
		textLabel.setFont(new Font("Arial", Font.BOLD, 25));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setOpaque(true);
		
	}
}
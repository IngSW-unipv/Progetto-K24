package ViewMine;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Minesweeper.MinesweeperView.BoardPanel;
import Minesweeper.MinesweeperView.TextPanel;

public class MinesweeperFrame extends JFrame {
	private final int DIM_CELLA = 70; //Ciascuna cella è di 70*70 pixel
	private int numRig = 8; //Lasciare personalizzabili!!!!!!!
	private int numCol = 8;
	private TextPanel textPanel;
	private BoardPanel boardPanel;
	
	public void setNumRig(int r) {
		numRig = r;
	}
	public void setNumCol(int c) {
		numCol = c;
	}
	public int getNumRig() {
		return numRig;
	}
	public int getNumCol() {
		return numCol;
	}
	
	public MinesweeperFrame() {
		setSize(numCol*DIM_CELLA, numRig*DIM_CELLA);
		// Per posizionare la finestra al centro dello schermo
		setLocationRelativeTo(null); 
		// Per impedire di cambiare la dimensione
		setResizable(false); 
		// Chiusura del frame quando si clicca sulla x di chiusura
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout(new BorderLayout());
		Container contentPane = getContentPane();
		textPanel = new TextPanel("Prato Fiorito");
		contentPane.add(textPanel, BorderLayout.NORTH);
		boardPanel = new BoardPanel(numRig, numCol);
		contentPane.add(boardPanel);
		
	}
}



				
	
	
	


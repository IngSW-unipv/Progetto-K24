package ViewMine;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; //Usiamo una ArrayList per memorizzare tutte le celle della griglia contenenti le mine
import java.util.Random; //La usiamo per la generazione casuale di mine sulla griglia
import javax.swing.*;

import Minesweeper.MinesweeperView.MineTile;

public class Minesweeper {
	private int dimCella = 70; //Ciascuna cella è di 70*70 pixel
	private int numRighe = 8; //Lasciare personalizzabili!
	private int numColonne = 8;
	private int boardWidth = dimCella*numColonne;
	private int boardHeight = dimCella*numRighe;
	
	private JFrame frame;
	private JPanel textPanel;
	private JLabel textLabel;
	private JPanel boardPanel;
	
	int mineCount = 10;
	private MineTile[][] board;
	private ArrayList<MineTile> mineList;
	Random random = new Random();
	
	int tilesClicked = 0;
	boolean gameOver = false;
	
	public Minesweeper() {
		frame = new JFrame("Prato Fiorito"); 
		//frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null); //posiziona la finestra al centro dello schermo
		frame.setResizable(false); //impedisce di cambiare la dimensione
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //chiusura del frame quando si clicca la croce di chiusura
		frame.setLayout(new BorderLayout());
		
		textLabel = new JLabel("Prato Fiorito: " + Integer.toString(mineCount));
		textLabel.setFont(new Font("Arial", Font.BOLD, 25));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setOpaque(true);
		
		textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(textLabel);
		frame.add(textPanel, BorderLayout.NORTH);  
		
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(numRighe, numColonne));
		//boardPanel.setBackground(Color.green); //Altrimenti non si vede il GridLayout rispetto al resto
		frame.add(boardPanel);
		
		board = new MineTile[numRighe][numColonne];
		
		for (int r=0; r<numRighe; r++) {
			for (int c=0; c<numColonne; c++) {
				MineTile tile = new MineTile(r, c);
				board[r][c] = tile;
				
				tile.setFocusable(false);
				tile.setMargin(new Insets(0, 0, 0, 0));
				tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
				tile.addMouseListener(new MouseAdapter() {
					// @override
					public void mousePressed(MouseEvent e) {
						//Se gameOver è vero si salta tutta la logica del Listener
						if (gameOver) {
							return;
						}
						MineTile tile = (MineTile) e.getSource();
						
						//leftclick, BUTTON1 rappresenta il tasto sinistro 
						if (e.getButton() == MouseEvent.BUTTON1) {
							if (tile.getText() == "") { //significa che ancora non l'abbiamo clickato come bottone
								if (mineList.contains(tile)) {
									revealMines();
								} else {
									checkMine(tile.getRig(), tile.getCol());
								}
							}
						}
						//Tasto destro (BUTTON3) per mettere le bandiere
						else if (e.getButton() == MouseEvent.BUTTON3){
							if (tile.getText() == "" && tile.isEnabled()) {
								tile.setText("F");
							} else if (tile.getText() == "F") {
								tile.setText("");
							}
						}
						}
					}


				);
				
				boardPanel.add(tile);
			}
		}
		
		frame.setVisible(true);
		
		setMines();
	}
	
	private void setMines() {
		mineList = new ArrayList<MineTile>();
		int mineRimaste  = mineCount;
		while (mineRimaste > 0) {
			int r = random.nextInt(numRighe);
			int c = random.nextInt(numColonne);
			
			MineTile tile = board[r][c];
			if (!mineList.contains(tile)) {
				mineList.add(tile);
				mineRimaste -= 1;
			}
		}
	}
	
	private void revealMines() {
		for (int i=0; i<mineList.size(); i++) {
			MineTile tile = mineList.get(i);
			tile.setText("B"); //bomba
		}
		gameOver = true;
		textLabel.setText("Hai perso");
	}
	
	private void checkMine(int rig, int col) {
		//Controlliamo di non essere fuori dai confini della board
		if (rig < 0 || rig >= numRighe || col < 0 || col >= numColonne) {
			return;
		}
		
		MineTile tile = board[rig][col];
		
		//Permette di aprire tutti i bottoni delle caselle che non hanno un numero (in quanto non sono vicine nemmeno a una bomba)
		if (!tile.isEnabled()) {
			return;
		}
		
		tile.setEnabled(false); //disattiva bottone
		tilesClicked += 1;
		
		int minesFound = 0;
		
		//Controlliamo le tile vicine, iniziando da quelle in alto
		minesFound += countMine(rig-1, col-1); //in alto a sinistra
		minesFound += countMine(rig-1, col); //in alto al centro
		minesFound += countMine(rig-1, col+1); //in alto a destra
		
		//Controlliamo quelle a sinistra e destra
		minesFound += countMine(rig, col-1); //sinistra
		minesFound += countMine(rig, col+1); //destra

		//Controlliamo le tre in basso
		minesFound += countMine(rig+1, col-1); //in basso a sinistra
		minesFound += countMine(rig+1, col); //in basso al centro
		minesFound += countMine(rig+1, col+1); //in basso a destra
		
		if (minesFound > 0) {
			tile.setText(Integer.toString(minesFound));
		} else {
			tile.setText("");
			//Apriamo le tile vicine, iniziando da quelle in alto
			checkMine(rig-1, col-1); //in alto a sinistra
			checkMine(rig-1, col); //in alto al centro
			checkMine(rig-1, col+1); //in alto a destra
			
			//Apriamo quelle a sinistra e destra
			checkMine(rig, col-1); //sinistra
			checkMine(rig, col+1); //destra

			//Apriamo le tre in basso
			checkMine(rig+1, col-1); //in basso a sinistra
			checkMine(rig+1, col); //in basso al centro
			checkMine(rig+1, col+1); //in basso a destra
		}
		if (tilesClicked == numRighe*numColonne-mineList.size()) {
			gameOver = true;
			textLabel.setText("Hai vinto!");
		}

	}

	private int countMine(int r, int c) {
		// Per prima cosa controlliamo di non uscire dalla griglia
		if (r < 0 || r >= numRighe || c < 0 || c >= numColonne) {
			return 0;
		} else if (mineList.contains(board[r][c])) {
			return 1;
		} else {
		return 0;
		}
	}
}

package Minesweeper.MinesweeperView;

import javax.swing.*;

import Minesweeper.MinesweeperModel.MinesweeperModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MinesweeperView {
	public JFrame frame;
	private Random random;
	private int dimCella = 70; // Ciascuna cella è di 70*70 pixel
	private int numRighe = 8; // Lasciare personalizzabili!
	private int numColonne = 8;
	private int boardWidth = getDimCella() * getNumColonne();
	private int boardHeight = getDimCella() * getNumRighe();
	private JPanel textPanel;
	private int tilesClicked;
	int mineCount = 10;
	private boolean gameOver;
	public JLabel textLabel;
	public JPanel boardPanel;

	private ArrayList<MineTile> mineList;
	public MineTile[][] board;
	public MineTile tile;

	public MinesweeperView() {
		this.random = new Random();

		frame = new JFrame("Prato Fiorito");
		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null); // posiziona la finestra al centro dello schermo
		frame.setResizable(false); // impedisce di cambiare la dimensione
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); // chiusura del frame quando si clicca la croce di chiusura
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
		boardPanel.setLayout(new GridLayout(getNumRighe(), getNumColonne()));
		// boardPanel.setBackground(Color.green); //Altrimenti non si vede il GridLayout
		// rispetto al resto
		frame.add(boardPanel);

		board = new MineTile[getNumRighe()][getNumColonne()];
		System.out.println(".");

	}

	public void Instanciate() {

		frame.setVisible(true);

	}

	public MineTile[][] getBoard() {
		return board;
	}

	public void setBoard(MineTile[][] board) {
		this.board = board;
	}

	public int getNumRighe() {
		return numRighe;
	}

	public void setNumRighe(int numRighe) {
		this.numRighe = numRighe;
	}

	public int getDimCella() {
		return dimCella;
	}

	public void setDimCella(int dimCella) {
		this.dimCella = dimCella;
	}

	public int getNumColonne() {
		return numColonne;
	}

	public void setNumColonne(int numColonne) {
		this.numColonne = numColonne;
	}

	public ArrayList<MineTile> getMineList() {
		return mineList;
	}

	public void setMineList(ArrayList<MineTile> mineList) {
		mineList = new ArrayList<MineTile>();
		this.mineList = mineList;

	}

}

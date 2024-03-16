package Minesweeper.MinesweeperModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

import Minesweeper.MinesweeperView.MineTile;
import Minesweeper.MinesweeperView.MinesweeperView;
import TorneoController.IGame;

public class MinesweeperModel implements IGame{
	private int numRighe;
	private int numColonne;
	private int mineCount;
	// public MineTile[][] board;
	// private ArrayList<MineTile> mineList;
	private Random random;
	private int tilesClicked;

	private boolean gameOver;

	public MinesweeperModel() {

		this.numRighe = 8; // Ciascuna cella è di 70*70 pixel
		this.numColonne = 8;
		this.mineCount = 10;
		this.random = new Random();
		this.tilesClicked = 0;
		this.setGameOver(false);

	}

	public void setMines(MineTile[][] board, ArrayList<MineTile> mineList, MineTile tile) {
		// mineList = new ArrayList<>();
		int mineRimaste = mineCount;
		while (mineRimaste > 0) {
			int r = random.nextInt(numRighe);
			int c = random.nextInt(numColonne);

			tile = board[r][c];
			if (!mineList.contains(tile)) {
				mineList.add(tile);
				System.out.print("Aggiungi tile");
				mineRimaste--;

			}
		}
	}

	public void initializeBoard(MineTile[][] board) {
		board = new MineTile[numRighe][numColonne];
		for (int r = 0; r < numRighe; r++) {
			for (int c = 0; c < numColonne; c++) {
				board[r][c] = new MineTile(r, c);
			}
		}
	}

	public void checkMine(int rig, int col, MineTile[][] board, JLabel textLabel, ArrayList<MineTile> mineList,
			MineTile tile) {
		// Controlliamo di non essere fuori dai confini della board
		if (rig < 0 || rig >= numRighe || col < 0 || col >= numColonne) {
			return;
		}

		tile = board[rig][col];

		// Permette di aprire tutti i bottoni delle caselle che non hanno un numero (in
		// quanto non sono vicine nemmeno a una bomba)
		if (!tile.isEnabled()) {
			return;
		}

		tile.setEnabled(false); // disattiva bottone
		tilesClicked += 1;

		int minesFound = 0;

		// Controlliamo le tile vicine, iniziando da quelle in alto
		minesFound += countMine(rig - 1, col - 1, board, mineList); // in alto a sinistra
		minesFound += countMine(rig - 1, col, board, mineList); // in alto al centro
		minesFound += countMine(rig - 1, col + 1, board, mineList); // in alto a destra

		// Controlliamo quelle a sinistra e destra
		minesFound += countMine(rig, col - 1, board, mineList); // sinistra
		minesFound += countMine(rig, col + 1, board, mineList); // destra

		// Controlliamo le tre in basso
		minesFound += countMine(rig + 1, col - 1, board, mineList); // in basso a sinistra
		minesFound += countMine(rig + 1, col, board, mineList); // in basso al centro
		minesFound += countMine(rig + 1, col + 1, board, mineList); // in basso a destra

		if (minesFound > 0) {
			tile.setText(Integer.toString(minesFound));
		} else {
			tile.setText("");
			// Apriamo le tile vicine, iniziando da quelle in alto
			checkMine(rig - 1, col - 1, board, textLabel, mineList, tile); // in alto a sinistra
			checkMine(rig - 1, col, board, textLabel, mineList, tile); // in alto al centro
			checkMine(rig - 1, col + 1, board, textLabel, mineList, tile); // in alto a destra

			// Apriamo quelle a sinistra e destra
			checkMine(rig, col - 1, board, textLabel, mineList, tile); // sinistra
			checkMine(rig, col + 1, board, textLabel, mineList, tile); // destra

			// Apriamo le tre in basso
			checkMine(rig + 1, col - 1, board, textLabel, mineList, tile); // in basso a sinistra
			checkMine(rig + 1, col, board, textLabel, mineList, tile); // in basso al centro
			checkMine(rig + 1, col + 1, board, textLabel, mineList, tile); // in basso a destra
		}
		if (tilesClicked == numRighe * numColonne - mineList.size()) {
			setGameOver(true);
			textLabel.setText("Hai vinto!");
		}

	}

	private int countMine(int r, int c, MineTile[][] board, ArrayList<MineTile> mineList) {
		// Per prima cosa controlliamo di non uscire dalla griglia
		if (r < 0 || r >= numRighe || c < 0 || c >= numColonne) {
			return 0;
		} else if (mineList.contains(board[r][c])) {
			return 1;
		} else {
			return 0;
		}
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void revealMines(JLabel textLabel, ArrayList<MineTile> mineList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mineList.size(); i++) {
			MineTile tile = mineList.get(i);
			tile.setText("B"); // bomba
		}
		setGameOver(true);
		textLabel.setText("Hai perso");
	}

	@Override
	public int punteggio() {
		// TODO Auto-generated method stub
		return 0;
	}

}

package Minesweeper.MinesweeperView;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	private MineTile[][] board;
	private ArrayList<MineTile> mineList;
	
	public BoardPanel(int numRig, int numCol) {
		setLayout(new GridLayout(numRig, numCol));
		board = new MineTile[numRig][numCol];
		
		for (int r=0; r<numRig; r++) {
			for (int c=0; c<numCol; c++) {
				MineTile tile = new MineTile(r, c);
				board[r][c] = tile;
				
				tile.setFocusable(false);
				tile.setMargin(new Insets(0, 0, 0, 0));
				tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
				
				
				add(tile);
			}
		}
	}
	

}

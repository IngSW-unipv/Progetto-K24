package Minesweeper.MinesweeperView;

import javax.swing.JButton;

//Come JButton ma ha anche attributi riga e colonna
public class MineTile extends JButton {
	private int rig;
	private int col;
	
	public MineTile(int r, int c) {
		setRig(r);
		setCol(c);
	}

	public int getRig() {
		return rig;
	}

	public void setRig(int rig) {
		this.rig = rig;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
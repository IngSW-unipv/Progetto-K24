package GiochiPlaceholder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Index.GiochiEnum;

public class TetrisPlaceholder extends GiocoPlaceholder {
	private final static GiochiEnum gioco = GiochiEnum.Tetris;
	
	public TetrisPlaceholder() {
		super(gioco);
	}
}

package GiochiPlaceholder;

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
import javax.swing.Timer;

import Index.GiochiEnum;

public class GiocoPlaceholder extends JFrame {
	private final int MILLI = 1000;
	private JPanel panel;
	private JLabel label;
	private JPanel namePanel;
	private JLabel nameLabel;
	private JPanel exitPanel;
	private JButton exit;
	private Timer timer;
	private Random random;
	
	public GiocoPlaceholder(GiochiEnum gioco) {
		
		panel = new JPanel();
		label = new JLabel("COMING SOON!");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		namePanel = new JPanel();
		nameLabel = new JLabel(gioco.toString());
		exitPanel = new JPanel();
		exit = new JButton("Indietro");
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		random = new Random();
		timer = new Timer(MILLI, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setForeground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
				//setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			}
		});
		
		timer.start();
		namePanel.add(nameLabel);
        panel.add(label);
        exitPanel.add(exit);
        setLayout(new GridLayout(3, 1));
        add(namePanel);
        add(panel);
        add(exitPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 400);
        setVisible(true);
	}
}

package Index;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.util.ArrayList;
import java.util.Random;

public class IndexView extends JFrame {

	private JPanel panelLayout;
	private JPanel leftPanel;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JLabel infoLabel;
	private JLabel errorLabel;
	private JPopupMenu menuPreferiti;
	private JButton modificaButton;
	private JButton eliminaButton;
	private JButton logoutButton;
	private JButton creaTorneo;
	private JButton iscrivitiTorneo;
	private JButton eliminaTorneo;
	private JButton disiscrivitiTorneo;
	private JButton partecipaTorneo;
	private JButton preferitiButton;
	private GameButton minesweeperButton;
	private GameButton snakeButton;
	private GameButton spaceInvadersButton;
	private GameButton tetrisButton;
	private GameButton solitarioButton;
	private ArrayList<GameButton> gameButtonList;
	private GameButton minesweeperOption;
	private GameButton snakeOption;
	private GameButton spaceInvadersOption;
	private GameButton tetrisOption;
	private GameButton solitarioOption;
	private ArrayList<GameButton> menuOptionList;
	
	// Contiene tutti i bottoni realtivi ai giochi

	// Dimensioni fisse per i bottoni del centerPanel
	private static final int BUTTON_WIDTH = 150;
	private static final int BUTTON_HEIGHT = 150;
	// Spazio tra i bottoni nel leftPanel
	private static final int BUTTON_SPACING = 15;

	public IndexView() {
		// inizializzazione
		panelLayout = new JPanel(new BorderLayout());
		leftPanel = new JPanel();
		topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		//centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		centerPanel = new JPanel (new GridLayout(2, 3));
		modificaButton = new JButton("Modifica account");
		eliminaButton = new JButton("Elimina account");
		logoutButton = new JButton("Logout");
		partecipaTorneo = new JButton("Partecipa a un torneo");
		creaTorneo = new JButton("Crea torneo");
		iscrivitiTorneo = new JButton("Iscriviti a un torneo");
		eliminaTorneo = new JButton("Elimina Torneo");
		disiscrivitiTorneo = new JButton("Disiscriviti da un torneo");
		preferitiButton = new JButton("Giochi preferiti");
		infoLabel = new JLabel("Clicca il tasto destro per aggiungere ai preferiti il gioco!");
		errorLabel = new JLabel();
		menuPreferiti = new JPopupMenu();
		
		menuOptionList = new ArrayList<GameButton>();
		menuOptionList.add(minesweeperOption = new GameButton("Minesweeper"));
		menuOptionList.add(snakeOption = new GameButton("Snake"));
		menuOptionList.add(spaceInvadersOption = new GameButton("Space Invaders"));
		menuOptionList.add(tetrisOption = new GameButton("Tetris"));
		menuOptionList.add(solitarioOption = new GameButton("Solitario"));
		
		gameButtonList = new ArrayList<GameButton>();
		gameButtonList.add(minesweeperButton = new GameButton("Minesweeper"));
		gameButtonList.add(snakeButton = new GameButton("Snake"));
		gameButtonList.add(spaceInvadersButton = new GameButton("Space Invaders"));
		gameButtonList.add(tetrisButton = new GameButton("Tetris"));
		gameButtonList.add(solitarioButton = new GameButton("Solitario"));
		

		
		// creazione oggetto random per randomizzare i colori a ogni nuova apertura (non va nel model vero?)
		Random random = new Random();
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width*3/4, Toolkit.getDefaultToolkit().getScreenSize().height*3/4);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(0, 0);

		// panelLayout
		panelLayout.setBackground(Color.WHITE);

		// leftPanel
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setPreferredSize(new Dimension((Toolkit.getDefaultToolkit().getScreenSize().width) / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height));
		// Se si vuole togliere il random color
		leftPanel.setBackground(new Color(230, 230, 230));
		//////////////////////////////////////////////////leftPanel.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

		setButtonProperties(creaTorneo);
		setButtonProperties(iscrivitiTorneo);
		setButtonProperties(partecipaTorneo);
		setButtonProperties(eliminaTorneo);
		setButtonProperties(disiscrivitiTorneo);
		// Imposta l'allineamento orizzontale dei bottoni nel leftPanel
		creaTorneo.setAlignmentX(CENTER_ALIGNMENT);
		iscrivitiTorneo.setAlignmentX(CENTER_ALIGNMENT);
		partecipaTorneo.setAlignmentX(CENTER_ALIGNMENT);
		eliminaTorneo.setAlignmentX(CENTER_ALIGNMENT);
		disiscrivitiTorneo.setAlignmentX(CENTER_ALIGNMENT);
		// Aggiungi spazio tra i bottoni nel leftPanel
		leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
		leftPanel.add(creaTorneo);
		leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
		leftPanel.add(iscrivitiTorneo);
		leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
		leftPanel.add(partecipaTorneo);
		leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
		leftPanel.add(eliminaTorneo);
		leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
		leftPanel.add(disiscrivitiTorneo);
		// topPanel
		topPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 10));
		topPanel.setBackground(new Color(135, 206, 250));
		//////////////////////////topPanel.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
		

		preferitiButton.setPreferredSize(new Dimension(150, 40));
		modificaButton.setPreferredSize(new Dimension(150, 40));
		eliminaButton.setPreferredSize(new Dimension(150, 40));
		logoutButton.setPreferredSize(new Dimension(150, 40));
 
		
		topPanel.add(preferitiButton);
		topPanel.add(Box.createHorizontalStrut(Toolkit.getDefaultToolkit().getScreenSize().width/4));
		topPanel.add(modificaButton);
		topPanel.add(eliminaButton);
		topPanel.add(logoutButton);
		
		// centerPanel
		centerPanel.setBackground(new Color(190, 128, 144));
		//////////////////////////////////centerPanel.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

		// Aggiungi bottoni al centerPanel
		for (GameButton button : gameButtonList) {
			addToCenterPanel(button);
		}
		
		// Non è necessario un bottomPanel perché c'è solo da gestire questa etichetta
		infoLabel.setVisible(false);
		errorLabel.setVisible(false);
		
		// add
		add(panelLayout);

		panelLayout.add(leftPanel, BorderLayout.WEST);
		panelLayout.add(topPanel, BorderLayout.NORTH);
		panelLayout.add(centerPanel, BorderLayout.CENTER);
		panelLayout.add(infoLabel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public JPanel getTopPanel() {
		return topPanel;
	}

	public void setTopPanel(JPanel topPanel) {
		this.topPanel = topPanel;
	}

	public JButton getPartecipaTorneo() {
		return partecipaTorneo;
	}

	public void setPartecipaTorneo(JButton partecipaTorneo) {
		this.partecipaTorneo = partecipaTorneo;
	}

	public JButton getModificaButton() {
		return modificaButton;
	}

	public void setModificaButton(JButton modificaButton) {
		this.modificaButton = modificaButton;
	}

	public JButton getEliminaButton() {
		return eliminaButton;
	}

	public void setEliminaButton(JButton eliminaButton) {
		this.eliminaButton = eliminaButton;
	}

	public GameButton getMinesweeperButton() {
		return minesweeperButton;
	}

	public void setMinesweeperButton(GameButton minesweeperButton) {
		this.minesweeperButton = minesweeperButton;
	}

	public GameButton getSnakeButton() {
		return snakeButton;
	}

	public void setSnakeButton(GameButton snakeButton) {
		this.snakeButton = snakeButton;
	}
	
	public GameButton getSpaceInvadersButton() {
		return spaceInvadersButton;
	}

	public void setSpaceInvadersButton(GameButton spaceInvadersButton) {
		this.spaceInvadersButton = spaceInvadersButton;
	}
	public GameButton getTetrisButton() {
		return tetrisButton;
	}

	public void setTetrisButton(GameButton tetrisButton) {
		this.tetrisButton = tetrisButton;
	}
	public GameButton getSolitarioButton() {
		return solitarioButton;
	}

	public void setSolitarioButton(GameButton solitarioButton) {
		this.solitarioButton = solitarioButton;
	}
	
	public ArrayList<GameButton> getGameButtonList() {
		return gameButtonList;
	}
	
	public void addToCenterPanel(GameButton button) {
		setButtonProperties(button);
		button.setSize(300, 300);
		centerPanel.add(button);
	}

	// Metodo per ridimensionare l'icona mantenendo le proporzioni
	private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		return new ImageIcon(icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
	}

	// Metodo per impostare le proprietà comuni dei pulsanti
	private void setButtonProperties(JButton button) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButton getCreaTorneo() {
		return creaTorneo;
	}

	public JButton getEliminaTorneo() {
		return eliminaTorneo;
	}

	public void setEliminaTorneo(JButton eliminaTorneo) {
		this.eliminaTorneo = eliminaTorneo;
	}

	public JButton getDisiscrivitiTorneo() {
		return disiscrivitiTorneo;
	}

	public void setDisiscrivitiTorneo(JButton disiscrivitiTorneo) {
		this.disiscrivitiTorneo = disiscrivitiTorneo;
	}

	public JButton getIscrivitiTorneo() {
		return iscrivitiTorneo;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}
	
	public JButton getPreferitiButton() {
		return preferitiButton;
	}
	
	public ArrayList<GameButton> getMenuOptionList() {
		return menuOptionList;
	}
	
	public JPopupMenu getMenuPreferiti() {
		return menuPreferiti;
	}
	
	// Getter delle opzioni

	public GameButton getMinesweeperOption() {
		return minesweeperOption;
	}

	public GameButton getSnakeOption() {
		return snakeOption;
	}
	
	public GameButton getSpaceInvadersOption() {
		return spaceInvadersOption;
	}

	public GameButton getTetrisOption() {
		return tetrisOption;
	}

	public GameButton getSolitarioOption() {
		return solitarioOption;
	}
	
	public JLabel getInfoLabel() {
		return infoLabel;
	}
	
	/*public GiochiEnum getGioco(GameButton b) {
		return b.getGioco();
	} */
	
	public boolean confermaSceltaPreferiti(int i) {
		String stringa;
		int scelta;
		if (i==0) {
			stringa = new String("Vuoi aggiungere questo gioco ai preferiti?");
		} else {
			stringa = new String("Vuoi rimuovere questo gioco ai preferiti?");	
		}
		scelta = JOptionPane.showConfirmDialog(null, stringa,
				"Conferma", JOptionPane.YES_NO_OPTION);
		return scelta == JOptionPane.YES_OPTION;
	}

	public void displayErrorView(String string) {
		errorLabel.setText(string);
		errorLabel.setForeground(Color.red);
		errorLabel.setVisible(true);
	}
}

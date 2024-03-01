package Index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IndexView extends JFrame{

	private JPanel panelLayout;
    private JPanel leftPanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JButton modificaButton;
    private JButton eliminaButton;
    private JButton logoutButton;
    private JButton creaTorneo;
    private JButton iscrivitiTorneo;
    private JButton eliminaTorneo;
    private JButton disiscrivitiTorneo;
    private JButton minesweeper;
    private JButton Minesweeper;
    // Dimensioni fisse per i bottoni del centerPanel
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 150;
    // Spazio tra i bottoni nel leftPanel
    private static final int BUTTON_SPACING = 15;
    
    
    public IndexView() {
    	//inizializzazione
    	panelLayout = new JPanel(new BorderLayout());
    	leftPanel = new JPanel();
    	topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	modificaButton = new JButton("Modifica account");
    	eliminaButton = new JButton("Elimina account");
    	logoutButton = new JButton("Logout");
    	creaTorneo = new JButton("Crea Torneo");
    	iscrivitiTorneo = new JButton("Iscriviti a Torneo");
    	eliminaTorneo = new JButton("Elimina Torneo");
    	disiscrivitiTorneo = new JButton("Disiscriviti Torneo");
        Minesweeper = new JButton("Minesweeper");
    	
    	setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(0, 0);

        // panelLayout
        panelLayout.setBackground(Color.WHITE);

        // leftPanel
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(
                new Dimension((Toolkit.getDefaultToolkit().getScreenSize().width) / 4, Toolkit.getDefaultToolkit().getScreenSize().height));
        leftPanel.setBackground(new Color(230, 230, 230));

        setButtonProperties(creaTorneo);
        setButtonProperties(iscrivitiTorneo);
        setButtonProperties(eliminaTorneo);
        setButtonProperties(disiscrivitiTorneo);
        // Imposta l'allineamento orizzontale dei bottoni nel leftPanel
        creaTorneo.setAlignmentX(CENTER_ALIGNMENT);
        iscrivitiTorneo.setAlignmentX(CENTER_ALIGNMENT);
        eliminaTorneo.setAlignmentX(CENTER_ALIGNMENT);
        disiscrivitiTorneo.setAlignmentX(CENTER_ALIGNMENT);
        // Aggiungi spazio tra i bottoni nel leftPanel
        leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
        leftPanel.add(creaTorneo);
        leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
        leftPanel.add(iscrivitiTorneo);
        leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
        leftPanel.add(eliminaTorneo);
        leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
        leftPanel.add(disiscrivitiTorneo);
        // topPanel
        topPanel.setPreferredSize(
                new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, (Toolkit.getDefaultToolkit().getScreenSize().height) / 10));
        topPanel.setBackground(new Color(135, 206, 250));

        modificaButton.setPreferredSize(new Dimension(150, 40));
        eliminaButton.setPreferredSize(new Dimension(150, 40));
        logoutButton.setPreferredSize(new Dimension(200, 40));

        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(modificaButton);
        topPanel.add(eliminaButton);
        topPanel.add(logoutButton);

        // centerPanel
        centerPanel.setBackground(new Color(144, 238, 144));

        // Aggiungi bottoni al centerPanel
        addCenterButton("Minesweeper"); //ricorda di modificare
       
        
        // add
        add(panelLayout);

        panelLayout.add(leftPanel, BorderLayout.WEST);
        panelLayout.add(topPanel, BorderLayout.NORTH);
        panelLayout.add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
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


	// Metodo per aggiungere bottoni al centerPanel con dimensioni fisse
    private void addCenterButton(String name) {
        minesweeper = new JButton(name);
        setButtonProperties(minesweeper);
        minesweeper.setSize(300, 300);
        centerPanel.add(minesweeper);
        
    }

    public JButton getMinesweeper() {
		return minesweeper;
	}


	public void setMinesweeper(JButton minesweeper) {
		this.minesweeper = minesweeper;
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
		eliminaTorneo = eliminaTorneo;
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

	
	
	
}

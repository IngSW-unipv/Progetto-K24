package Index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

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
    private JButton creaTorneo;
    private JButton iscrivitiTorneo;
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
    	creaTorneo = new JButton("Crea Torneo");
    	iscrivitiTorneo = new JButton("Iscriviti a Torneo");
    	
    	
    	setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Imposta l'allineamento orizzontale dei bottoni nel leftPanel
        creaTorneo.setAlignmentX(CENTER_ALIGNMENT);
        iscrivitiTorneo.setAlignmentX(CENTER_ALIGNMENT);

        // Aggiungi spazio tra i bottoni nel leftPanel
        leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
        leftPanel.add(creaTorneo);
        leftPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
        leftPanel.add(iscrivitiTorneo);

        // topPanel
        topPanel.setPreferredSize(
                new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, (Toolkit.getDefaultToolkit().getScreenSize().height) / 10));
        topPanel.setBackground(new Color(135, 206, 250));

        modificaButton.setPreferredSize(new Dimension(150, 40));
        eliminaButton.setPreferredSize(new Dimension(150, 40));

        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(modificaButton);
        topPanel.add(eliminaButton);

        // centerPanel
        centerPanel.setBackground(new Color(144, 238, 144));

        // Aggiungi bottoni al centerPanel
        addCenterButton(new ImageIcon("C:/Users/azera/Downloads/istockphoto-1019489342-612x612.jpg")); //ricorda di modificare
        addCenterButton(new ImageIcon("C:/Users/azera/Downloads/expert.png"));
        
        // add
        add(panelLayout);

        panelLayout.add(leftPanel, BorderLayout.WEST);
        panelLayout.add(topPanel, BorderLayout.NORTH);
        panelLayout.add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    	
    
    // Metodo per aggiungere bottoni al centerPanel con dimensioni fisse
    private void addCenterButton(ImageIcon imageIcon) {
        JButton button = new JButton(resizeIcon(imageIcon, BUTTON_WIDTH, BUTTON_HEIGHT));
        setButtonProperties(button);
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


	public JButton getIscrivitiTorneo() {
		return iscrivitiTorneo;
	}
	
	
	
}

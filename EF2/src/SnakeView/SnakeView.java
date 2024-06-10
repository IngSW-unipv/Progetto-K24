package SnakeView;

import javax.swing.*;

import SnakeModel.SnakeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakeView extends JPanel implements ActionListener {
    private static final int GRID_SIZE = SnakeGame.GRID_SIZE;
    private static final int CELL_SIZE = 20;
    //private SnakeGame gameModel;
    private Timer timer;
    static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 750;
	static final int UNIT_SIZE = 50;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
	static final int DELAY = 175;
	private final int x[] = new int[GAME_UNITS];
	private final int y[] = new int[GAME_UNITS];
	private int bodyParts = 6;
	private int applesEaten;
	private int appleX;
	private int appleY;
	private char direction = 'R';
	private boolean running = false;
	
	private Random random;

    public SnakeView() {
        //this.gameModel = gameModel;
        
        running=true;
        setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);

        timer = new Timer(120, this);
        timer.start();
        
        random = new Random();

        newApple();
        
        addKeyListener(new KeyAdapter() {
       
            @Override
    		public void keyPressed(KeyEvent e) {
    			switch (e.getKeyCode()) {
    			case KeyEvent.VK_LEFT:
    				if (direction != 'R') {
    					direction = 'L';
    				}
    				break;
    			case KeyEvent.VK_RIGHT:
    				if (direction != 'L') {
    					direction = 'R';
    				}
    				break;
    			case KeyEvent.VK_UP:
    				if (direction != 'D') {
    					direction = 'U';
    				}
    				break;
    			case KeyEvent.VK_DOWN:
    				if (direction != 'U') {
    					direction = 'D';
    				}
    				break;
    			}
    		}
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (running) {
			/*
			 * for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) { g.drawLine(i*UNIT_SIZE, 0,
			 * i*UNIT_SIZE, SCREEN_HEIGHT); g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH,
			 * i*UNIT_SIZE); }
			 */
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(45, 180, 0));
					// g.setColor(new
					// Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
					g.getFont().getSize());
		} else {
			gameOver(g);
		}
    }
    public void gameOver(Graphics g) {
		// Score
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2,
				g.getFont().getSize());
		// Game Over text
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
	}

    public void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}

	}

	public void checkApple() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	
	public void newApple() {
		appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
	}
	

	public void checkCollisions() {
		// checks if head collides with body
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		// check if head touches left border
		if (x[0] < 0) {
			running = false;
		}
		// check if head touches right border
		if (x[0] > SCREEN_WIDTH) {
			running = false;
		}
		// check if head touches top border
		if (y[0] < 0) {
			running = false;
		}
		// check if head touches bottom border
		if (y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		if (!running) {
			timer.stop();
		}
	}

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       // gameModel.move(SnakeGame.Direction.UP); // Auto move the snake to the right
        
        if (running) {

			move();
			checkApple();
			checkCollisions();
			
		}


        
        repaint();
    }
}



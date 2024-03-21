package SnakeController;

import javax.swing.*;

import SnakeModel.SnakeGame;
import SnakeView.SnakeView;

public class SnakeController {
   
      {
            JFrame frame = new JFrame("Snake Game");
            SnakeGame gameModel = new SnakeGame();
            SnakeView gameView = new SnakeView(gameModel);
            frame.add(gameView);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        
    }
}




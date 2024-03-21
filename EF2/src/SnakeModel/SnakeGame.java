package SnakeModel;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame {
    public static final int GRID_SIZE = 20;
    private int score;
    private List<Point> snake;
    private Point fruit;

    public SnakeGame() {
        snake = new ArrayList<>();
        snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2));
        score = 0;
        placeFruit();
    }

    public void move(Direction direction) {
        Point head = snake.get(0);
        Point newHead = new Point(head);
        switch (direction) {
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case LEFT:
                newHead.x--;
                break;
            case RIGHT:
                newHead.x++;
                break;
        }
        if (newHead.equals(fruit)) {
            score++;
            placeFruit();
        } else {
            snake.remove(snake.size() - 1);
        }
        snake.add(0, newHead);
    }

    private void placeFruit() {
        Random random = new Random();
        int x = random.nextInt(GRID_SIZE);
        int y = random.nextInt(GRID_SIZE);
        fruit = new Point(x, y);
    }

    public List<Point> getSnake() {
        return snake;
    }

    public Point getFruit() {
        return fruit;
    }

    public int getScore() {
        return score;
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}


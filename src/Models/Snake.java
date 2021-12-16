package Models;

import Enums.BodyPart;
import Enums.Direction;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

    private static final int INITIAL_POSITION = 100;
    private static final int NODE_SIZE = 20;
    private ArrayList<SnakeBody> snake;

    public Snake() {
        this.snake = new ArrayList<>();
        this.snake.add(new SnakeBody(INITIAL_POSITION, INITIAL_POSITION, BodyPart.HEAD, Direction.RIGHT));
        this.snake.add(new SnakeBody(INITIAL_POSITION - NODE_SIZE, INITIAL_POSITION, BodyPart.BODY, Direction.RIGHT));
        this.snake.add(new SnakeBody(INITIAL_POSITION - (NODE_SIZE * 2), INITIAL_POSITION, BodyPart.TAIL, Direction.RIGHT));
    }

    public void crescerSnake() {
        SnakeBody body = (SnakeBody) this.snake.get(this.snake.size() - 1);
        this.snake.get(this.snake.size() - 1).setBodyPart(BodyPart.BODY);
        this.snake.add(new SnakeBody(body.getX(), body.getY(), BodyPart.TAIL, body.getDirection()));
    }

    public void desenhar(Graphics g) {
        this.snake.forEach(n -> {
            n.Draw(g);
        });
    }

    public void atualizar(Direction direction) {
        for (int i = this.snake.size() - 1; i > 0; i--) {
            this.UpdatePosition(i);
        }

        switch (direction) {
            case UP:
                this.TurnUp();
                break;
            case DOWN:
                this.TurnDown();
                break;
            case LEFT:
                this.TurnLeft();
                break;
            case RIGHT:
                this.TurnRight();
                break;
        }
        this.snake.get(this.snake.size() - 1).setDirection(this.snake.get(this.snake.size() - 2).getDirection());
    }

    public ArrayList<SnakeBody> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<SnakeBody> snake) {
        this.snake = snake;
    }

    private void UpdatePosition(int index) {
        this.snake.get(index).Move(this.snake.get(index - 1).getX(), this.snake.get(index - 1).getY());
        this.snake.get(index).setDirection(this.snake.get(index - 1).getDirection());
    }

    private void TurnUp() {
        this.snake.get(0).setY(this.snake.get(0).getY() - Node.SIZE);
        this.snake.get(0).setDirection(Direction.UP);
        if (this.snake.get(1).getDirection() == Direction.LEFT && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.DOWN_RIGHT);
        } else if (this.snake.get(1).getDirection() == Direction.RIGHT && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.UP_RIGHT);
        }
    }

    private void TurnDown() {
        this.snake.get(0).setY(this.snake.get(0).getY() + Node.SIZE);
        this.snake.get(0).setDirection(Direction.DOWN);
        if (this.snake.get(1).getDirection() == Direction.LEFT && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.DOWN_LEFT);
        } else if (this.snake.get(1).getDirection() == Direction.RIGHT && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.UP_LEFT);
        }
    }

    private void TurnLeft() {
        this.snake.get(0).setX(this.snake.get(0).getX() - Node.SIZE);
        this.snake.get(0).setDirection(Direction.LEFT);
        if (this.snake.get(1).getDirection() == Direction.UP && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.UP_LEFT);
        } else if (this.snake.get(1).getDirection() == Direction.DOWN && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.UP_RIGHT);
        }
    }

    private void TurnRight() {
        this.snake.get(0).setX(this.snake.get(0).getX() + Node.SIZE);
        this.snake.get(0).setDirection(Direction.RIGHT);
        if (this.snake.get(1).getDirection() == Direction.UP && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.DOWN_LEFT);
        } else if (this.snake.get(1).getDirection() == Direction.DOWN && this.snake.get(1).getBodyPart() == BodyPart.BODY) {
            this.snake.get(1).setDirection(Direction.DOWN_RIGHT);
        }
    }
}

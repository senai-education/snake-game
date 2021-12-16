package Models;

import Enums.BodyPart;
import Enums.Direction;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SnakeBody extends Node {

    public SnakeBody(int x, int y, BodyPart bodyPart, Direction direction) {
        super(x, y);
        this.bodyPart = bodyPart;
        this.direction = direction;
    }

    private BodyPart bodyPart;
    private Direction direction;

    @Override
    public void Draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawImage(new ImageIcon(this.ChooseImage(bodyPart, direction)).getImage(), getX(), getY(), Node.SIZE, Node.SIZE, null);
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private String ChooseImage(BodyPart bodyPart, Direction direction) {
        String urlImage = "src/Assets/";

        if (bodyPart == BodyPart.HEAD) {
            switch (direction) {
                case UP:
                    urlImage += "head_up.png";
                    break;
                case DOWN:
                    urlImage += "head_down.png";
                    break;
                case RIGHT:
                    urlImage += "head_right.png";
                    break;
                case LEFT:
                    urlImage += "head_left.png";
                    break;
                default:
                    urlImage += "body_horizontal.png";
            }
        } else if (bodyPart == BodyPart.BODY) {
            switch (direction) {
                case DOWN:
                case UP:
                    urlImage += "body_vertical.png";
                    break;
                case LEFT:
                case RIGHT:
                    urlImage += "body_horizontal.png";
                    break;
                case DOWN_LEFT:
                    urlImage += "down_left.png";
                    break;
                case DOWN_RIGHT:
                    urlImage += "down_right.png";
                    break;
                case UP_LEFT:
                    urlImage += "up_left.png";
                    break;
                case UP_RIGHT:
                    urlImage += "up_right.png";
                    break;
            }
        } else {
            switch (direction) {
                case UP:
                    urlImage += "tail_top.png";
                    break;
                case DOWN:
                    urlImage += "tail_down.png";
                    break;
                case RIGHT:
                    urlImage += "tail_right.png";
                    break;
                case LEFT:
                    urlImage += "tail_left.png";
                    break;
                default:
                    urlImage += "tail_horizontal.png";
            }
        }
        return urlImage;
    }

}

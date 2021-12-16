package Models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;

public final class Target extends Node {

    private final ImageIcon apple;
    private static final int NODE_SIZE = 20;
    private static final int MAX_POSITION_X = 28;
    private static final int MAX_POSITION_Y = 20;

    public Target(int x, int y) {
        super(x, y);
        this.apple = new ImageIcon("src/Assets/comida.png");
        this.RandomlyPosition();
    }

    public void RandomlyPosition() {
        this.Move((new Random().nextInt(MAX_POSITION_X) + 1) * NODE_SIZE, (new Random().nextInt(MAX_POSITION_Y) + 1) * NODE_SIZE);
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(apple.getImage(), getX(), getY(), Node.SIZE, Node.SIZE, null);
        g.setColor(Color.BLACK);
    }

}

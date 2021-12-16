package Models;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Life extends Node {

    private final ImageIcon heart;

    public Life(int x, int y) {
        super(x, y);
        this.heart = new ImageIcon("src/Assets/vida.png");
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(heart.getImage(), getX(), getY(), Node.SIZE, Node.SIZE, null);
        g.setColor(Color.BLACK);
    }

}

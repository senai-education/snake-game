package Views;

import Models.Snake;
import Models.Target;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayableArea extends JPanel implements ActionListener {

    private final int NODE_SIZE = 20;

    private Snake snake;
    private final Timer timer;
    private final int velocidade;
    private final Target target;

    public PlayableArea() {
        this.snake = new Snake();
        this.target = new Target(0, 0);
        this.velocidade = 1000 / 300;
        this.timer = new Timer(velocidade, this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(112, 250, 133));
        g.fillRect(0, 0, 700, 500);
        getSnake().desenhar(g);
        target.Draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    public synchronized Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Timer getTimer() {
        return timer;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public Target getTarget() {
        return target;
    }

}

package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class ScoreboardGame extends JPanel {

    private static int score = 0;

    private JLabel scoreLabel;

    public ScoreboardGame() {
        this.setPreferredSize(new Dimension(30, 30));
        this.setLayout(null);
        this.addScoreInScoreboard();
    }

    private void addScoreInScoreboard() {
        this.scoreLabel = new JLabel("0");
        scoreLabel.setLocation(new Point(10, 10));
        scoreLabel.setPreferredSize(new Dimension(300, 18));
        scoreLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(15, 5, 100, 18);
        this.add(scoreLabel);
    }

    public void addScore() {
        score += 10;
        scoreLabel.setText("" + score);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(0, 128, 20));
        g.fillRect(0, 0, 660, 30);

    }

}

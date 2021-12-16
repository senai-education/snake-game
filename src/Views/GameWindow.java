package Views;

import Controllers.GameScreenController;
import java.awt.BorderLayout;
import java.awt.Color;

public class GameWindow extends BaseWindow {

    public PlayableArea playableArea;
    public GameScreenController controle;
    public ScoreboardGame scoreboardGame;

    public GameWindow() {
        super();
        this.setSize(667, 565);

        this.mountInterfaceGame();
        controle = new GameScreenController(this);
        addKeyListener(controle);
        setVisible(true);
        controle.Start();
    }

    private void mountInterfaceGame() {
        this.setLayout(new BorderLayout());
        playableArea = new PlayableArea();
        playableArea.setBackground(Color.red);
        playableArea.setBounds(15, 30, 622, 481);
        this.add(playableArea, BorderLayout.CENTER);
        scoreboardGame = new ScoreboardGame();
        this.setLayout(new BorderLayout());
        this.add(scoreboardGame, BorderLayout.NORTH);
        this.add(new BorderGame(), BorderLayout.SOUTH);
        this.add(new BorderGame(), BorderLayout.WEST);
        this.add(new BorderGame(), BorderLayout.EAST);
    }

    public PlayableArea getGamePanel() {
        return playableArea;
    }

    public void setGamePanel(PlayableArea gamePanel) {
        this.playableArea = gamePanel;
    }

}

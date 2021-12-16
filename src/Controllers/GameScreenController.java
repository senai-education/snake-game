package Controllers;

import Enums.Direction;
import Models.Node;
import Models.Snake;
import Views.GameWindow;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameScreenController implements KeyListener, Runnable {

    private static final int NODE_SIZE = 20;
    private static final int MAX_POSITION_X = 31;
    private static final int MAX_POSITION_Y = 24;

    public GameWindow tela;
    private Thread loop;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean pausado;

    public GameScreenController(GameWindow tela) {
        this.tela = tela;
        this.ConfiguracaoInicialDirecao();
        loop = new Thread(this);
    }

    public void Start() {
        pausado = false;
        this.tela.getGamePanel().getTimer().start();
        loop.start();
    }

    private void ConfiguracaoInicialDirecao() {
        up = false;
        down = false;
        left = false;
        right = true;
        pausado = true;
    }

    private void Restart() {
        this.tela.getGamePanel().setSnake(new Snake());
        tela.getGamePanel().getTimer().start();
        ConfiguracaoInicialDirecao();
        pausado = false;
        loop = new Thread(this);
        loop.start();
    }

    public void ScreenUpdate() {
        if (up) {
            this.tela.getGamePanel().getSnake().atualizar(Direction.UP);
        } else if (down) {
            this.tela.getGamePanel().getSnake().atualizar(Direction.DOWN);
        } else if (left) {
            this.tela.getGamePanel().getSnake().atualizar(Direction.LEFT);
        } else if (right) {
            this.tela.getGamePanel().getSnake().atualizar(Direction.RIGHT);
        }
    }

    private void CheckCollisionTarget(Node a, Node b) {
        if (a.getX() == b.getX() && a.getY() == b.getY()) {
            this.tela.getGamePanel().getSnake().crescerSnake();
            this.tela.getGamePanel().getTarget().RandomlyPosition();
            this.tela.scoreboardGame.addScore();
        }
    }

    private void CheckCollisionWall(Node a) {
        if (a.getX() < 0 || a.getX() == (MAX_POSITION_X * NODE_SIZE) || a.getY() < 0 || a.getY() == (MAX_POSITION_Y * NODE_SIZE)) {
            this.Stop();
            loop.interrupt();
        }
    }

    public void Stop() {
        pausado = true;
        tela.getGamePanel().getTimer().stop();
    }

    @Override
    public void run() {
        while (!pausado) {
            try {
                Thread.sleep(1000 / 5);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ScreenUpdate();
            CheckCollisionTarget(this.tela.playableArea.getSnake().getSnake().get(0), this.tela.getGamePanel().getTarget());
            CheckCollisionWall(this.tela.getGamePanel().getSnake().getSnake().get(0));
        }
    }

    @Override
    public void keyPressed(KeyEvent evento) {
        if (evento.getKeyCode() == KeyEvent.VK_UP && !down) {
            up = true;
            left = false;
            right = false;
        } else if (evento.getKeyCode() == KeyEvent.VK_DOWN && !up) {
            down = true;
            left = false;
            right = false;
        } else if (evento.getKeyCode() == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        } else if (evento.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        } else if (evento.getKeyCode() == KeyEvent.VK_R && pausado) {
            Restart();
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }
}

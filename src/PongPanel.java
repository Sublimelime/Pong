import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created on 11/17/2016, 2:13 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Pong
 */

public class PongPanel extends JPanel implements KeyListener, Runnable {
    BufferedImage buffer;
    private PongGame game;

    public PongPanel() {
        reset();
        addKeyListener(this);
        Thread thread = new Thread(this);
        thread.start();
        setSize(600, 600);
        Logger.logCodeMessage("Created panel, size is 600x600.");
    }

    void update() {
        game.update();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    void reset() {
        game = new PongGame();
    }
}

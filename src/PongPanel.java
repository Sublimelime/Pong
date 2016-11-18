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
        if (e.getKeyChar() == 'n')
            reset();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                //move left paddle up
                break;
            case 's':
                //move left paddle down
                break;
            case 'i':
                //move right paddle up
                break;
            case 'k':
                //move right paddle down
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed(e); //will do same as pressed
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(35);
            } catch (Exception e) {
                System.err.println("Error Sleeping.");
                Logger.logErrorMessage("Error Sleeping Thread.");
            }
        }
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    void reset() {
        game = new PongGame();
    }
}

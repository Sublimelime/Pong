import java.awt.*;

/**
 * Created on 11/17/2016, 2:26 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Pong
 */

public class Paddle {

    public static final int WIDTH = 10, HEIGHT = 70;
    private boolean upPressed, downPressed;
    private double x, y, speed;
    private Rectangle rect;
    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        rect = new Rectangle(x, y);
    }

    void update() {
        if (upPressed)
            setY(getY() - 10);
        else if (downPressed)
            setY(getY() + 10);
    }

    public Rectangle getRect() {
        return rect;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        updateRectangle();
    }

    private void updateRectangle() {
        rect.setLocation((int) x, (int) y);
    }
}

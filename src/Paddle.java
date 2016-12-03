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
    private double x, y, speed, middle;
    private Rectangle rect;
    private Color color;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        rect = new Rectangle(x, y, WIDTH, HEIGHT);
        middle = y + (HEIGHT / 2);
        this.color = Color.white;
    }

    void update() {
        if (upPressed)
            setY(getY() - 5);
        else if (downPressed)
            setY(getY() + 5);
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

    public double getMiddle() {
        return middle;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        if (y < 20)
            this.y = 20;
        if (y > 410)
            this.y = 410;
        updateRectangle();
        middle = y + (HEIGHT / 2);
    }

    private void updateRectangle() {
        rect.setLocation((int) x, (int) y);
    }

    public Color getColor() {
        return color;
    }

    public void setRandomColor() {
        int r, g, b;
        do {
            r = (int) (Math.random() * 255);
            g = (int) (Math.random() * 255);
            b = (int) (Math.random() * 255);
        } while (r + b + g < 300);
        this.color = new Color(r, g, b);
    }

}

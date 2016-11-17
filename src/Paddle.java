/**
 * Created on 11/17/2016, 2:26 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Pong
 */

public class Paddle {

    static final int WIDTH = 10, HEIGHT = 30;
    boolean upPressed, downPressed;
    double x, y, speed;
    public Paddle(int x, int y) {

    }

    void update() {

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

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

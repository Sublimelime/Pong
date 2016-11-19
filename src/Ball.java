import java.awt.*;

/**
 * Created on 11/17/2016, 2:28 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Pong
 */

public class Ball {

    static final double MAX_SPEED = 0; //todo set to more proper value
    static final int WIDTH = 10, HEIGHT = 10;
    private double x, y, speed, angle;
    private Rectangle rect;
    public Ball(int x, int y) {
        this.y = y;
        this.x = x;
        rect = new Rectangle(x, y);
        this.angle = (int) (Math.random()) * 180;
    }

    public Rectangle getRect() {
        return rect;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        updateRectangle();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        updateRectangle();
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    private void updateRectangle() {
        rect.setLocation((int) x, (int) y);
    }

}

import java.awt.*;

/**
 * Created on 11/17/2016, 2:28 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Pong
 */

public class Ball {

    public static final double SPEED_GAIN = 0.5;
    static final int WIDTH = 10, HEIGHT = 10;
    private static final double MAX_SPEED = 8;
    public static Color COLOR = Color.white;
    private double x, y, speed, angle, middle, oldX, oldY;
    private Rectangle rect;

    public Ball(int x, int y) {
        this.y = y;
        this.x = x;
        rect = new Rectangle(x, y, WIDTH, HEIGHT);
        this.speed = 3;
        double tempAngle = Math.random();
        if (tempAngle > 0.5)
            angle = 180;
        else
            angle = 0;
        middle = y + (HEIGHT / 2);
        Logger.logCodeMessage("Ball created at " + x + "," + y);
    }

    public static void changeColor() {
        int r, g, b;
        do {
            r = (int) (Math.random() * 255);
            g = (int) (Math.random() * 255);
            b = (int) (Math.random() * 255);
        } while (r + b + g < 300);
        COLOR = new Color(r, g, b);
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

    public double getOldX() {
        return oldX;
    }

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    public double getMiddle() {
        return middle;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        updateRectangle();
        middle = y + (HEIGHT / 2);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        if (this.speed > MAX_SPEED) //prevent going over max speed
            this.speed = MAX_SPEED;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle % 360;
    }

    private void updateRectangle() {
        rect.setLocation((int) x, (int) y);
    }

}

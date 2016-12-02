/**
 * Created on 11/17/2016, 2:17 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Pong
 */

public class PongGame {
    public static final int PLAYING = 0, PLAYER1_WINS = 1, PLAYER2_WINS = 2;
    private Paddle p1, p2;
    private Ball ball;
    private int status, player1Score, player2Score;

    public PongGame() {
        p1 = new Paddle(20, 250);
        p2 = new Paddle(570, 250);
        ball = new Ball(300, 250);
        status = PLAYING;
        player1Score = 0;
        player2Score = 0;
    }

    void update() {
        //scoring
        if (ball.getX() <= 0) { //player on the right scored a point
            player2Score++;
            ball = new Ball(300, 250);
        } else if (ball.getX() >= 600) { //player on the left scored a point
            player1Score++;
            ball = new Ball(300, 250);
        }
        //updates
        moveBall(ball.getSpeed());
        p1.update(); //update the paddles
        p2.update();
        //win display
        if (status == PLAYER1_WINS) {
            player2Score = 0;
            player1Score = 0;
            Logger.logUserMessage("Player 1 won.");
            Logger.messageWindow("Player 1 Won. Press OK to restart.");
        } else if (status == PLAYER2_WINS) {
            player2Score = 0;
            player1Score = 0;
            Logger.logUserMessage("Player 2 won.");
            Logger.messageWindow("Player 2 Won. Press OK to restart.");
        }
        //bouncing
        if (hitLeftPaddle()) {
            Ball.changeColor();
            p1.setRandomColor();
            //do bounce
            double hitX = p1.getX() + Paddle.WIDTH, hitY;
            double deltaXToHit = hitX - ball.getOldX();
            double percentXUsed = deltaXToHit / (ball.getOldX() - ball.getY());
            double deltaYToHit = (ball.getOldY() - ball.getY()) * percentXUsed;
            hitY = ball.getOldY() + deltaYToHit;
            ball.setX(hitX); //move the ball back to the calculated hit point
            ball.setY(hitY);
            //fix angle
            double percentFromMid = Math.abs((hitY + Ball.HEIGHT / 2) - (p1.getY() + Paddle.HEIGHT / 2)) / 45;

            if (ball.getMiddle() == p1.getMiddle()) {
                ball.setAngle(0);
            } else if (ball.getMiddle() < p1.getMiddle()) {
                ball.setAngle(360 - (percentFromMid * 85));
            } else
                ball.setAngle(percentFromMid * 85);

            ball.setSpeed(ball.getSpeed() + Ball.SPEED_GAIN); //up the speed with every bounce
        } else if (hitRightPaddle()) {
            Ball.changeColor();
            p2.setRandomColor();

            ball.setAngle(180);
            ball.setSpeed(ball.getSpeed() + Ball.SPEED_GAIN); //up the speed with every bounce
        } else if (hitBottomWall()) {
            Ball.changeColor();
            double hitY = 470, hitX;
            double deltaYToHit = hitY - ball.getOldY();
            double percentYUsed = deltaYToHit / (ball.getOldY() - ball.getY());

            double deltaXToHit = (ball.getOldX() - ball.getX()) * percentYUsed;
            hitX = ball.getOldX() + deltaXToHit;
            ball.setX(hitX); //move the ball back to the calculated hit point
            ball.setY(hitY);

            ball.setAngle(-ball.getAngle()); //fix angle

            ball.setSpeed(ball.getSpeed() + Ball.SPEED_GAIN); //up the speed with every bounce
        } else if (hitTopWall()) {
            Ball.changeColor();
            double hitY = 20, hitX;
            double deltaYToHit = hitY - ball.getOldY();
            double percentYUsed = deltaYToHit / (ball.getOldY() - ball.getY());

            double deltaXToHit = (ball.getOldX() - ball.getX()) * percentYUsed;
            hitX = ball.getOldX() + deltaXToHit;
            ball.setX(hitX); //move the ball back to the calculated hit point
            ball.setY(hitY);
            ball.setAngle(-ball.getAngle()); //fix angle

            ball.setSpeed(ball.getSpeed() + Ball.SPEED_GAIN); //up the speed with every bounce
        }

    }

    int status() {
        return status;
    }

    public Paddle getP1() {
        return p1;
    }

    public Paddle getP2() {
        return p2;
    }

    public Ball getBall() {
        return ball;
    }

    void moveBall(double distance) {
        ball.setOldX(ball.getX());
        ball.setOldY(ball.getY());
        ball.setX(ball.getX() + Math.cos(Math.toRadians(ball.getAngle())) * distance);
        ball.setY(ball.getY() + Math.sin(Math.toRadians(ball.getAngle())) * distance);
    }

    int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    private boolean hitTopWall() {
        return ball.getY() <= 20;
    }

    private boolean hitBottomWall() {
        return ball.getY() + Ball.HEIGHT >= 480;
    }

    private boolean hitLeftPaddle() {
        return ball.getRect().intersects(p1.getRect());
    }

    private boolean hitRightPaddle() {
        return ball.getRect().intersects(p2.getRect());
    }

    private double distance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

}

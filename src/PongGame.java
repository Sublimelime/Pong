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
        double halfHeight = p1.getMiddle() - p1.getY();
        if (hitLeftPaddle()) {
            if (ball.getMiddle() == p1.getMiddle()) { //if hit exact centre
                ball.setAngle(0);
            } else if (ball.getMiddle() < p1.getMiddle()) { //if hit top section
                double paddleContactX = p1.getX() + Paddle.WIDTH;
                if (ball.getX() <= paddleContactX) {
                    double calculatedY = 0; //todo -help
                    double tempDistance = Math.sqrt(Math.pow((paddleContactX - ball.getOldX()), 2) +
                            Math.pow((calculatedY - ball.getOldY()), 2));
                }
                //correct the ball's angle
                ball.setAngle(360 - ((p1.getMiddle() - ball.getMiddle()) / (halfHeight) * 90) * 80);
                ball.setSpeed(ball.getSpeed() + Ball.SPEED_GAIN); //up the speed with every bounce
            } else { //hit bottom section

            }
        } else if (hitRightPaddle()) {
            if (ball.getMiddle() == p2.getMiddle()) {
                ball.setAngle(180);
            }

            ball.setSpeed(ball.getSpeed() + Ball.SPEED_GAIN); //up the speed with every bounce
        } else if (hitBottomWall()) {
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

}

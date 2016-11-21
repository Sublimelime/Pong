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
        if (ball.getX() <= 0) { //player on the right scored a point
            player2Score++;
            ball = new Ball(300, 250);
        } else if (ball.getX() >= 600) { //player on the left scored a point
            player1Score++;
            ball = new Ball(300, 250);
        }
        moveBall(ball.getSpeed());
        p1.update(); //update the paddles
        p2.update();
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
        ball.setX(ball.getX() + Math.cos(Math.toRadians(ball.getAngle())) * distance);
        ball.setY(ball.getY() + Math.sin(Math.toRadians(ball.getAngle())) * distance);
    }

    int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    boolean hitTopWall() {
        return ball.getY() <= 20;
    }

    boolean hitBottomWall() {
        return ball.getY() >= 480;
    }

    boolean hitLeftPaddle() {
        return ball.getRect().intersects(p1.getRect());
    }

    boolean hitRightPaddle() {
        return ball.getRect().intersects(p2.getRect());
    }

}

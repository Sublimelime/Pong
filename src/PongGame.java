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
        moveBall(1); //todo proper distance? -help
        p1.update(); //update the paddles
        p2.update();
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

    }

    int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    boolean hitTopWall() {
        return false;
    }

    boolean hitBottomWall() {
        return false;
    }

    boolean hitLeftPaddle() {
        return false;
    }

    boolean hitRightPaddle() {
        return false;
    }

}

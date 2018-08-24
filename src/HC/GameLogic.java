package HC;

public class GameLogic {


    double width =  1.0;
    double height = 1.0;
    double ballSpeed = width/100 , ballRadius =width/40;
    int tickCount = 0;

    double rocketV;
    double rocketX, rocketY, ballX, ballY;
    double rocketW =width/4,dy= ballSpeed,dx= ballSpeed;

    public GameLogic(double rocketX, double rocketY, double ballX, double ballY) {
        this.rocketX = rocketX;
        this.rocketY = rocketY;
        this.ballX = ballX;
        this.ballY = ballY;
    }

    public GameLogic(double rocketX, double rocketY, double ballX, double ballY, double rocketW, double dy, double dx)
    {
        this.rocketX = rocketX;
        this.rocketY = rocketY;
        this.ballX = ballX;
        this.ballY = ballY;
        this.rocketW = rocketW;
        this.dy = dy;
        this.dx = dx;
    }

    public double getRocketW() {
        return rocketW /width;
    }




    public double getRocketX() {
        return rocketX /width;
    }

    public double getRocketY() {
        return rocketY /height;
    }

    public double getBallX() {
        return ballX /width;
    }

    public double getBallY() {
        return ballY /height;
    }

    public double getDy() {
        return dy/height;
    }

    public double getDx() {
        return dx/width;
    }

    int tick()
    {
        tickCount++;
        if(ballX + ballRadius > width   || ballX - ballRadius < 0)
        {
            dx *=-1;
        }
        if( ballY - ballRadius < 0 ||
                (ballX >= rocketX && ballX < (rocketX + rocketW) && ballY + ballRadius > rocketY && ballY < rocketY) )
        {
            dy *=-1;
        }

        ballX +=dx;
        ballY +=dy;
        rocketX += rocketV;

        if(rocketX < 0 )
            rocketX = 0;
        if(rocketX + rocketW > width )
            rocketX = (width - rocketW);

        if(ballY + ballRadius > height)
            return tickCount;

        return -1;
    }

    public double getRocketV() {
        return rocketV;
    }

    public void setRocketV(double rocketV) {
        this.rocketV = Math.min(Math.abs(dx), rocketV);
        this.rocketV = Math.max(-Math.abs(dx),this.rocketV);


    }
}

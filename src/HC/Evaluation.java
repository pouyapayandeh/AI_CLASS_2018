package HC;

public class Evaluation
{
    Model m;

    public Evaluation(Model m)
    {
        this.m = m;
    }
    public  double evaluate()
    {
        double score = 0.0;
        score += singleGame(0.5,0.8,0.1,0.2,1.0/8.0,0.01,0.01);
        score += singleGame(0.5,0.8,0.1,0.2,1.0/8.0,-0.01,0.01);
        score += singleGame(0.5,0.8,0.1,0.2,1.0/8.0,-0.01,-0.01);
        score += singleGame(0.5,0.8,0.1,0.2,1.0/8.0,0.01,-0.01);
        return score/4;
    }
    private double singleGame(double rocketX, double rocketY, double ballX, double ballY, double rocketW, double dy, double dx)
    {
        GameLogic gameLogic = new GameLogic(rocketX,  rocketY,  ballX,  ballY,  rocketW,  dy,  dx);
        while (gameLogic.tick() < 0)
        {
            double v = m.execute(gameLogic.getBallX(), gameLogic.getBallY(), gameLogic.getDx(), gameLogic.getDy(), gameLogic.getRocketX());
            gameLogic.setRocketV(v);
            if(gameLogic.tickCount > 1000000)
                break;
        }
        return gameLogic.tickCount;
    }
    private double singleGame(double rocketX, double rocketY, double ballX, double ballY)
    {
        return singleGame(rocketX,  rocketY,  ballX,  ballY,1.0/4.0,0.01,0.01);
    }
}

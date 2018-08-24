package HC;

import processing.core.PApplet;

/**
 * Created by pouya on 8/13/18.
 */
public class Main extends PApplet {
    private static Model model;

    @Override
    public void settings() {
        size(400,400,P2D);

    }
    GameLogic gameLogic = new GameLogic(0.5,0.8,0.1,0.2,1.0/8.0,0.01,0.01);
    @Override
    public void setup() {
        super.setup();
        surface.setTitle("Demo");
    }
    @Override
    public void draw() {
        double v = model.execute(gameLogic.getBallX(), gameLogic.getBallY(), gameLogic.getDx(), gameLogic.getDy(), gameLogic.getRocketX());
        gameLogic.setRocketV(v);
        int r = gameLogic.tick();
        if (r > 0)
            exit();
        background(255);
        fill(100,0,0);
        ellipse(gameLogic.getBallX()*width,gameLogic.getBallY()*height,gameLogic.ballRadius *width*2,gameLogic.ballRadius *width*2);

        fill(0,0,255);
        rect(gameLogic.getRocketX()*width,gameLogic.getRocketY()*height,gameLogic.getRocketW()*width,3);
    }

    private void rect(double v, double v1, double v2, int v3)
    {
        rect((float)v,(float)v1,(float)v2,(float)v3);
    }

    private void ellipse(double v, double v1, double v2, double v3)
    {
        ellipse((float)v,(float)v1,(float)v2,(float)v3);
    }

    public static void main(String[] args) {
        HillClimbing hillClimbing = new HillClimbing();
        Main.model = hillClimbing.learn(10000);
        PApplet.main("HC.Main");
    }
}

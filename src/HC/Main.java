package HC;

import processing.core.PApplet;

/**
 * Created by pouya on 8/13/18.
 */
public class Main extends PApplet {
    @Override
    public void settings() {
        size(400,400,P2D);

    }
    GameLogic gameLogic = new GameLogic(300,300,40,10);
    @Override
    public void setup() {
        super.setup();
        surface.setTitle("Demo");
    }
    @Override
    public void draw() {
        int r = gameLogic.tick();
        if (r > 0)
            exit();
        background(255);
        fill(100,0,0);
        ellipse(gameLogic.getX()*width,gameLogic.getY()*height,gameLogic.R*2,gameLogic.R*2);

        fill(0,0,255);
        rect(gameLogic.getR_x()*width,gameLogic.getR_y()*height,gameLogic.getR_w()*width,20);
    }

    public static void main(String[] args) {
        PApplet.main("HC.Main");
    }
}

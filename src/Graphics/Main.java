package Graphics;

import processing.core.PApplet;

/**
 * Created by pouya on 8/13/18.
 */
public class Main extends PApplet {
    @Override
    public void settings() {
        size(400,400,P2D);

    }

    @Override
    public void setup() {
        super.setup();
        surface.setTitle("Demo");
    }

    int x = 70 , y =40;
    int dx = 1, dy =1;
    int R =15;
    int hy = 300;
    int hx = 20;
    int w = 40;
    @Override
    public void draw() {
        background(255);
        fill(100,0,0);
        ellipse(x,y,R*2,R*2);
        if(x + R> width   || x -R< 0)
        {
            dx *=-1;
        }
        if(y  + R > height   || y -R< 0)
        {
            dy *=-1;
        }
        x +=dx;
        y +=dy;
        fill(0,0,255);
        rect(hx,hy,w,20);
    }

    public static void main(String[] args) {
        PApplet.main("Graphics.Main");
    }
}

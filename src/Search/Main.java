package Search;

import processing.core.PApplet;

/**
 * Created by pouya on 8/13/18.
 */
public class Main extends PApplet {
    int[][] table={
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,1,0,1,0},
            {0,1,0,1,0},
            {0,0,0,0,0}
    };
    BFS searchAlgorithm = new BFS(new State(0,0),new State(2,2),10);
    private boolean flag = false;

    @Override
    public void settings() {
        size(400,400,P2D);

    }

    @Override
    public void setup() {
        super.setup();
        searchAlgorithm.setSuccessorFunction(new SuccessorFunction());
        surface.setTitle("Demo");
    }
    State s = null;
    @Override
    public void draw() {
        background(255);

        if(!flag)
            s = searchAlgorithm.iteration(table);
        drawTable(table);
        if(s != null || flag) {
            drawPath(s);
            flag = true;
        }
    }

    private void drawPath(State s) {
        float dW = width/table[0].length;
        float dH = height/table.length;
        State now = s;
        fill(0,0,100);
        while (now != null)
        {
            float pad = 1;
            rect(now.x*dW + pad,now.y*dH+ pad,dW- pad,dH- pad);
            now = now.parent;
        }
    }

    public void drawTable(int [][] table)
    {
        float dW = width/table[0].length;
        float dH = height/table.length;
        int pad = 2;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                fill(0,100,0);
                if(table[i][j]  == 1)
                    fill(100,0,0);
                rect(j*dW + pad,i*dH+ pad,dW- pad,dH- pad);
            }
        }
    }
    public static void main(String[] args) {
        PApplet.main("Search.Main");
    }
}

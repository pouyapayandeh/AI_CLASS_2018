package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pouya Payandeh on 8/29/2018.
 */

public class SuccessorFunction {
    public List<State> invoke(State now, int[]... table) {
        int[] moveX = {0 , 0,-1 ,1};
        int[] moveY = {1,-1,0,0};
        ArrayList<State> states = new ArrayList<>();
        for (int i = 0; i < moveX.length; i++) {
            State s = new State(now);
            s.x+=moveX[i];
            s.y+=moveY[i];
            if(s.x >= 0 && s.x < table[0].length)
            {
                if(s.y >= 0 && s.y < table.length)
                {
                    if(table[s.y][s.x] == 0)
                    {
                        s.parent = now;
                        s.depth = now.depth+1;
                        states.add(s);
                    }
                }
            }

        }
        return states;
    }
}

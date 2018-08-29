package Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Pouya Payandeh on 8/29/2018.
 */
public class DFS {
    State start,end;

    int depthMax;
    Stack<State> stack = new Stack<>();
    public DFS(State start, State end, int depthMax) {
        this.start = start;
        this.end = end;
        this.depthMax = depthMax;
        stack.push(start);
    }
    public State iteration(int [][] table)
    {
        if(!stack.empty())
        {
            State now = stack.pop();
            if(isGoal(now)) {
                System.out.println("Found Goal");
                return now;
            }
            if(now.depth < depthMax) {
                List<State> childs = successor(now, table);
                stack.addAll(childs);
            }
        }
        return null;
    }

    SuccessorFunction successorFunction;

    public SuccessorFunction getSuccessorFunction() {
        return successorFunction;
    }

    public void setSuccessorFunction(SuccessorFunction successorFunction) {
        this.successorFunction = successorFunction;
    }

    private List<State> successor(State now, int[][] table) {
        return successorFunction.invoke(now, table);
    }

    private boolean isGoal(State now) {
        return now.equals(end);
    }

}

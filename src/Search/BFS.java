package Search;

import java.util.*;

/**
 * Created by Pouya Payandeh on 8/29/2018.
 */
public class BFS {
    State start,end;

    int depthMax;
    Queue<State> queue =  new LinkedList<>();
//    Stack<State> stack = new Stack<>();
    public BFS(State start, State end, int depthMax) {
        this.start = start;
        this.end = end;
        this.depthMax = depthMax;
        queue.add(start);
//        stack.push(start);
    }
    public State iteration(int [][] table)
    {
        if(!queue.isEmpty())
        {
            State now = queue.poll();
            if(isGoal(now)) {
                System.out.println("Found Goal");
                return now;
            }
            if(now.depth < depthMax) {
                List<State> childs = successor(now, table);
                queue.addAll(childs);
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

package Search;

/**
 * Created by Pouya Payandeh on 8/29/2018.
 */
public class State {
    int x , y;
    State parent = null;
    int depth = 0;
    public State(int x, int y) {
        this.x = x;
        this.y = y;
        parent = null;
    }

    public State(State s) {
        this.x = s.x;
        this.y = s.y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (x != state.x) return false;
        return y == state.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

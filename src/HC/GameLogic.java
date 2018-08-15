package HC;

public class GameLogic {

    public static final int BALL_SPEED = 5,R=10;
    float width =  400;
    float height = 400;
    public GameLogic(int r_x, int r_y, int x, int y) {
        this.r_x = r_x;
        this.r_y = r_y;
        this.x = x;
        this.y = y;
    }

    public float getR_w() {
        return r_w/width;
    }


    int rocket_v;
    int r_x,r_y,x,y;
    int r_w=100,dy=BALL_SPEED,dx=BALL_SPEED;

    public float getR_x() {
        return r_x/width;
    }

    public float getR_y() {
        return r_y/height;
    }

    public float getX() {
        return x/width;
    }

    public float getY() {
        return y/height;
    }

    public float getDy() {
        return dy/height;
    }

    public float getDx() {
        return dx/width;
    }
    int tickCount = 0;
    int tick()
    {
        tickCount++;
        if(x + R> width   || x -R< 0)
        {
            dx *=-1;
        }
        if( y -R< 0 ||  (x >= r_x && x < (r_x + r_w) && y + R > r_y) )
        {
            dy *=-1;
        }

        x +=dx;
        y +=dy;
        r_x +=rocket_v;

        if(r_x < 0 )
            r_x = 0;
        if(r_x + r_w > width )
            r_x = (int) (width - r_w);

        if(y  + R > height)
            return tickCount;

        return -1;
    }

    public int getRocket_v() {
        return rocket_v;
    }

    public void setRocket_v(int rocket_v) {
        this.rocket_v = Math.min(Math.abs(dx),rocket_v);
        this.rocket_v = Math.max(-Math.abs(dx),this.rocket_v);


    }
}

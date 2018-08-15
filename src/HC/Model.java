package HC;

public class Model {
    float a[] ;

    public Model(float[] alpha) {
        this.a = alpha;
    }
    public float execute(float b_x,float b_y,float d_x,float d_y,float h_x)
    {
        return a[0]*b_x + a[1]*b_y + a[2]*d_x + a[3]*d_y + a[4]*h_x;
    }
}

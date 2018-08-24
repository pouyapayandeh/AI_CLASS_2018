package HC;

public class Model {
    double a[] ;

    public Model(double[] alpha) {
        this.a = alpha;
    }
    public double execute(double b_x,double b_y,double d_x,double d_y,double h_x)
    {
        return a[0]*b_x + a[1]*b_y + a[2]*d_x + a[3]*d_y + a[4]*h_x +a[5];
    }
}

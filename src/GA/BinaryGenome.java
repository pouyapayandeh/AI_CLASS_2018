package GA;

import java.util.Random;

/**
 * Created by pouya on 8/13/18.
 */
public class BinaryGenome implements Comparable<BinaryGenome>{
    int genome[];
    int size;
    float value;
    BinaryGenome(int size)
    {
        genome = new  int [size];
        this.size = size;
    }

    public BinaryGenome(int[] genome) {
        this.genome = genome;
        size = genome.length;
    }
    public static BinaryGenome[] crossover(BinaryGenome a , BinaryGenome b)
    {
        Random r = new Random();
        int cutPoint = r.nextInt(a.size);

        BinaryGenome ab = new BinaryGenome(a.size);
        BinaryGenome ba = new BinaryGenome(a.size);

        for (int i = 0; i < a.size; i++) {
            if (i < cutPoint)
            {
                ab.genome[i] = a.genome[i];
                ba.genome[i] = b.genome[i];
            }else
            {
                ba.genome[i] = a.genome[i];
                ab.genome[i] = b.genome[i];
            }
        }
        return new BinaryGenome[]{ab, ba};

    }
    public static BinaryGenome mutate(BinaryGenome a)
    {
        Random r = new Random();
        int g = r.nextInt(a.size);

        a.genome[g] = (a.genome[g] +1 )%2;
        return a;
    }

    public BinaryGenome copy()
    {
        BinaryGenome a = new BinaryGenome(size);
        a.genome = genome.clone();
        return a;
    }

    @Override
    public int compareTo(BinaryGenome o) {
        return (int) Math.signum(value - o.value);
    }
}

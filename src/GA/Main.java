package GA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by pouya on 8/13/18.
 */
public class Main {
    public static void main(String[] args) {
        int popSize = 1000;
        int genomeSize = 8;
        List<BinaryGenome> genomes = new ArrayList<>();
        //INITITALIZE

        for (int i = 0; i < popSize; i++) {
            genomes.add(randomGenome(genomeSize));
        }

        //Generations
        for (int generation = 0; generation < 5000; generation++) {

            for (int i = 0; i < genomes.size(); i++) {
                BinaryGenome bg = genomes.get(i);
                bg.value = (float) Evaluate(bg.genome);
            }
            Collections.sort(genomes);
            System.out.printf("Generatio %d : %d \n",generation,binaryToDecimal(genomes.get(0).genome));

            genomes = new ArrayList<>(genomes.subList(0,popSize));
            int s = genomes.size();
            for (int i = 0; i < s; i+=2) {
                BinaryGenome[] g = BinaryGenome.crossover(genomes.get(i), genomes.get(i + 1));
                genomes.add(g[0]);
                genomes.add(g[1]);
            }
            Random r = new Random();
            s = genomes.size();
            for (int i = 0; i <s; i++) {
                if (r.nextDouble() > 0.5)
                {
                    genomes.add(BinaryGenome.mutate(genomes.get(i)));
                }
            }

        }
    }

    private static double Evaluate(int[] genome) {
        int v = 0;
        v = binaryToDecimal(genome);
        return Math.pow(v,3)-4*Math.pow(v,2)-v;
    }

    private static int binaryToDecimal(int[] genome) {
        int v = 0;
        int p= 1;
        for (int i = 0; i < genome.length ; i++) {
            v += genome[i]*p;
            p*=2;
        }
        return v;
    }

    public static BinaryGenome randomGenome(int genomeSize)
    {
        Random random = new Random();
        BinaryGenome r = new BinaryGenome(genomeSize);
        for (int i = 0; i < genomeSize; i++) {
            r.genome[i] = random.nextInt(2);
        }
        return r;
    }
}

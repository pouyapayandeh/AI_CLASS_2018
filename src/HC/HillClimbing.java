package HC;

import java.util.Arrays;

public class HillClimbing
{
    double step = 1;

    Model learn(int epochs)
    {
        double[] a = new double[6];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = Math.random() - 0.5;
        }
        Model m = new Model(a);
        double globalScore = 0.0;
        Model globalModel = m;
        double previousScore =0.0;

        for (int epoch = 0; epoch < epochs; epoch++)
        {
            System.out.println("Epoch : " + epoch);
            double maxScore = 0.0;
            Model maxModel = m;

            for (int i = -1; i < 2; i++)
            {
                for (int j = 0; j < a.length; j++)
                {
                    Model mNew = new Model(m.a.clone());
                    mNew.a[j] += i * step;
                    Evaluation e = new Evaluation(mNew);
                    double score = e.evaluate();

                    if (score > maxScore)
                    {
                        maxScore = score;
                        maxModel = mNew;
                    }
                }
            }

            if(maxScore <= previousScore)
            {
                for (int i = 0; i < a.length; i++)
                {
                    a[i] = Math.random() - 0.5;
                }
                 m = new Model(a);
                previousScore=0.0;
               // System.out.printf("Restart with %f and %s\n",maxScore,Arrays.toString(m.a));
            }
            else
            {
                previousScore = maxScore;
                m = maxModel;

                System.out.printf("Climbing with %f and %s\n",maxScore,Arrays.toString(m.a));
            }

            if(maxScore > globalScore)
            {
                globalScore = maxScore;
                globalModel = maxModel;
                System.out.printf("New Global Max with %f and %s\n",globalScore,Arrays.toString(globalModel.a));
            }
        }
        System.out.printf("Global Max with %f and %s\n",globalScore,Arrays.toString(globalModel.a));
        return  globalModel;
    }
}

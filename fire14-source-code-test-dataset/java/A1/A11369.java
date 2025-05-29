import java.util.*;

public class Dance
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int numCase;
        numCase = input.nextInt();
        for(int n=0; n<numCase; n++)
        {
            int numGoog, surprising, min, maxAboveMin;
            maxAboveMin = 0;

            numGoog = input.nextInt();
            surprising = input.nextInt();
            min = input.nextInt();

            int[] scores = new int[numGoog];
            int[] bestIfS = new int[numGoog];
            int[] bestIfNS = new int[numGoog];
            for(int i=0; i<numGoog; i++)
            {
                scores[i] = input.nextInt();
                if(scores[i]>0)
                {
                    bestIfS[i] = (int)((double)scores[i]/3+1.5);
                    bestIfNS[i] = (int)((double)scores[i]/3+0.7); // Rounding
                } else {
                    bestIfS[i] = 0;
                    bestIfNS[i] = 0;
                }

                /*
                 *System.out.printf("S:%d !:%d N:%d\n",scores[i]
                 *                                     bestIfS[i],
                 *                                     bestIfNS[i]);
                 */
            }

            for(int i=0; i<numGoog; i++)
            {
                if(bestIfNS[i]>=min) { maxAboveMin++; }
                else if (surprising>0 && bestIfS[i]>=min)
                {
                    maxAboveMin++;
                    surprising--;
                }
            }

            System.out.printf("Case #%d: %d\n",n+1,maxAboveMin);

        }
    }
}

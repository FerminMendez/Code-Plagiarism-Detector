package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        sc.nextLine(); // input size
        int cases = 0;
        while(sc.hasNext())
        {
            String line = sc.nextLine();
            String[] vals = line.split(" ");
            int googlerCount = Integer.parseInt(vals[0]);
            int maxSupriseCount = Integer.parseInt(vals[1]);
            int limit = Integer.parseInt(vals[2]);
            int[] scores = new int[vals.length - 3];
            for(int i = 0; i < vals.length - 3; i++)
            {
                scores[i] = Integer.parseInt(vals[i+3]);
            }

            int output = 0;
            int supriseCount = 0;
            for(int score : scores)
            {
                if (score == 0 && limit > 0) {
                    continue;
                }
                double avg = score / 3d;
                if (avg >= limit)
                {
                    output++;
                }
                else if (limit - avg < 1) {
                    output++;
                }
                else if (limit - avg < 1.5) {
                    if (supriseCount < maxSupriseCount) {
                        supriseCount++;
                        output++;
                    }
                }
            }
            System.out.println("Case #" + ++cases + ": " + output);
            
        }
    }
}

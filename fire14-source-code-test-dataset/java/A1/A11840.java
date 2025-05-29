
import java.util.Scanner;


/**
 *
 * @author Daniel Sheng
 */
public class Dancing
{
    private final static int NUM_JUDGES = 3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int lns = Integer.parseInt(in.nextLine());
        
        for(int ln = 0; ln < lns; ln++)
        {
            String[] tokens = in.nextLine().split("\\s+");
            
            int numDancers = Integer.parseInt(tokens[0]),
                numSurprising = Integer.parseInt(tokens[1]),
                targetBestScore = Integer.parseInt(tokens[2]);
            
            int result = 0;
            
            for(int i = 0; i < numDancers; i++)
            {
                int score = Integer.parseInt(tokens[i + 3]);
                if(score >= targetBestScore * NUM_JUDGES - 2)
                    result++;
                else if(score >= targetBestScore * NUM_JUDGES - 4 && numSurprising > 0 && targetBestScore - 2 >= 0)
                {
                    result++;
                    numSurprising--;
                }
            }
            
            System.out.println("Case #" + (ln + 1) + ": " + result);
        }
    }
}

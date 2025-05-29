import java.io.*;
import java.util.*;

class Dancing
{
    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File(args[0]));

        int numTests = s.nextInt();

        for (int i = 1; i <= numTests; i++)
        {
            // Get rid of prepending newline.
            s.nextLine();

            int count = 0;

            int N = s.nextInt();
            int S = s.nextInt();
            int p = s.nextInt();

            for (int j = 0; j < N; j++)
            {
                int t = s.nextInt();
                int a = t / 3 + ((t % 3 == 0) ? 0 : 1);
                
                if (a >= p)
                {
                    count++;
                }
                else if (a == p-1 && S > 0 && t > 1 && t % 3 != 1)
                {
                    count++;
                    S--;
                }
            }

            System.out.println("Case #" + i + ": " + count);
        }
    }
}

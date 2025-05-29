import java.io.*;
import java.util.*;

class Recycled
{
    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File(args[0]));

        int numTests = s.nextInt();

        for (int i = 1; i <= numTests; i++)
        {
            // Clear the trailing newline on this line.
            s.nextLine();

            int A = s.nextInt();
            int B = s.nextInt();
            int L = (""+A).length()-1;
            int E = (int)Math.pow(10, L);

            int count = 0;
            List<Integer> seen = new ArrayList<Integer>(L);
            for (int j = A; j < B; j++)
            {
                int curr = j;
                for (int k = 0; k < L; k++)
                {
                    curr = (curr / 10) + (curr % 10) * E;
                    if (curr > j && curr <= B && !seen.contains(curr))
                    {
                        count++;
                        seen.add(curr);
                    }
                }

                seen.clear();
            }

            System.out.println("Case #" + i + ": " + count);
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;

public class DG {

    public static void main (String[] args) throws Exception
    {

		BufferedReader sr = new BufferedReader(new FileReader("c:\\Projects\\DG.txt"));

		int total = Integer.parseInt(sr.readLine());

        for (int i=0; i<total; i++)
        {
            String[] tokens = sr.readLine().split(" ");
            int N = Integer.parseInt (tokens[0]);
            int S = Integer.parseInt (tokens[1]);
            int p = Integer.parseInt (tokens[2]);

            int[] scores = new int[N];
            for (int j=0; j<N; j++)
                scores[j] = Integer.parseInt (tokens[j+3]);

            solve (i+1, S, p, scores);
        }
    }


    private static void solve (int c, int S, int p, int[] scores)
    {
        int remaining = S;
        int total = 0;
        for (int i=0; i<scores.length; i++)
        {
            int base = scores[i] / 3;
            int add  = scores[i] % 3;

            if (add == 2)
            {
                
                if ((base+1)>=p)
                    total++;
                else
                {
					//it could be a surprising one
                    if ((base+2)>=p &&
                        remaining >0)
                    {
                        total++;
                        remaining--;
                    }
                }
            }
            else
                if (add == 0)
                {
                    if (base >= p)
                        total++;
                    else
                    {
						//it could be surprising as well
                        if ((base+1) >= p &&
                            remaining > 0 &&
                            base > 0)
                        {
                            total++;
                            remaining--;
                        }
                    }
                }
                    else
                    {
                        if ((base+add)>=p)
                            total++;
                    }
        }

        System.out.printf ("Case #%d: %d\n", c, total);
    }
}

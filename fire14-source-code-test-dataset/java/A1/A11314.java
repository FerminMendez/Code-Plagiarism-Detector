import java.io.*;
import java.util.*;

public class Sample
{
    public static void main(String []args) throws IOException
    {
        BufferedReader con = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out = new BufferedWriter (new FileWriter("output.txt"));
        //Console con = System.console();
        int T = Integer.parseInt(con.readLine());
        String input;

        for(int i=1; i<=T; i++)
        {
            input = con.readLine();
            StringTokenizer list = new StringTokenizer(input);
            int N = Integer.parseInt(list.nextToken()); // No. of googlers
            int S = Integer.parseInt(list.nextToken()); // No. of surprising triplets
            int p = Integer.parseInt(list.nextToken()); // maximum score

            int score,
                output = 0;

            for(int j=0; j<N; j++)
            {
                score = Integer.parseInt(list.nextToken()); // Total score
                if(score >= 3*p-2)
                    output++;
                else
                    if(S>0 && score>1 && score>=3*p-4)
                    {
                        S--;
                        output++;
                    }
            }
            out.write("Case #"+i+": "+output);
            out.newLine();
        }
        con.close();
        out.close();
    }
}

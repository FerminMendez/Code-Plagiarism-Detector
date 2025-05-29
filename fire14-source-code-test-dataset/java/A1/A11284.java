import java.util.*;
import java.io.*;

public class P2
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(new FileReader("B-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        
        int cases = Integer.parseInt(sc.nextLine());
        int c = 0, temp = 0, us = 0;
        
        for (int i = 0; i < cases; i++)
        {
            int n = sc.nextInt(); // no. of googlers
            int s = sc.nextInt(); // no. of surprising
            int p = sc.nextInt(); // criterion
            us = 0; // used suprises
            c = 0; // googlers that pass the test
            
            for(int j = 0; j<n; j++)
            {
                temp = sc.nextInt();
                double q = (temp+0.0)/(3.0);
                // total = 4 (1 1 2) 1.33
                int t1 = ((int)Math.floor(q+(2.0/3.0)));
                int t2 = ((int)Math.floor(q+(4.0/3.0)));
                if(temp < p)
                {
                    continue;
                }
                else if(q >= p || t1 >= p)
                {
                    c++;
                    continue;
                }
                // total = 5 (1 1 3) 1.66  
                else if(us != s && t2 >= p)
                {
                    c++;
                    us++;
                    continue;
                }
            }
            
            pw.println("Case #" + (i + 1) + ": " + c);
        }
        
        pw.close();
        sc.close();
    }
}

// ((temp+1)/n)+ 1 >= p
// ((temp+1)/n) >= p
// q+1 >= p
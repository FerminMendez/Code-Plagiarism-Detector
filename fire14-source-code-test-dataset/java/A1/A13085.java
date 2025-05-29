import java.io.*;
import java.util.*;

public class Dance
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter out = new PrintWriter(new File("dance_small.in"));
        //Scanner in = new Scanner(System.in);

        int runs = Integer.parseInt(in.nextLine().trim());
        int count = 0;
        while(++count <= runs)
        {
            out.print("Case #" + count + ": ");
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int[] scores = new int[n];
            
            for(int i = 0; i < n; i++)
                scores[i] = in.nextInt();
            
            int min = Math.max(p, (p*3)-2);
            int surprise = Math.max(p, (p*3)-4);
            
            int num = 0;
            for(int i = 0; i < n; i++) {
                if(scores[i] >= min)
                    num++;
                else if(scores[i] >= surprise && s > 0) {
                    num++;
                    s--;
                }
            }
            
            out.println(num);
        }
        
        out.close();
    }
}

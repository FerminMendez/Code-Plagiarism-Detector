import java.io.*;
import java.util.*;

public class Dancing {

    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
        BufferedWriter brw = new BufferedWriter(new FileWriter("output"));
        int t = Integer.parseInt(br.readLine().trim());
        int n = 1;
        while(t-- > 0)
        {
            Scanner sc = new Scanner(br.readLine());
            int N = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            int sum1 = p + p-2 + p-2;
            int sum2 = p + p - 1 + p -1;
            int ans = 0;
            while(sc.hasNext())
            {
                int a = sc.nextInt();
                if ( s>0 && (sum1>1) && (a ==sum1 || a ==sum1+1))
                {
                    s--;
                    ans++;
                }
                else if ( a >= sum2)
                    ans++;
            }
            brw.write("Case #"+n+": "+ans + "\n");
            n++;
        }
        brw.close();


    }
}

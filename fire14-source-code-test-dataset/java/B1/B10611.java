import java.io.*;
import java.util.*;
public class Recyled
{
    public static void main(String [] args) throws Exception
    {        
        BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small.out")));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = 0;
            for(int n = a; n <= b; n++)
            {
                for(int m = n+1; m<=b; m++)
                {
                    if(isRecycled(n,m))
                    {
                        ans++;
                    }
                }
            }
           out.println("Case #"+i+": "+ans);  
        }
        out.close();
    }
   
    public static boolean isRecycled(int n, int m)
    {        
        String a = ""+n;
        String b = ""+m;
        if(a.length() != b.length())
        {
            return false;
        }
        for(int i = 0; i < a.length(); i++)
        {
            String k = a.substring(i)+a.substring(0,i);
            if(k.equals(b))
            {
                return true;
            }
        }
        return false;
    }
}
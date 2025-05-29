/*
ID: lovelacer
LANG: JAVA
PROG: candy
*/
import java.io.*;
import java.util.*;
public class recycle
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("recycle.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recycle1.txt")));
        
        int T = Integer.parseInt(f.readLine());
        
        HashSet<String> checked;
        
        String[] nums;
        
        for(int k = 1; k <= T; k++)
        {
            nums = f.readLine().split(" ");
            int A = Integer.parseInt(nums[0]), B = Integer.parseInt(nums[1]), ans = 0;
            for(int n = A; n < B; n++)
            {
                checked = new HashSet<String>();
                String a = "" + n;
                String tmp = a.substring(1) + a.substring(0, 1);
                while(!tmp.equals(a))
                {
                    if(Integer.parseInt(tmp) <= B && Integer.parseInt(tmp) > n && !checked.contains(tmp))
                    {
                        ans++;
                        checked.add(tmp);
                    }
                    tmp = tmp.substring(1) + tmp.substring(0, 1);
                }
            }
            
            out.println("Case #" + k + ": " + ans);
        }
        
        out.close();
        System.exit(0);
    }
}
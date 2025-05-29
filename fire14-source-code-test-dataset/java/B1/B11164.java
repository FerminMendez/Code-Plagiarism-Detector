import java.io.*;
import java.util.*;
class RecycledNumbers
{
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(new File("C-small-attempt0.in"));
        int t = Integer.parseInt(in.nextLine());
        for(int x = 1; x <= t; x++)
        {
            String st = in.nextLine();
            int a, b;
            a = Integer.parseInt(st.split(" ")[0]);
            b = Integer.parseInt(st.split(" ")[1]);
            int y = 0;
            if(a >= 10)
            {
                for(int i = a; i < b; i++)
                {
                    int n, m;
                    n = i;
                    String tmp = "" + n;
                    for(m = (n + 1); m <= b; m++)
                    {
                        for(int j = 1; j < tmp.length(); j++)
                        {
                            int tt = getNew(n, j);
                            if(tt == m && ("" + tt).length() == ("" + m).length() && a <= n && n < m && m <= b)
                            y++;
                        }
                    }
                }
            }
            System.out.println("Case #" + x + ": " + y);
        }
    }
    public static int getNew(int n, int a)
    {
        String s = "" + n;
        int  p = s.length() - a;
        String s2 = s.substring(p);
        String s3 = s.substring(0, p);
        s = s2 + s3;
        return Integer.parseInt(s);
    }
}
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner (System.in);
        int cas = cin.nextInt();
        for(int ii = 1; ii <= cas; ii++)
        {
            System.out.printf("Case #%d: ",ii);
            int a = cin.nextInt();
            int b = cin.nextInt();
            String tmp = String.valueOf(a);
            int len = tmp.length();
            int ten = 1;
            for(int i = 0; i < len; i ++)
                ten *= 10;
            int ret = 0;
            boolean[] hasused = new boolean[ten];
            for(int i = a; i < b; i++)
            {
                int cnt = 0;
                if(hasused[i] == true) continue;
                hasused[i] = true;
                String si = String.valueOf(i);
                for(int j = 0; j < len; j++)
                {
                    for(int k = j; k < len; k++)
                    {
                        String rear = si.substring(j,k);
                        String front = si.substring(k,len);
                        int ans = Integer.parseInt(front+rear);
                        //System.out.println(ans);
                        if(ans == i) continue;
                        if(hasused[ans] == false && ans <= b && ans >= a)
                        {
                            cnt++;
                            hasused[ans] = true;
                            //System.out.printf("%d,%d\n",i,ans);
                        }
                    }
                }
                ret += cnt * (cnt + 1) /2;
            }
            System.out.println(ret);
        }
    }
}

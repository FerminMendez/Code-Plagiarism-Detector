/*
 a = y    b = n    c = f    d = i    e = c    f = w    g = l    h = b    i = k    j = u    k = o     l = m     m = x    n = s    o = e
 p = v    q = z    r = p    s = d    t = r    u = j    v = g    w = t    x = h    y = a    z = q
*/
import java.util.*;
public class Dancing  {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < T; i++)
        {
            int N = sc.nextInt();
            int S = sc.nextInt();
            int p = sc.nextInt();
            
            int AWESOME = p + 2*(p-1);
            int SURP_GOOD = p + 2*(p-2);
            
            System.out.print("Case #" + (i + 1) + ": ");
            
            int goodOnes = 0;
            int[] curr = new int[N];
            for (int j = 0; j < N; j++)
            {
                curr[j] = sc.nextInt();
            }
            Arrays.sort(curr);
            for (int j = N-1; j >= 0; j--)
            {
                if (p == 0)
                    goodOnes++;
                else if (curr[j] >= AWESOME && curr[j] > 0)
                    goodOnes++;
                else if (curr[j] > 0 && S > 0 && curr[j] >= SURP_GOOD)
                {
                    goodOnes++;
                    S--;
                }
            }
            System.out.println(goodOnes);
        }
    }
}
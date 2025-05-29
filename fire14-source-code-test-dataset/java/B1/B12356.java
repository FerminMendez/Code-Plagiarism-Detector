
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Anil Kishore, India
 */

public class Qual_C
{
    static int get(int x, int A, int B)
    {
        int r = 0;
        String s =""+x;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)!='0')
            {
                String ss = s.substring(i) + s.substring(0, i);
                int y = Integer.parseInt(ss);
                if(A<=y && x<y && y<=B) set.add(y);
            }
        return set.size();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int kase = 1, kases = sc.nextInt(); kase <= kases; kase++)
        {
            int A = sc.nextInt(), B = sc.nextInt();
            int ans = 0;
            for(int i=A;i<=B;i++) ans += get(i,A,B);
            System.out.println("Case #"+kase+": "+ans);
        }
    }
}

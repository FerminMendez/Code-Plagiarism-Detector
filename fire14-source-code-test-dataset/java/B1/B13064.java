import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class C_small {

    public C_small() throws Exception {
        int caseCount = in.nextInt();
        for (int caseNum=1;caseNum<=caseCount;caseNum++) {
            out.printf("Case #%d: ", caseNum);

            int a = in.nextInt();
            int b = in.nextInt();
            int ans = 0;
            for (int n=a; n<=b; n++) {
                String sn = n+"";
                if (sn.charAt(0)=='0') continue;
                Set<Integer> set = new HashSet<Integer>();
                for (int i=1; i<sn.length(); i++) {
                    String sm = sn.substring(i)+sn.substring(0, i);
                    int m = Integer.parseInt(sm);
                    if (m>b||n>=m) continue;
                    if (set.contains(m)) continue;
                    set.add(m);
                    ans++;
                }
            }

            out.println(ans);
        }
    }

    // {{{
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        new C_small();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    } 
    // }}}
}

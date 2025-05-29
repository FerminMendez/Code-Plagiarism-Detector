import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class B_small {

    public B_small() throws Exception {
        int caseCount = in.nextInt();
        for (int caseNum=1;caseNum<=caseCount;caseNum++) {
            out.printf("Case #%d: ", caseNum);

            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();

            int ans = 0;
            int reserv = 0;
            for (int i=0; i<n; i++) {
                int c = in.nextInt();
                if (c>=3*p-2) ans++;
                else if (c>=3*p-4&&p-2>=0) reserv++;
            }

            out.println(ans+min(s, reserv));
        }
    }

    // {{{
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        new B_small();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    } 
    // }}}
}

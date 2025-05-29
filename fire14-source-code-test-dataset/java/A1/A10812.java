import java.util.*;
import java.math.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Long.*;

public class QB {
    static String[] parts(BufferedReader br) throws Exception {
        String line = br.readLine();
        if (line == null) return null;
        return line.trim().split("\\s+");
    }
    public static void main (String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int z = parseInt(br.readLine().trim());
        int v[] = new int[11111];
        for (int cas = 1; cas <= z; cas++) {
            String p[] = parts(br);
            int nums = parseInt(p[0]);
            int surp = parseInt(p[1]);
            int best = parseInt(p[2]);
            for (int i = 3, j = 0; j < nums; i++, j++) {
                v[j] = parseInt(p[i]);
            }
            //Arrays.sort(v, 0, nums);
            int count = 0;
            for (int i = nums - 1; i >= 0; i--) {
                int a = v[i];
                /*0 <= k <= 2
                x + x + 2 + x + k = a
                3x + 2 + k = a
                3x + k = a - 2
                a - 3
                x + 2 >= best*/
                if ((a + 2) / 3 >= best) {
                    count++;
              //      out.println("A: " + a);
                } else if (surp > 0 && a >= 2 && (a - 2) / 3 + 2 >= best) {
                //    out.println("B: " + a);
                    count++;
                    surp--;
                }
            }
            out.println("Case #" + cas + ": " + count);
        }
    }
}

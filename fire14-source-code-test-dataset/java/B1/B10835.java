import java.util.*;
import java.math.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Long.*;

public class QC {
    static String[] parts(BufferedReader br) throws Exception {
        String line = br.readLine();
        if (line == null) return null;
        return line.trim().split("\\s+");
    }
    public static void main (String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int z = parseInt(br.readLine().trim());
        for (int cas = 1; cas <= z; cas++) {
            String p[] = parts(br);
            int a = parseInt(p[0]);
            int b = parseInt(p[1]);
            int pow = 1;
            int e = 0;
            for (int c = b / 10; c > 0; c /= 10) {
                e++;
                pow *= 10;
            }
            long count = 0;
            while (b > a) {
                for (int i = 0, d = b; i < e; i++) {
                    d = d / 10 + (d % 10) * pow;
                    if (d == b) break;
                    if (a <= d && d < b) count++;
                }
                b--;
            }
            out.println("Case #" + cas + ": " + count);
        }
    }
}

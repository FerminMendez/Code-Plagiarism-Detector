
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nzeyi
 */
public class C {

    public static void main(String[] arg) throws Exception {
        long a = System.currentTimeMillis();
        String in = "/home/nzeyi/Downloads/C-small-attempt0 (1).in";
        String out = "/home/nzeyi/Desktop/out";
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
        PrintWriter w = new PrintWriter(new FileOutputStream(out));
        int c = 0;
        int t = Integer.parseInt(r.readLine());
        String s;
        while ((s = r.readLine()) != null) {
            if (!"".equals(s)) {
                c++;
                w.print("Case #" + c + ": " + r(s));
                if (c < t) {
                    w.println();
                }
            }
        }
        r.close();
        w.flush();
        w.close();
        long b = System.currentTimeMillis();
        System.out.println("Done(MS): " + (b - a));
    }

    public static int r(String line) {
        int ret = 0;
        String[] t = line.trim().split("\\s");
        int a = Integer.parseInt(t[0]);
        int b = Integer.parseInt(t[1]);
        for (int i = a; i <= b; i++) {
            ret += p(i, b);
        }
        return ret;
    }

    public static int p(int n, int b) {
        int ret = 0;
        String ns = "" + n;
        int l = ns.length();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = l - 1; i > 0; i--) {
            int r = Integer.parseInt(ns.substring(i) + ns.substring(0, i));
            if ((r > n) && (r <= b) && !set.contains(r)) {
                ret++;
                set.add(r);
            }
        }
        return ret;
    }
}

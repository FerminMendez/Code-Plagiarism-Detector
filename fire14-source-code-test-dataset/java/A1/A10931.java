
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nzeyi
 */
public class B {

    public static void main(String[] arg) throws Exception {
        String in = "/home/nzeyi/Downloads/B-small-attempt0.in";
        String out = "/home/nzeyi/Desktop/out";
        long a = System.currentTimeMillis();
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
        PrintWriter w = new PrintWriter(new FileOutputStream(out));
        int c = 0;
        int t = Integer.parseInt(r.readLine());
        String s;
        while ((s = r.readLine()) != null) {
            if (!"".equals(s)) {
                c++;
                w.print("Case #" + c + ": " + max(s));
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

    public static int max(String line) {
        String[] t = line.trim().split("\\s");
        int n = Integer.parseInt(t[0]);
        int s = Integer.parseInt(t[1]);
        int p = Integer.parseInt(t[2]);
        int ret = 0;
        int sp = 0;
        for (int i = 3; i < t.length; i++) {
            int x = Integer.parseInt(t[i]);
            if (br(x, 1) >= p) {
                ret++;
            } else if (sp < s) {
                if (br(x, 2) >= p) {
                    ret++;
                    sp++;
                }
            }
        }
        return ret;
    }

    private static int br(int s, int d) {
        return (s == 0) ? 0 : (s / 3) + ((d + (s % 3)) / 2);
    }
}

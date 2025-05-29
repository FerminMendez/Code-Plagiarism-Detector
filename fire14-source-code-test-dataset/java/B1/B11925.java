import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Recycled implements Runnable {
    static final int MAX = 2000000;
    public void run(){
        try {
            Scanner in = new Scanner(new File("C-small-attempt0.in"));
            PrintWriter out = new PrintWriter(new File("c.out"));
            int testNum = in.nextInt();
            for (int test = 1; test <= testNum; test++) {
                //System.out.println("!!! new test");
                int a = in.nextInt();
                int b = in.nextInt();
                int p = 0;
                int k = 1;
                boolean[] u = new boolean[MAX + 1];
                while (a > k * 10) {
                    p++;
                    k *= 10;
                }
                long res = 0;
                for(int i = a; i <= b; i++) {
                    //System.out.println("in " + i);
                    if (u[i]) {
                        //System.out.println("  skipped");
                        continue;
                    }
                    u[i] = true;
                    if (i == k * 10) {
                        p++;
                        k *= 10;
                    }
                   // System.out.println("  p = " + p);
                    int ll = 1;
                    int ii = i;
                    for (int j = 0; j < p; j++) {
                        ii = (ii / 10) + (ii % 10) * k;
                        //System.out.println("  found " + ii);
                        if (a <= ii && ii <= b) {
                            if (u[ii]) continue;
                            //System.out.println("    ok");
                            u[ii] = true;
                            ll++;
                        }
                    }
                    //System.out.println(" ll = " + ll);
                    res += ll * (ll - 1) / 2;
                }
                out.println("Case #" + test + ": " + res);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Recycled().run();
    }
}

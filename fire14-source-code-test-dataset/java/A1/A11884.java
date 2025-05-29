import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dance implements Runnable {
    public void run(){
        try {
            Scanner in = new Scanner(new File("B-small-attempt0.in"));
            PrintWriter out = new PrintWriter(new File("b.out"));
            int testNum = in.nextInt();
            for (int test = 1; test <= testNum; test++) {
                int n = in.nextInt();
                int s = in.nextInt();
                int p = in.nextInt();
                int[] a = new int[n];
                for(int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                int r = 0;
                int k = 0;
                for(int i = 0; i < n; i++) {
                    if (a[i] % 3 == 0) {
                        if (a[i] / 3 >= p) {
                            r++;
                        } else if (a[i] / 3 == p - 1 && a[i] > 0) {
                            k++;
                        }
                    }
                    if (a[i] % 3 == 1) {
                        if (a[i] / 3 >= p - 1) r++;
                    }
                    if (a[i] % 3 == 2) {
                        if (a[i] / 3 >= p - 1) r++; else
                        if (a[i] / 3 == p - 2) k++;
                    }
                }
                int res = r + Math.min(k, s);
                out.println("Case #" + test + ": " + res);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Dance().run();
    }
}

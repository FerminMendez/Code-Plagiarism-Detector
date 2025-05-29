package inam.qual;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class B {
    public void go() {
        Scanner in = new Scanner(System.in);
        int cc = in.nextInt();
        for (int c = 1; c <= cc; c++) {
            int val = 0;
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                if (x / 3 >= p) {
                    val += 1;
                } else if (x % 3 == 1 && (x / 3) + 1 >= p) {
                    val += 1;
                } else if (x % 3 == 2 && (x / 3) + 1 >= p) {
                    val += 1;
                } else if (x % 3 == 2 && (x / 3) + 2 >= p && s > 0) {
                    val += 1;
                    s -= 1;
                } else if (x % 3 == 0 && x != 0 && (x / 3) + 1 >= p && s > 0) {
                    val += 1;
                    s -= 1;
                }
            }
            System.out.println("Case #" + c + ": " + val);
        }
    }
    public static void main(String[] args) {
        try {
            String p = "B-small";
            String r = "qual";
            System.setIn(new FileInputStream(new File(r, p + ".in")));
            if (1 == 1) {
                System.setOut(new PrintStream(new File(r, p + ".out")));
            }
            new B().go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

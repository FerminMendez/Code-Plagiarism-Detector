/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj2012.qualification_round;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author langlv
 */
public class Dancing {

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(new FileReader("C:\\B-small-attempt1.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\B-small-attempt1.out"));
        try {
            int ntest = Integer.parseInt(sc.nextLine());

            for (int test = 1; test <= ntest; ++test) {
                int res = 0;

                int n = sc.nextInt();
                int s = sc.nextInt();
                int p = sc.nextInt();

                int si = 0;
                for (int i = 0; i < n; i++) {
                    int t = sc.nextInt();
                    if (p == 0) {
                        res++;
                    } else {
                        if (t > 0) {
                            if ((t / 3) == p - 2 && (t % 3) == 2 && si < s) {
                                si++;
                                res++;
                            }
                            if ((t / 3) == (p - 1) && (t % 3) == 0 && si < s) {
                                si++;
                                res++;
                            }
                            if (t / 3 >= p || ((t / 3) == (p - 1) && (t % 3) >= 1)) {
                                res++;
                            }
                        }
                    }
                }

                pw.print("Case #" + test + ": ");
                pw.print(res);
                pw.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            pw.close();
            sc.close();
        }
    }
}

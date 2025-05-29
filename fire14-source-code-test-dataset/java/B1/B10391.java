/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj2012.qualification_round;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author langlv
 */
public class Dancing {

    private static int countDigit(int num) {
        Integer t = new Integer(num);
        int count = 0;
        while (t != 0) {
            t = t / 10;
            count++;
        }
        return count;
    }

    private static int recycledNumber(int num, int pos) {
        if (num < 10) {
            return 0;
        }
        if (pos > countDigit(num)) {
            return 0;
        }
        String n = String.valueOf(num);
        int res = Integer.parseInt(n.substring(pos) + n.substring(0, pos));

        return res;
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(new FileReader("C:\\C-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\C-small-attempt0.out"));
        try {
            int ntest = Integer.parseInt(sc.nextLine());

            for (int test = 1; test <= ntest; ++test) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                System.out.println("--------------------------");
                int res = 0;
                List<Integer> num = new ArrayList<Integer>();
                for (int i = A; i <= B; i++) {
                    for (int j = 1; j < countDigit(i); j++) {
                        int rec = recycledNumber(i, j);
                        if (A <= rec && rec <= B && i < rec) {
                            num.add(rec);
                            res++;
                            System.out.println(res + ": " + i + "," + rec);
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

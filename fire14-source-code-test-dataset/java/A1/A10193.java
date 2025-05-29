/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author yondaime
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        int rest = 0;
        int division = 0;
        int count = 0;

        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter out = new PrintWriter(new File("B-small-attempt0.out"));
        sc.nextLine();
        int kl = 0;
        while (sc.hasNext()) {
            out.print("Case #" + (++kl) + ": ");
            count = 0;
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();
                division = v / 3;
                rest = v % 3;

                if (p - division <= 0) {
                    count++;
                } else if (p - division == 1) {
                    if (rest != 0) {
                        count++;
                    } else if (v!=0 && s != 0) {
                        s--;
                        count++;
                    }

                } else if (p - division == 2 && rest == 2 && s != 0) {

                    s--;
                    count++;

                }
            }




            out.println(count);
        }
        out.close();
        sc.close();
    }
}

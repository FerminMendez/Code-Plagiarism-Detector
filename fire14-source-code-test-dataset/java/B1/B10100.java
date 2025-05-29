/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author KazakhPride
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner in = new Scanner(new File("C-small-attempt2.in"));
        PrintWriter out = new PrintWriter(new File("output.txt"));

        int n = in.nextInt();
        int len = 0;

        for (int i = 1; i <= n; i++) {
            out.print("Case #" + i + ": ");
            int current_n = 0;
            int current_m = 0;
            int range = 0;
            int a = in.nextInt();
            int b = in.nextInt();
            int count = 0;

            if ((a + "").length() == 1 && (b + "").length() == 1) {
                count = 0;
            } else {
                range = b - a;
                for (int j = 0; j < range; j++) {
                    current_n = j + a;
                    current_m = j + a;

                    int l = (current_n + "").length();
                    // if (l==3) len=9;
                    // if(l==4) len = 28;
                    for (int k = 0; k < l; k++) {
                        String m = current_m + "";
                        if (m.length() < l) {
                            for (int w = 0; w < (l - m.length()); w++) {
                                m = "0"+m;
                            }
                        }
                        current_m = Integer.parseInt(m.substring(l - 1) + m.substring(0, l - 1));
                        if (current_m <= b && current_m > current_n && current_m >= a) {
                            ++count;
                        }
                    }
                }
            }
            out.println(count);
        }
        in.close();
        out.close();
    }
}
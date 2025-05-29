/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZAMAN
 */
import java.io.*;

public class test {

    public static void main(String args[]) {
        try {
            BufferedReader a = new BufferedReader(new FileReader("B-small-attempt2.in"));
            BufferedWriter b = new BufferedWriter(new FileWriter("B-small-attempt2.out"));

            int Case = Integer.parseInt(a.readLine());
            for (int i = 1; i <= Case; i++) {
                String line[] = a.readLine().split(" ");
                int c[] = new int[line.length];
                b.append("Case #" + i + ": ");
                for (int j = 0; j <= line.length - 1; j++) {
                    c[j] = Integer.parseInt(line[j]);

                }
                int contestants = c[0];
                int suprise = c[1];
                int margin = c[2];
                int best = 0;
                if (suprise == 0) {
                    for (int j = 0; j < contestants; j++) {
                        if (c[j + 3] % 3 == 0) {
                            if (c[j + 3] / 3 >= margin) {
                                best++;
                            }
                        } else if (c[j + 3] % 3 == 1 || c[j + 3] % 3 == 2) {
                            if (((c[j + 3] / 3) + 1) >= margin) {
                                best++;
                            }
                        }
                    }
                } else {
                    for (int j = 0, k = suprise; j < contestants; j++) {
                        int remain = c[j + 3] % 3;
                        int dv = c[j + 3] / 3;
                        if (remain == 0) {
                            if (dv >= margin) {
                                best++;
                            } else if (k > 0 && (dv + 1) >= margin && (dv + 1) <= c[j + 3]) {
                                best++;
                                k--;
                            }
                        } else if (remain == 1) {
                            if (((dv) + 1) >= margin && (dv + 1) <= c[j + 3]) {
                                best++;
                            }

                        } else if (remain == 2) {

                            if (((dv) + 1) >= margin && (dv + 1) <= c[j + 3]) {
                                best++;
                            } else if (k > 0 && (dv + 2) >= margin && (dv + 1) <= c[j + 3]) {
                                best++;
                                k--;
                            }
                        }
                    }

                }
                b.append("" + best);
                b.newLine();
            }
            b.flush();
            a.close();
            b.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
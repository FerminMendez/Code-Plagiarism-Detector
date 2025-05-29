
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main2 {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("in.txt")));
            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
            int t;
            t = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= t; i++) {
                int n, s, p;
                n = in.nextInt();
                int g[] = new int[n];
                s = in.nextInt();
                p = in.nextInt();
                for (int j = 0; j < n; j++) {
                    g[j] = in.nextInt();
                }
                in.nextLine();
                int count = 0;
                for (int k = 0; k < g.length; k++) {
                    if (g[k] != 0 || p == 0) {
                        int div = g[k] / 3;
                        int mod = g[k] % 3;
                        if (mod == 0) {
                            if (div >= p) {
                                count++;
                            } else if (div + 1 >= p && s > 0) {
                                count++;
                                s--;
                            }
                        } else if (mod == 1) {
                            if (div + 1 >= p) {
                                count++;
                            }
                        } else {
                            if (div + 1 >= p) {
                                count++;
                            } else if (div + 2 >= p && s > 0) {
                                count++;
                                s--;
                            }
                        }
                    }
                }

                String toPrint = "Case #" + i + ": " + count;
                if (i != t) {
                    toPrint += "\n";
                }
                out.write(toPrint);
            }
            in.close();
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

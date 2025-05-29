/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Mahmoud
 */
public class CodeJam2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            int n, s, p;

            String inStrLine = in.readLine();
            if (inStrLine == null) {
                System.out.println("wrong format");
                return;
            }
            int num = Integer.parseInt(inStrLine);
            for (int i = 0; i < num; i++) {
                writer.write("Case #" + (i + 1) + ": ");
                inStrLine = in.readLine();
                if (inStrLine == null) {
                    System.out.println("wrong format");
                    return;
                }

                String[] params = inStrLine.split(" ");
                n = Integer.parseInt(params[0]);
                s = Integer.parseInt(params[1]);
                p = Integer.parseInt(params[2]);


                int t,max, result = 0;
                for (int j = 0; j < n; j++) {
                    t = Integer.parseInt(params[j + 3]);

                    max = t==0?0:((t - 1) / 3) + 1;
                    if (max >= p) {
                        result++;
                    } else if (s != 0) {
                        max = t==0?0:((t - 2) / 3) + 2;
                        if (max >= p) {
                            result++;
                            s--;
                        }
                    }
                }

                writer.write(String.valueOf(result));
                if (i != num - 1) {
                    writer.write('\n');
                }
            }

            writer.flush();

        } catch (Exception e) {
            System.err.println("cant open file");
        }
    }
}

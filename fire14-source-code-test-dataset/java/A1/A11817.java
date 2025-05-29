/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Wouter
 */
public class DancingWithTheGooglers {

    ArrayList<String> cases = new ArrayList<String>();
    int makesit = 0;
    int needsSurp = 0;

    public DancingWithTheGooglers() {






        try {
            // Setup in/out
            System.setIn(new FileInputStream("C:\\GCJ\\B-small-attempt0.in"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\GCJ\\B-small-attempt0.out"));
            bw.flush();



            int untill = Integer.parseInt(br.readLine());

            for (int t = 1; t <= untill; t++) {

                String[] ins = br.readLine().split(" ");
                int n = Integer.parseInt(ins[0]); // number of googlers
                int s = Integer.parseInt(ins[1]); // number of surpirsing trips
                int p = Integer.parseInt(ins[2]); // min points
                int[] ti = new int[n];
                for (int i = 3; i < n + 3; i++) {
                    ti[i - 3] = Integer.parseInt(ins[i]);
                }
                for (int m = 0; m < ti.length; m++) {
                    doMath(ti[m], p);
                }

                int ans = makesit;
                if (s < needsSurp) {
                    ans += s;
                } else {
                    ans += needsSurp;
                }


                String out = "Case #" + t + ": " + ans;

                cases.add(out);
                makesit = 0;
                needsSurp = 0;

            }

            for (String s : cases) {
                System.out.println(s);
                bw.write(s);
                bw.flush();
                bw.newLine();
            }

        } catch (IOException ex) {
            System.out.println("SOMETHING WENT WRONG");
        }
    }

    public void doMath(int number, int p) {
        int start = 10;
        boolean done = false;
        while (true) {
            if (start + start + start == number) {
                if (start >= p) {
                    makesit++;
                    done = true;
                    break;
                }
                break;
            }
            if (start + start + start - 1 == number) {
                if (start >= p) {
                    makesit++;
                    done = true;
                    break;
                }
                break;
            }
            if (start + start - 1 + start - 1 == number) {
                if (start >= p) {
                    makesit++;
                    done = true;
                    break;
                }
                break;
            }
            start--;
        }
        if (!done) {
            start = 10;
            while (true) {
                if (start == 1) {
                    break;
                }
                if (start + (start - 1) + (start - 2) == number) {
                    if (start >= p) {
                        needsSurp++;
                        break;
                    }
                    break;
                }
                if (start + (start - 2) + (start - 2) == number) {
                    if (start >= p) {
                        needsSurp++;
                        break;
                    }
                    break;
                }
                start--;

            }
        }

    }

    public static void main(String[] args) {
        new DancingWithTheGooglers();

    }
}

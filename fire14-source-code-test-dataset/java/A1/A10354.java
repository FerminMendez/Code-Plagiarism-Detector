/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author acer
 */
public class B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        FileInputStream input = new FileInputStream("input.txt");
        DataInputStream in = new DataInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        FileOutputStream output = new FileOutputStream("output.txt");

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int S = Integer.parseInt(temp[1]);
            int P = Integer.parseInt(temp[2]);
            int[] points = new int[N];
            int count = 0, scount = 0;

            for (int j = 0; j < N; j++) {
                points[j] = Integer.parseInt(temp[j + 3]);
                int avg = points[j] / 3;
                if (points[j] % 3 == 0) {
                    if (avg >= P) {
                        count++;
                    } else if ((avg + 1) == P && avg != 0 && avg != 10) {
                        scount++;
                    }
                } else if (points[j] % 3 == 1) {
                    if ((avg+1) >= P) {
                        count++;
                    }
                } else if (points[j] % 3 == 2) {
                    if ((avg + 1) >= P) {
                        count++;
                    } else if ((avg + 2) == P && avg != 9) {
                        scount++;
                    }
                }
            }
            if (S >= scount) {
                output.write(("Case #" + (i + 1) + ": " + (count + scount) + "\n").getBytes());
            } else {
                output.write(("Case #" + (i + 1) + ": " + (count + S) + "\n").getBytes());
            }
        }
    }
}

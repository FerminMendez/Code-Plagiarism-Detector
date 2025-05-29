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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author acer
 */
public class C {

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
        int A, B;

        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");
            A = Integer.parseInt(temp[0]);
            if (A < 12) {
                A = 12;
            }
            B = Integer.parseInt(temp[1]);
            if (B < A) {
                output.write(("Case #" + (i + 1) + ": " + "0" + "\n").getBytes());
                continue;
            }
            int j = A, count = 0;

            while (j <= B) {
                String thisNo = new Integer(j).toString();
                Set<Integer> intSet = new HashSet<Integer>();
                for (int k = 1; k < thisNo.length(); k++) {
                    int newNo = Integer.parseInt(thisNo.substring(thisNo.length() - k) + thisNo.substring(0, thisNo.length() - k));
                    if (newNo <= B && Integer.parseInt(thisNo) < newNo && !intSet.contains(newNo)) {
                        count++;
                        intSet.add(newNo);
                    }
                }
                j++;
            }
            output.write(("Case #" + (i + 1) + ": " + count + "\n").getBytes());
        }
    }
}

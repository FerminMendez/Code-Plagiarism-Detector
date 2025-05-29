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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Wouter
 */
public class RecycledNumbers {

    ArrayList<String> cases = new ArrayList<String>();

    public RecycledNumbers() {


        try {
            // Setup in/out
            System.setIn(new FileInputStream("C:\\GCJ\\C-small-attempt0.in"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\GCJ\\C-small-attempt0.out"));
            bw.flush();



            int untill = Integer.parseInt(br.readLine());

            for (int x = 1; x <= untill; x++) {
                int ans = 0;
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                for (int z = a; z <= b; z++) {
                    List<Integer> ints = getAllRecycledPairsOf(z);
                    removeDups(ints);
                    Collections.sort(ints);

                    for (Integer nr : ints) {
                        if (between(nr, a, b)) {
                            ans++;
                        } else if (nr > b) {
                            break;
                        }
                    }
                }

                String out = "Case #" + x + ": " + ans;

                cases.add(out);

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

    public List<Integer> getAllRecycledPairsOf(int nr) {
        List<Integer> ints = new ArrayList<Integer>();

        StringBuilder s = new StringBuilder();
        s.append(nr);

        String start = s.toString();

        for (int x = 1; x < start.length(); x++) {
            s = new StringBuilder();
            String back = start.substring(start.length() - x, start.length());
            String front = start.substring(0, start.length() - x);
            s.append(back).append(front);
            if (!back.startsWith("0")) {
                Integer newNr = new Integer(s.toString());
                if (newNr > nr) {
                    ints.add(newNr);
                }
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        RecycledNumbers test = new RecycledNumbers();
    }

    public boolean between(int nr, int a, int b) {
        if (nr >= a && nr <= b) {
            //System.out.println(nr);
            return true;
        }
        return false;
    }

    public static void removeDups(List<Integer> list) {
        Set<Integer> s = new HashSet<Integer>(list);
        list.clear();
        list.addAll(s);
    }
}

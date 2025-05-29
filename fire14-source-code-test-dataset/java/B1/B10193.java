/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recycled;

import java.io.*;
import java.util.*;

/**
 *
 * @author maheshgupta
 */
public class Recycled {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            HashMap hm = new HashMap();
            File file = new File("/Users/maheshgupta/Downloads/C-small-attempt0.in");
//            File file = new File("/Users/maheshgupta/Desktop/input.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            FileWriter fw = new FileWriter("/Users/maheshgupta/Desktop/output.txt");
            String line;
            int cases = Integer.parseInt(in.readLine());

            for (int i = 0; i < cases; i++) {

                line = in.readLine();
                String[] lineArray = line.split(" ");
                int lower = Integer.parseInt(lineArray[0]);
                int upper = Integer.parseInt(lineArray[1]);
                int pair = 0;
                for (int j = lower; j <= upper; j++) {
                    String s = Integer.toString(j);

                    int length = s.length();
                    if (length == 1) {
                        continue;
                    } else {
                        for (int k = 0; k < length; k++) {
                            if (k + 1 < length) {

                                String newNumber = s.substring(k + 1, length) + s.substring(0, k + 1);
                                if (newNumber.charAt(0) != '0') {
                                    int number = Integer.parseInt(newNumber);
                                    if (number >= lower && number <= upper && number > j) {
                                        int value = hm.get(s + "#" + newNumber) != null ? (Integer) hm.get(s + "#" + newNumber) : 0;
                                        if (value != number) {
                                            hm.put(s + "#" + newNumber, number);
                                            pair++;
                                        }

                                    }
                                }




                            }

                        }
                    }
                }
                if (i < cases - 1) {
                    fw.write("Case #" + (i + 1) + ": " + pair + "\n");
                } else {
                    fw.write("Case #" + (i + 1) + ": " + pair);
                }

                hm.clear();

            }
            fw.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam.recycled.numbers;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Utils {
    
    public ArrayList<Integer[]> parse(String file) {

        BufferedReader in = null;
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        int size;

        try {

            in = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));
            size = Integer.parseInt(in.readLine());

            for (int n = 0; n < size; n++) {

                String[] stringCases = in.readLine().split("\\s+");

                Integer[] cases = new Integer[2];
                cases[0] = Integer.parseInt(stringCases[0]);
                cases[1] = Integer.parseInt(stringCases[1]);
                
                list.add(cases);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void write(ArrayList<Integer> output, String file) {

        BufferedWriter out = null;

        try {

            out = new BufferedWriter(new FileWriter(file));

            for (int n = 0; n < output.size() - 1; n++) {
                out.write("Case #" + (n + 1) + ": " + output.get(n));
                out.newLine();
            }
            out.write("Case #" + output.size() + ": " + output.get(output.size() - 1));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}

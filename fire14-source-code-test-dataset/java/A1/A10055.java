/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam.dancing.with.the.googlers;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Utils {

    public ArrayList<ArrayList> parse(String file) {

        BufferedReader in = null;
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        int size;

        try {

            in = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));
            size = Integer.parseInt(in.readLine());

            for (int n = 0; n < size; n++) {

                String[] stringCases = in.readLine().split("\\s+");

                ArrayList<Integer> cases = new ArrayList<Integer>();
                cases.add(Integer.parseInt(stringCases[0]));
                cases.add(Integer.parseInt(stringCases[1]));
                cases.add(Integer.parseInt(stringCases[2]));

                for (int m = 0; m < cases.get(0); m++) {
                    cases.add(Integer.parseInt(stringCases[3 + m]));
                }
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

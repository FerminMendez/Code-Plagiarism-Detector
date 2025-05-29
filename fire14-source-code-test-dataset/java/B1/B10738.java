/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejamproblemc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Fluffy Dragon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File inputFile = new File("C-small-attempt0.in");
        File outputFile = new File("output.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outputFile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                String readLine = br.readLine();
                String[] split = readLine.split("\\s");
                int[] input = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    input[i2] = Integer.parseInt(split[i2]);
                }
                String output = calculate(i + 1, input);
                bw.write(output);
                if (i + 1 < count) {
                    bw.newLine();
                }
            }
            br.close();
            fr.close();
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    private static String calculate(int count, int[] input) {
        String output = "Case #" + count + ": ";
        int a = input[0];
        int b = input[1];
        int[] availableNumbers = new int[b - a + 1];
        for (int i = 0; i <= (b - a); i++) {
            availableNumbers[i] = i + a;
        }
        ArrayList<String> passed = new ArrayList(0);
        for (int n : availableNumbers) {
            ArrayList<String> used = new ArrayList(0);
            String intAsString = String.valueOf(n);
            for (int i = intAsString.length() - 1; i > 0; i--) {
                String endSubString = intAsString.substring(i, intAsString.length());
                String startSubString = intAsString.substring(0, i);
                String mixString = endSubString.concat(startSubString);
                int m = Integer.parseInt(mixString);
                if (a <= n && n < m && m <= b && a < b) {
                    //System.out.println(mix);
                    if (String.valueOf(m).length() == intAsString.length()) {
                        for (int check : availableNumbers) {
                            if (check == m) {
                                if (!used.contains(mixString)) {
                                    used.add(mixString);
                                    passed.add(mixString);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (String temp : passed) {
            //System.out.println(temp);
        }
        System.out.println(passed.size());
        output = output.concat(String.valueOf(passed.size()));
        return output;
    }
}

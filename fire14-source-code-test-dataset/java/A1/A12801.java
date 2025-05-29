/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.Utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author home
 */
public class Googlers {

    String outFileName;

    static int getNumber(int N, int S/*surprises*/, int P/*compare*/, int[][] values) {
        int ceiled = 0;
        int violated = 0;
        for (int i = 0; i < N; i++) {
            if (values[i][3] >= P) {//ceiled
                ceiled++;
            } else if (values[i][4] >= P) {//added
                if (violated < S && values[i][0] > 0) {
                    violated++;
                }
            }
        }
        int x = violated + ceiled;
        System.out.print("\n N : " + N + "  P: " + P + "  S : " + S);
        System.out.print("\n ceiled   : " + ceiled);
        System.out.print("\n violated : " + violated);
        System.out.print("\n final    : " + x);
        return violated + ceiled;
    }

    public static void main(String[] agrs) {

        try {
            File file = new File("C:/Documents and Settings/mekete/Desktop/xxxx.in");
            InputStream fin = new FileInputStream(file);
            InputStreamReader inrdr = new InputStreamReader(fin, "UTF-8");
            BufferedReader br = new BufferedReader(inrdr);
            String line = br.readLine();
            int T = Integer.parseInt(line);
            int N;
            int S;
            int P;
            int LEN;
            int rowCounter = 1;
            for (int row = 0; row < T; row++) {
                line = br.readLine();
                System.out.println("\n============================\n" +
                        "============" + line + "==================\n" +
                        "======================================\n");
                //===============================================================
                String[] numbersString = line.split(" ");//for each case
                N = Integer.parseInt(numbersString[0]);
                S = Integer.parseInt(numbersString[1]);
                P = Integer.parseInt(numbersString[2]);
                LEN = N + 3;
                float[] floats = new float[LEN];
                int[][] ints = new int[LEN][5];
                for (int i = 3; i < LEN; i++) {
                    floats[i - 3] = Float.parseFloat(numbersString[i]);
                    ints[i - 3][0] = Integer.parseInt(numbersString[i]);
                    if (ints[i - 3][0] % 3 == 0) {
                        ints[i - 3][1] = ints[i - 3][0] + 0;
                        ints[i - 3][2] = 0;
                        ints[i - 3][3] = ints[i - 3][0] / 3;//at normal
                        ints[i - 3][4] = (ints[i - 3][0] / 3) + 1;//at unique
                    } else if (ints[i - 3][0] % 3 == 1) {
                        ints[i - 3][1] = ints[i - 3][0] - 1;
                        ints[i - 3][2] = -1;
                        ints[i - 3][3] = ((ints[i - 3][0] - 1) / 3) + 1;//at normal
                        ints[i - 3][4] = ((ints[i - 3][0] - 1) / 3) + 1;//at normal
                    } else if (ints[i - 3][0] % 3 == 2) {
                        ints[i - 3][1] = ints[i - 3][0] + 1;
                        ints[i - 3][2] = 1;
                        ints[i - 3][3] = ((ints[i - 3][0] + 1) / 3);//at normal
                        ints[i - 3][4] = ((ints[i - 3][0] + 1) / 3) + 1;//at normal
                    }
                    System.out.print("\nnum " + ints[i - 3][0] + "  nor :" + ints[i - 3][3] + "  viol : " + ints[i - 3][4]);
                }
                getNumber(N, S, P, ints);
                //===============================================================



                //==============================================================


                writeToFile("C:/Documents and Settings/mekete/Desktop/yyyy.in", "Case #" + rowCounter + ": " + getNumber(N, S, P, ints) + "\n");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean writeToFile(String fileName, String dataLine) {
        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new FileOutputStream(fileName, true));
            dos.writeBytes(dataLine);
            dos.close();
        } catch (FileNotFoundException ex) {
            return (false);
        } catch (IOException ex) {
            return (false);
        }
        return (true);

    }
}

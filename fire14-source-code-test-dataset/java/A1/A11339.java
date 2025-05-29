/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Mohammed
 */
public class NewDancers {

    static int in[][], out[];

    private static void readFile(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int x = Integer.parseInt(br.readLine());

        in = new int[x][103];
        out = new int[x];

        for (int i = 0; i < x; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int j = 0;
            while (st.hasMoreTokens()) {
                in[i][j++] = Integer.parseInt(st.nextToken());
            }

        }
    }

    private static void writeOutput(String string) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(string));
        for (int i = 0; i < out.length; i++) {
            bw.write("Case #" + (i + 1) + ": " + out[i]);
            if (i != out.length - 1) {
                bw.write("\r\n");
            }
        }
        bw.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        readFile("data");
        for (int i = 0; i < in.length; i++) {
            int googlers = in[i][0];
            int surp = in[i][1];
            int p = in[i][2];
            int minCountedTriplet = 3 * p - 2;
            int minCountedTripletWithSur = 3 * p - 4;
            int output = 0;
            for (int j = 3; j < googlers + 3; j++) {
                int temp = in[i][j];
                if (temp >= minCountedTriplet) {
                    output++;
                } else {
                    if (surp > 0 && temp >= minCountedTripletWithSur && minCountedTripletWithSur >= 0) {
                        output++;
                        surp--;
                    }
                }

            }
            out[i] = output;
        }
        writeOutput("output.txt");
    }
}
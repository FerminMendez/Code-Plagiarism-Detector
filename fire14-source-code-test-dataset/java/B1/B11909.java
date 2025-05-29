/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probc;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author nick
 */
public class ProbC {

    public static int numLines = 0;
    public static String[] dataLine;
    public static String[] outLine;

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {

        // input

        //JOptionPane.showMessageDialog(null, "This program provides a decrypter for Google's third CodeJam question: Recycled Numbers.");

        getInput();

        decode();

        writeOutput();

    }

    private static void getInput() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        try {
            numLines = Integer.parseInt(scanner.nextLine());
            dataLine = new String[numLines];
            outLine = new String[numLines];
            for (int i = 0; i < numLines; i++) {
                dataLine[i] = scanner.nextLine();
            }
        } finally {
            scanner.close();
        }
    }

    private static void writeOutput() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        Writer out = new OutputStreamWriter(new FileOutputStream("output.txt"));
        try {
            String outText = "";
            for (int i = 0; i < numLines; i++) {
                outText = outText + outLine[i] + "\n";
            }
            out.write(outText);
        } finally {
            out.close();
        }
    }

    private static void decode() {

        for (int i = 0; i < numLines; i++) {


            Scanner sc = new Scanner(dataLine[i]);
            String numOneString = sc.next();
            String numTwoString = sc.next();
            sc.close();
            int numOneInt = Integer.parseInt(numOneString);
            int numTwoInt = Integer.parseInt(numTwoString);
            int length = numOneString.length();
            int setLength = numTwoInt - numOneInt;
            String tempString = "";
            int tempInt = 0;

            int answer = 0;

            int[] answers = new int[numTwoInt];


            tempInt = numOneInt;


            for (int ii = 0; ii < setLength; ii++) {

                tempString = "" + tempInt;


                for (int iii = 0; iii < length; iii++) {


                    tempString = tempString.substring(1) + tempString.charAt(0);


                    if (Integer.parseInt(tempString) >= tempInt & Integer.parseInt(tempString) <= numTwoInt) {
                        if (Integer.parseInt(tempString) != tempInt) {
                            
                            answer++;

                        }
                    }
                }

                tempInt++;
            }

            outLine[i] = "Case #" + (i + 1) + ": " + answer;

        }

    }
}

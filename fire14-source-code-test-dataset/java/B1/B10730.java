package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.sound.sampled.DataLine;

public class RecycleNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        recycleNumbers(args[0]);
//        System.out.println("No. of recycled possibilities: " + recycleNumber("128 986"));
    }

    private static void recycleNumbers(String fileName) {
        File f = new File(fileName);
        BufferedReader fin;
        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            int noOfInputs = Integer.valueOf(fin.readLine());
            String[] inputs = readSamplesFromFile(noOfInputs, fin);

            BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/asachwani/Desktop/CodeJam/Output.txt")));

            for (int i = 0; i < noOfInputs; i++) {
                System.out.println(i + 1 + " " + inputs[i]);
                fout.write("Case #" + (i + 1) + ": " + recycleNumber(inputs[i]) + "\n");
            }

            fout.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static int recycleNumber(String input) {
        String[] data = input.split(" ");
        int minValue = Integer.valueOf(data[0]);
        int maxValue = Integer.valueOf(data[1]);
        int noOfPossibilities = 0;

        char[] minValueChar = String.valueOf(minValue).toCharArray();

        HashSet<String> uniquePairs = new HashSet<String>();

        if (minValueChar.length > 1) {

            for (int j = 0; j < minValueChar.length - 1; j++) {
                for (int k = minValue; k < maxValue; k++) {
                    int lastDigits = k % (int) Math.pow(10, j + 1);
                    int firstDigits = k / (int) Math.pow(10, j + 1);

                    int replacement = 0;
                    if (lastDigits != firstDigits) {
                        replacement = Integer.valueOf("" + lastDigits + firstDigits);
                    }

                    if (replacement > k && replacement <= maxValue) {

                        if (!uniquePairs.contains(k + " " + replacement) || uniquePairs.contains(replacement + " " + k)) {
                            noOfPossibilities++;
                            uniquePairs.add(k + " " + replacement);
                            System.out.println(k + "  " + j + "   " + lastDigits + "   " + firstDigits + "  " + replacement);
                        }
                    }
                }
            }

        }

        return noOfPossibilities;


    }

    private static String[] readSamplesFromFile(int noOfInputs, BufferedReader fin) throws IOException {
        String[] samples = new String[noOfInputs];

        for (int i = 0; i < noOfInputs; i++) {
            samples[i] = fin.readLine();
        }

        return samples;
    }
}

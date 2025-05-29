/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancing.with.the.googlers;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DancingWithTheGooglers {

    static int numberOfTests;
    static int[] testResults;
    static ScoreCounter[] orders;
    
    public static void main(String[] args) {
        InitInput();
        for (int i = 0; i < numberOfTests; i++) {
            try {
                testResults[i] = orders[i].Count2();
                if (testResults[i] != orders[i].Count2())
                {
                    System.out.print(i);
                }
            } catch (Exception ex) {
                Logger.getLogger(DancingWithTheGooglers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        writeResult();
    }
    
    static void InitInput() {
        try {
            FileReader input = new FileReader("B-small-attempt4.in");
            try (BufferedReader bufRead = new BufferedReader(input)) {
                String line = bufRead.readLine();

                numberOfTests = Integer.parseInt(line);
                testResults = new int[numberOfTests];
                orders = new ScoreCounter[numberOfTests];

                for (int i = 0; i < numberOfTests; i++) {
                    line = bufRead.readLine();
                    if (line == null) {
                        break;
                    }
                    orders[i] = new ScoreCounter(line);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(DancingWithTheGooglers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    static void writeResult() {
        FileWriter output = null;
        try {
            output = new FileWriter("output");
            try (BufferedWriter bufWrite = new BufferedWriter(output)) {
                for (int i = 0; i < numberOfTests; i++) {
                    String result = "Case #"+(i+1)+": "+testResults[i];
                    bufWrite.write(result);
                    bufWrite.newLine();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DancingWithTheGooglers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(DancingWithTheGooglers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejamproblemb;

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
        //setup();
        File inputFile = new File("B-small-attempt0.in");
        File outputFile = new File("output2.txt");
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
        int googlers = input[0];
        int surprising = input[1];
        int bestResultSearch = input[2];
        ArrayList<int[]> scoresHigh = new ArrayList(0);
        ArrayList<int[]> scoresLow = new ArrayList(0);
        for (int i = 3; i < (googlers + 3); i++) {
            for (int j = i + 1; j < (googlers + 3); j++) {
                if (input[i] <= input[j]) {
                    int a = input[i];
                    int b = input[j];
                    input[i] = b;
                    input[j] = a;
                }
            }
        }
        for (int i = 3; i < (googlers + 3); i++) {
            int total = input[i];
            int score1 = Math.round(total / 3);
            int score2 = Math.round(total / 3);
            int score3 = Math.round(total / 3);
            if ((score1 + score2 + score3) == total) {
                score3--;
            }
            if ((score1 + score2 + score3) == total) {
                score2--;
            }
            if (score1 < 0) {
                score1 = 0;
            }
            if (score2 < 0) {
                score2 = 0;
            }
            if (score3 < 0) {
                score3 = 0;
            }
            while ((score1 + score2 + score3) != total) {
                if ((score1 + 1 <= 10) && score1 - score2 < 2 && score1 - score3 < 2) {
                    score1++;
                } else if ((score2 + 1 <= 10) && score2 - score1 < 2 && score2 - score3 < 2) {
                    score2++;
                } else if ((score3 + 1 <= 10) && score3 - score1 < 2 && score3 - score2 < 2) {
                    score3++;
                } else {
                    throw new RuntimeException("no deviation could be created");
                }
            }
            System.out.println(score1 + " " + score2 + " " + score3 + " " + total);
            //System.out.println(score1 + " " + score2 + " " + score3);
            scoresHigh.add(new int[]{score1, score2, score3});
            score1 = Math.round(total / 3);
            score2 = Math.round(total / 3);
            score3 = Math.round(total / 3);
            if (score1 < 0) {
                score1 = 0;
            }
            if (score2 < 0) {
                score2 = 0;
            }
            if (score3 < 0) {
                score3 = 0;
            }
            while ((score1 + score2 + score3) != total) {
                if ((score1 + 1 <= 10) && score1 - score2 < 1 && score1 - score3 < 1) {
                    score1++;
                } else if ((score2 + 1 <= 10) && score2 - score1 < 1 && score2 - score3 < 1) {
                    score2++;
                } else if ((score3 + 1 <= 10) && score3 - score1 < 1 && score3 - score2 < 1) {
                    score3++;
                } else {
                    throw new RuntimeException("no deviation could be created");
                }
            }
            scoresLow.add(new int[]{score1, score2, score3});
        }
        for (int i = 0; i < googlers; i++) {
            int[] low = scoresLow.get(i);
            if (low[0] >= bestResultSearch || low[1] >= bestResultSearch || low[2] >= bestResultSearch) {
                System.out.println("Changed 1");
                scoresHigh.set(i, low);
            }
        }
        int surprisingCounter = 0;
        for (int i = 0; i < googlers; i++) {
            int[] temp = scoresHigh.get(i);
            if (temp[0] >= bestResultSearch || temp[1] >= bestResultSearch || temp[2] >= bestResultSearch) {
                continue;
            }
            if (Math.abs(temp[0] - temp[1]) == 2 || Math.abs(temp[0] - temp[2]) == 2 || Math.abs(temp[1] - temp[2]) == 2) {
                surprisingCounter++;
                if (surprisingCounter > surprising) {
                    scoresHigh.set(i, scoresLow.get(i));
                    surprisingCounter--;
                }
            }
        }
        //error lies between here
        surprisingCounter = 0;
        for (int i = 0; i < googlers;i++){
            int[] temp = scoresHigh.get(i);
            if (Math.abs(temp[0] - temp[1]) == 2 || Math.abs(temp[0] - temp[2]) == 2 || Math.abs(temp[1] - temp[2]) == 2) {
                surprisingCounter++;
                if (surprisingCounter > surprising) {
                    scoresHigh.set(i, scoresLow.get(i));
                    surprisingCounter--;
                }
            }
        }
        //and here
        if (surprisingCounter != surprising) {
            System.out.println("Error: " + surprisingCounter + " " + surprising);
        }
        int bestScoresReached = 0;
        for (int[] temp : scoresHigh) {
            System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);
            if (temp[0] >= bestResultSearch || temp[1] >= bestResultSearch || temp[2] >= bestResultSearch) {
                bestScoresReached++;
            }
        }
        output = output.concat(String.valueOf(bestScoresReached));
        return output;
    }
}
//input
//4
//3 1 5 15 13 11
//3 0 8 23 22 21
//2 1 1 8 0
//6 2 8 29 20 8 18 18 21
//
//output
//Case #1: 3
//Case #2: 2
//Case #3: 1
//Case #4: 3


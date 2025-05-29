package com.mademoisellegeek.googlecodejam.y2012.qualround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DancingWithTheGooglers implements Runnable {

    BufferedReader in;
    BufferedWriter out;
    static String inputFile = "2012-qualround-B-small.in";
    static String outputFile = "2012-qualround-B-small.out";

    public void run() {

        try {
            in = new BufferedReader(new FileReader(inputFile));
            out = new BufferedWriter(new FileWriter(outputFile));
            try {
                String line = in.readLine();
                int nbCases = Integer.parseInt(line);
                for (int i=1; i<=nbCases; i++) {
                    line = in.readLine();
                    String [] lineArray = line.split(" ");
                    int nbDancers = Integer.parseInt(lineArray[0]);
                    int nbSurprises = Integer.parseInt(lineArray[1]);
                    int bestResultAtLeast = Integer.parseInt(lineArray[2]);
                    int[] dancerScores = new int[nbDancers];
                    for (int j=0; j<nbDancers; j++) {
                        dancerScores[j] = Integer.parseInt(lineArray[3+j]);
                    }
                    out.write("Case #" + i + ": " + solve(nbSurprises, bestResultAtLeast, dancerScores) + "\n");
                }
            } finally {
                in.close();
            }
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //maximum number of Googlers who could have had a best result of greater than or equal to
    //it's surprising if a triplet of scores contains two scores that are 2 apart
    //No triplet of scores contains scores that are more than 2 apart. 
    private int solve(int nbSurprises, int atLeast, int[] dancerScores) {
        int resultat = 0;
        int potSurpr = 0;
        for (int score:dancerScores) {
            int quotient = score/3;
            int reste = score%3;
            if (reste == 0) {
                //t-1 t   t+1 (*)     t+1 *
                //t   t   t           t
                if (quotient >= atLeast) {
                    resultat++;
                }
                else if (quotient == atLeast-1 && quotient >0) {
                    potSurpr++;
                }
            }
            else if (reste == 1) {
                //t-1 t+1 t+1 (*)     t+1 *
                //t   t   t+1         t+1
                if (quotient >= atLeast - 1) {
                    resultat++;
                }
            }
            else {
                //t   t   t+2 (*)     t+2 *
                //t   t+1 t+1         t+1
                if (quotient >= atLeast-1) {
                    resultat++;
                }
                else if (quotient == atLeast-2) {
                    potSurpr++;
                }
            }
        }
        resultat+=Math.min(nbSurprises,potSurpr);
        return resultat;
    }
}

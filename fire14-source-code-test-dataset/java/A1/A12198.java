package com.google.codejam2012.qual.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DancingWithTheGooglers {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("2012/qualB/input.txt"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("2012/qualB/output.txt")));

        int numberOfTests = Integer.parseInt(reader.readLine()); // T

        for (int i = 0; i < numberOfTests; i++) {
            System.out.println(i);
            String[] testCase = reader.readLine().split(" ");
            int numberOfGooglers = Integer.parseInt(testCase[0]); // N
            int numberOfSurprisingTriplets = Integer.parseInt(testCase[1]); // S
            int minBestResult = Integer.parseInt(testCase[2]); // p
            //int[] totalPoints = new int[numberOfGooglers];
        	int countOk = 0, surprises = 0;
        	if (minBestResult == 0) {
        		countOk = numberOfGooglers;
        	} else {
	            for (int j = 0; j < numberOfGooglers; j++) {
	            	int totalPoints = Integer.parseInt(testCase[j + 3]); // ti
	            	int minTotal = minBestResult + (2 * (minBestResult - 1));
	            	if (totalPoints >= minTotal) {
	            		// ok without surprise
	            		countOk++;
	            	} else if (minBestResult > 1) {
	            		minTotal = minBestResult + (2 * (minBestResult - 2));
	            		if (totalPoints >= minTotal) {
		            		// ok with surprise
		            		surprises++;
		            		if (surprises <= numberOfSurprisingTriplets) {
		            			countOk++;
		            		}
	            		}
	            	}
	            }
        	}

            writer.println("Case #" + (i + 1) + ": " + countOk);
        }

        writer.flush();
        writer.close();
        reader.close();
    }

}

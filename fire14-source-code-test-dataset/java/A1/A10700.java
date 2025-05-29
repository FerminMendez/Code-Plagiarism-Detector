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

public class Dancing {

    /**
     * @param args
     */
    public static void main(String[] args) {


        bestScoresFinder(args[0]);

//         System.out.println("No of Max. Scorers " + noOfMaxScorers("2 0 5 12 19"));
//         System.out.println("No of Max. Scorers " + noOfMaxScorers("3 0 8 23 22 21"));
//         System.out.println("No of Max. Scorers " + noOfMaxScorers("2 1 1 8 0"));
//         System.out.println("No of Max. Scorers " + noOfMaxScorers("6 2 8 29 20 8 18 18 21"));
    }

    private static void bestScoresFinder(String fileName) {
        File f = new File(fileName);
        BufferedReader fin;
        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            int noOfInputs = Integer.valueOf(fin.readLine());
            String[] inputs = readSamplesFromFile(noOfInputs, fin);

            BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/asachwani/Desktop/CodeJam/Output.txt")));

            for (int i = 0; i < noOfInputs; i++) {
                System.out.println(i + 1 + " ------- " + inputs[i]);
                fout.write("Case #" + (i + 1) + ": " + noOfMaxScorers(inputs[i]) + "\n");
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

    private static int noOfMaxScorers(String input) {
        String[] data = input.split(" ");
        int noOfContestants = Integer.valueOf(data[0]);
        int noOfSurprises = Integer.valueOf(data[1]);
        int maxScore = Integer.valueOf(data[2]);
        int noOfMaxScorers = 0;
        System.out.println("No. of Surprises: " + noOfSurprises);

        for (int i = 3; i < data.length; i++) {
            int score = Integer.valueOf(data[i]);
            int minScore = score / 3;
            if (minScore >= maxScore) {
                noOfMaxScorers++;
                continue;
            } else

            if (score <= maxScore) {
                continue;
            }

            boolean found = false;
            boolean surprise = false;

            for (int x = -2; x < 3; x++) {
                for (int y = -2; y <= x; y++) {
                    if (((minScore * 3) + x + y) == score) {

                        if (Math.abs(x) + Math.abs(y) > 2) {
                            break;
                        }

                        if ((minScore + x) >= maxScore) {
                            System.out.println(score + " " + minScore + " " + (minScore + x) + " " + (minScore + y) + " " + x + " " + y);
                            found = true;
                            surprise = false;

                            if (2 - (x - y) <= 0) {
                                System.out.println("X matched Surprise");
                                surprise = true;
                            } else {
                                noOfMaxScorers++;
                                System.out.println("X matched");
                                break;
                            }

                        } else if ((minScore + y) >= maxScore) {
                            System.out.println(score + " " + minScore + " " + (minScore + x) + " " + (minScore + y) + " " + x + " " + y);
                            found = true;

                            surprise = false;

                            if (x - y <= 0) {
                                System.out.println("Y matched Surprise");
                                surprise = true;
                            } else {
                                noOfMaxScorers++;
                                System.out.println("Y matched");
                                break;
                            }
                        }
                    }

                }

                if (surprise && noOfSurprises > 0) {
                    noOfMaxScorers++;
                    noOfSurprises--;
                    break;
                }

                if (found) {

                    break;
                }
            }
            System.out.println("No. of Surprises: " + noOfSurprises);
            System.out.println("No of Max. Scorers " + noOfMaxScorers);
            System.out.println();

        }
        return noOfMaxScorers;
    }

    private static String[] readSamplesFromFile(int noOfInputs, BufferedReader fin) throws IOException {
        String[] samples = new String[noOfInputs];

        for (int i = 0; i < noOfInputs; i++) {
            samples[i] = fin.readLine();
        }

        return samples;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author bilal
 */
public class Googler {

    static String[] inputBuffer;
    static int testCasesCount = 0;

    public Googler(InputStream is) {
        Scanner scanner = new Scanner(is);
        testCasesCount = scanner.nextInt();
        inputBuffer = new String[testCasesCount];
        int loopCounter = 0;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String nextTestCase = scanner.nextLine();
            inputBuffer[loopCounter] = nextTestCase;
            loopCounter++;
            if (loopCounter == testCasesCount) {
                break;
            }
        }
    }

    public void solve_Googlers(String[] input) {
        int solution = 0;
        int googlers;
        int surprisingCases;
        int targetHighestScore;
        for (int i = 0; i < input.length; i++) {//iterate over all test cases
            System.out.print("Case #" + (i + 1) + ": ");
            solution = 0;
            StringTokenizer st = new StringTokenizer(input[i]);
            googlers = Integer.parseInt(st.nextToken());
            surprisingCases = Integer.parseInt(st.nextToken());
            targetHighestScore = Integer.parseInt(st.nextToken());
            //create Score objects from remaining tokens
            LinkedList<Integer> sortedScores = new LinkedList<Integer>();
            while (st.hasMoreTokens()) {
                sortedScores.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(sortedScores);
            //traverse over sorted collection
            for (int j = googlers - 1; j >= 0; j--) {

                int totalScore = sortedScores.get(j);
                int j1 = (int) Math.ceil(totalScore / 3.0);
                int j2 = (int) Math.ceil((totalScore - j1) / 2.0);
                int j3 = totalScore - j1 - j2;
                //System.out.println(">>>>>"+j1+" "+j2+" "+j3);
                //
                if (j1 >= targetHighestScore) {//this googler scored the higheest target score
                    solution++;
                    continue;
                }
                if (surprisingCases <= 0) {
                    break;//no more surpising cases -> no more solutions
                }
                //deal with surprising cases
                if (j1 == j2 && (j1 + 1) >= targetHighestScore && j2 > 0) {
                    surprisingCases--;
                    solution++;
                }
            }

            System.out.print(solution);
            if (i != input.length - 1) {
                System.out.println();
            }
            //break;//deal with only first case
        }


    }

    public static void main(String[] args) {
        Googler goolger = new Googler(System.in);
        goolger.solve_Googlers(inputBuffer);
    }

    class Scores {

        int totalScore;
        int j1, j2, j3;

        public Scores(int totalScore, int j1, int j2, int j3) {

            this.totalScore = totalScore;
            this.j1 = j1;
            this.j2 = j2;
            this.j3 = j3;
        }
    }
}


package com.unitedcoders.examples.codejam;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DancingWithGooglers {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("/Users/nh/b.in"));
        PrintStream out = new PrintStream(new File("/Users/nh/b.out"));

        int testcases = scanner.nextInt();
        scanner.nextLine();
        for (int casenr = 1; casenr <= testcases; casenr++) {

            int googlers = scanner.nextInt();
            int surprises = scanner.nextInt();
            int minScore = scanner.nextInt();

            ArrayList<Integer> scores = new ArrayList<Integer>();
            for(int i=0; i<googlers; i++){
                scores.add(scanner.nextInt());
            }

            int p = solve(googlers, surprises, minScore, scores);

            System.out.printf("Case #%d: %d\n", casenr, p);
            out.printf("Case #%d: %d\n", casenr, p);
        }


    }

    public static int solve(int googlers, int surprises, int minScore, ArrayList<Integer> scores){


        Collections.sort(scores);
        Collections.reverse(scores);

        int save = minScore + 2*(minScore-1);
        int min =  minScore +2*(minScore-2);
        int p = 0;


        for(int i : scores){

            if(i>=save){
                p++;
                continue;
            }else{
                if((i>=min && surprises >0) && (i>0)){
                    p++;
                    surprises--;
                }
            }

        }

        return p;



    }
}

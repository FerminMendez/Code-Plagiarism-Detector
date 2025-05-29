/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaka.codejam.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Karthik
 */
public class ProblemB {

    public static void main(String[] args) {
       readInput();
    }
     static void readInput() {
          ProblemB problemB = null;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            int surprises=0;
            int minBestResult=0;
            int[] points = null;
            int numTests = Integer.parseInt(stdin.readLine());
            for (int i = 0; i < numTests; i++) {
                String input = stdin.readLine();
                String [] inputStr= input.split("\\ ");
                for(int j=0;j<inputStr.length;j++){
                    int num = Integer.parseInt(inputStr[j]);
                    if(j==0){
                        points = new int[num];
                    }else if(j==1){
                        surprises = num;
                    }else if(j==2){
                        minBestResult = num;
                    }else{
                        points[j-3] = num;
                    }
                }
                int result = new ProblemB(surprises, minBestResult, points).calculateMaxUsers();
                System.out.println("Case #"+(1+i)+": "+result);
            }
        } catch (Exception e) {
            System.err.println("Ex in reading input:" + e);
        }
    }
   
    int surprises;
    int minBestResult;
    int[] points;

    public ProblemB(int surprises, int minBestResult, int[] points) {
        this.surprises = surprises;
        this.minBestResult = minBestResult;
        this.points = points;
    }

    int calculateMaxUsers() {
        int maxUserCount = 0;
        Arrays.sort(points);
        for (int totalScore : points) {
            boolean isGreaterThanN = false;
            if (surprises > 0) {
                isGreaterThanN = isGreaterThanN(totalScore, minBestResult, true);
                if (isGreaterThanN) {
                    surprises--;
                }
            } else {
                isGreaterThanN = isGreaterThanN(totalScore, minBestResult, false);
            }
            if (isGreaterThanN) {
                maxUserCount++;
            }
        }
        return maxUserCount;
    }

    boolean isGreaterThanN(int score, int n, boolean isSurprise) {
        boolean isGrtThanN = false;
        if (score == 0 || score == 1) {
        } else if (score == 29 || score == 30) {
            score = 30;
        } else if (isSurprise) {
            score += 4;
        } else {
            score += 2;
        }
        if (Math.floor(score / 3) >= n) {
            isGrtThanN = true;
        }
        return isGrtThanN;
    }
}

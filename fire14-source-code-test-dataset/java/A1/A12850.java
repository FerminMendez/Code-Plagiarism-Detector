/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cj2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author agraa1
 */
public class Dance {
    
    public static void main(String[] args) throws Exception {
        Dance puzzle = new Dance();
        puzzle.solve();
    }
    
    private void solve() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\B-small-attempt0.in"));
        String line = br.readLine();
        for (int count=0; count<Integer.valueOf(line); count++) {
            showResult(count+1, br.readLine());
        }
        br.close();
    }
    
    private void showResult(int caseNum, String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        int numOfGooglers = Integer.valueOf(tokenizer.nextToken());
        int surprises = Integer.valueOf(tokenizer.nextToken());
        int maxScore = Integer.valueOf(tokenizer.nextToken());
        int answer = 0;
        int runningScore = 0;
        while (tokenizer.hasMoreTokens()) {
            runningScore = Integer.valueOf(tokenizer.nextToken());
            int quot = (int) (runningScore / 3);
            if (runningScore < maxScore) {
                continue;
            }
            if (runningScore % 3 == 2) {
                if (quot + 1 >= maxScore) {
                    answer++;
                } else if ((quot + 2 >= maxScore) && (surprises > 0) && (quot + 2 <= 10)) {
                    answer++;
                    surprises--;
                }
            } else if (runningScore % 3 == 1) {
                if (quot + 1 >= maxScore) {
                    answer++;
                }                
            } else {
                if (quot >= maxScore) {
                    answer++;
                } else if ((quot + 1 >= maxScore) && (surprises > 0) && (quot + 1 <= 10)) {
                    answer++;
                    surprises--;
                }
            }
        }
        StringBuilder builder = new StringBuilder("Case #");
        builder.append(caseNum);
        builder.append(": ");
        builder.append(answer);
        System.out.println(builder.toString());
    }
}
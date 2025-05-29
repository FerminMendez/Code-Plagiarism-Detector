/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cj2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author agraa1
 */
public class Recycle {
    public static void main(String[] args) throws Exception {
        Recycle puzzle = new Recycle();
        puzzle.solve();
    }
    
    private void solve() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\C-small-attempt0.in"));
        String line = br.readLine();
        for (int count=0; count<Integer.valueOf(line); count++) {
            showResult(count+1, br.readLine());
        }
        br.close();
    }
    
    private void showResult(int caseNum, String input) {
        List<Integer> recNumbers = new ArrayList<Integer>();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        String A = tokenizer.nextToken();
        String B = tokenizer.nextToken();
        if (Integer.valueOf(B) > 10) {
            findSolution(A, B, recNumbers);
        }
        StringBuilder builder = new StringBuilder("Case #");
        builder.append(caseNum);
        builder.append(": ");
        builder.append(recNumbers.size());
        System.out.println(builder.toString());
    }
    
    private void findSolution(String A, String B, List recNumbers) {
        int numA = Integer.valueOf(A);
        int numB = Integer.valueOf(B);
        for (int num = numA; num < numB; num++) {
            getRecycles(num, numA, numB, recNumbers);
        }
    }
    
    private void getRecycles(int num, int numA, int numB, List recNumbers) {
        String toBeRec = ""+num;
        //System.out.println("Recycles for " + num);
        Set<Integer> recyclesForNum = new HashSet<Integer>();
        for (int count=1; count<toBeRec.length(); count++) {
            int recycledNum = Integer.valueOf(toBeRec.substring(toBeRec.length() - count, toBeRec.length()) + toBeRec.substring(0, toBeRec.length() - count));
            //System.out.println("" + count + ":" + recycledNum);
            if ( recycledNum <= numB && recycledNum >= numA && recycledNum > num) {
                //System.out.println("#" + (recNumbers.size()+1) + " ----------------" + num + "--" + recycledNum);
                recyclesForNum.add(recycledNum);
            }
        }
        recNumbers.addAll(recyclesForNum);
    }
}

package com.bchetty.gcj2012;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Babji Prashanth, Chetty
 */
public class DancingGooglers {
    public static void main(String[] args) {
        DancingGooglers dancingGooglers = new DancingGooglers();
        LineNumberReader lineNumberReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            lineNumberReader = new LineNumberReader(new FileReader("/Users/babjichetty/Downloads/B-small-attempt0.in"));
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/babjichetty/Downloads/B-small.out.txt"));
            String line = null;
            int index = 0;
            int count = 0;

            while ((line = lineNumberReader.readLine()) != null) {
                if(index == 0) {
                    count = Integer.parseInt(line);
                    System.out.println("Count : " + count);
                    index++;
                    continue;
                }
                if(index > count) {
                    break;
                }
                String[] arr = line.split(" ");
                int numGooglers = Integer.parseInt(arr[0]);
                int surprise = Integer.parseInt(arr[1]);
                int threshold = Integer.parseInt(arr[2]);
                ArrayList<Integer> scoreList = new ArrayList<Integer>();
                
                for(int i=3;i<3+numGooglers;i++) {
                    scoreList.add(Integer.parseInt(arr[i]));
                }
                
                bufferedWriter.write("Case #" + index + ": " + dancingGooglers.findMaxGooglers(numGooglers, surprise, threshold, scoreList));
                bufferedWriter.newLine();
                index++;
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the BufferedWriter
            try {
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public int findMaxGooglers(int N, int s, int p, ArrayList<Integer> scoreList) {
        int res = 0;
        int surpriseNum = s;
        int threshold = p + (2 * (p - 2));
        Collections.sort(scoreList);
        
        for(Integer score: scoreList) {
            if(score >= p) {
                System.out.print("Score : " + score + " divided into : ");
                int[] triplet = split(score);
                
                if(triplet[2] >= p) {
                    res++;
                } else if(surpriseNum > 0 && score >= threshold) {
                    res++;
                    surpriseNum--;
                }
            }
        }
        
        return res;
    }
    
    private int[] split(int score) {
        int div = score/3;
        int rem = score - (3 * div);
        int[] triplet = new int[3];
        triplet[0] = div;
        triplet[1] = div;
        triplet[2] = div;
        //System.out.println("Div : " + div + " Init Rem : " + rem);
        
        int index = 0;
        while(rem > 0) {
            if(index > 2) {
                index = 0;
            }
            triplet[index] += 1;
            index++;
            rem--;
        }
        
        Arrays.sort(triplet);
        System.out.println(triplet[0] + " - " + triplet[1] + " - " + triplet[2]);
        
        return triplet;
    }
}

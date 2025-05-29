package com.bchetty.gcj2012;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Babji Prashanth, Chetty
 */
public class RecycledNumbers {
    public static void main(String[] args) {
        RecycledNumbers recycledNums = new RecycledNumbers();
        LineNumberReader lineNumberReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            lineNumberReader = new LineNumberReader(new FileReader("/Users/babjichetty/Downloads/C-small-attempt0.in"));
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/babjichetty/Downloads/C-small.out.txt"));
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
                int A = Integer.parseInt(arr[0]);
                int B = Integer.parseInt(arr[1]);
                
                bufferedWriter.write("Case #" + index + ": " + recycledNums.findNumberOfPairs(A, B));
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
    
    public int findNumberOfPairs(int A, int B) {
        int res = 0;
        
        for(int i=A;i<=B;i++) {
            HashSet<Integer> partnerSet = new HashSet<Integer>();
            String input = "" + i;
            System.out.println("Num : " + input);
            int len = input.length();
            int count = len-1;
            
            for(int j=0;j<count;j++) {
                int partner = Integer.parseInt(input.substring(count-j) + input.substring(0, count-j));
                if(!partnerSet.contains(partner) && partner > i && partner <= B && ("" + partner).length() == len) {
                    System.out.println("Partner Found : " + partner);
                    res++;
                    partnerSet.add(partner);
                }
            }
        }
        
        System.out.println("Num of pairs : " + res);
        
        return res;
    }
}

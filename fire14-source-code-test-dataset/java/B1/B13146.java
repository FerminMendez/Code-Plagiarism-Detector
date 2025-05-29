package com.qualification;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Two {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("/Users/minerva/Desktop/input.txt");
        FileWriter fw = new FileWriter("/Users/minerva/Desktop/output.txt");
        
        BufferedReader br = new BufferedReader(fr);
        PrintWriter pr = new PrintWriter(fw);
        
        int numInputs = Integer.valueOf(br.readLine());
        
        for(int i=0;i<numInputs;i++) {
            String str = br.readLine();
            String values[] = str.split(" ");
            int num1 = Integer.parseInt(values[0]);
            int num2 = Integer.parseInt(values[1]);
            
            pr.println("Case #" + (i + 1) + ": " + Shifter.count(num1, num2));
        }
        pr.flush();
    }
}

class Shifter {
    private long input;
    private List<Long> rmap = new ArrayList<Long>();
    
    public Shifter(long input) {
        this.input = input;
    }
    
    private List<Long> generate() {
        int length = new Long(input).toString().length();
        long pow10 = (long)Math.pow(10,length);
        
        for (int pow = 10;;pow *= 10) {
            long n1 = input / pow;
            long n2 = input % pow;
            
            if (n1 == 0) break;
            
            long n3 = n2 * pow10 / pow + n1;
            //System.out.print(n1 + "," + n2 + " (" + input + "," + n3 + ")");
            
            if (n3 > input) {
                //System.out.println("*");
                int n3len = new Long(n3).toString().length();
                if (n3len == length && !rmap.contains(n3)) rmap.add(n3);
            } else {
                //System.out.println();
            }
        }
        
        return rmap;
    }
    
    public static long count(long num1, long num2) {
        long count = 0;
        
        for (long i = num1; i <= num2; i++) {
            List<Long> results = new Shifter(i).generate();
            for(Long item:results) {
                if (item <= num2) {
                    count++;
                    //System.out.println("(" + i + "," + item + ")");
                }
            }
        }
        
        return count;
    }
}

/* in    op     
 * 1234  2341
 */

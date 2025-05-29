package com.afarok.google.codejam2012.qualificationround;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CRecycledNumber {
    public static void main(String[] ags)  {
        
        //System.setIn(new FileInputStream("src/com/afarok/google/codejam2012/qualificationround/C-small-attempt0.in"));
        //System.setOut(new PrintStream(new File("src/com/afarok/google/codejam2012/qualificationround/C-small-attempt0.out")));

        Scanner stdIn = new Scanner(System.in);
        int t = stdIn.nextInt();
        
        for(int tCase = 1;tCase<=t;++tCase) {
            int a = stdIn.nextInt();
            int b = stdIn.nextInt();
            //boolean[] recycled = new boolean[b+1];
            int y=0;
            for(int i=a;i<=b;++i) {
                Set<Integer> recyledSet = new HashSet<Integer>();
                for(int x=10;;x=x*10) {
                    int r = i%x;
                    if(r==0) continue;
                    int d = i/x;
                    if(d==0) break;
                    int lenghtOfd = (int) Math.floor(Math.log10(d)) + 1;
                    
                    
                    int recycledNum = (int) (r*Math.pow(10, lenghtOfd))+d;
                    if(recycledNum<=i) continue;
                    if(recyledSet.contains(recycledNum)) continue;
                    
                    if(recycledNum>=a&&recycledNum<=b) {
                        ++y;
                        recyledSet.add(recycledNum);
                    }
                }
            }
            System.out.println("Case #"+tCase+": " + y);
        }
    }
}

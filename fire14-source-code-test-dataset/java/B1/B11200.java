package com.vlad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        FileWriter writer = new FileWriter("c-out.txt");
        int T = scanner.nextInt();
        for(int i=0;i<T;i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if(i>0) writer.append("\n");
            int s1 = solve(A,B);
            //int s2 = solveAlt(A,B);
            //if(s1!=s2) System.out.println("$$$ - " + i);
            writer.append("Case #"+(i+1)+": " + s1);
        }
        writer.flush();
    }

    private static int solveAlt(int A, int B) {
        Set<String> used = new HashSet<String>();
        int res = 0;
        for(int i=A;i<B;i++) {
            int len = getLen(i);
            used.clear();
            String m = i+"";
            for(int j=1;j<len;j++) {
                String pp = m.substring(j) + m.substring(0,j);
                int p = Integer.parseInt(pp);
                // TODO <=B
                if(p>i && p<=B) {
                    if(used.contains(pp)) continue;
                    used.add(pp);
                    res++;
                }
            }
        }
        return res;
    }

    private static int solve(int A, int B) {
        Set<Integer> used = new HashSet<Integer>();
        int res = 0;
        for(int i=A;i<B;i++) {
            int len = getLen(i);
            used.clear();
            for(int j=1;j<len;j++) {
                int p = getShifted(i, j, len);
                if(p>i && p<=B) {
                    if(used.contains(p)) continue;
                    used.add(p);
                    res++;
                }
            }
        }
        return res;
    }

    private static int getShifted(int i, int j, int len) {
        int v = (int)Math.pow(10,j);
        int x = (int)Math.pow(10,len-j);
        return i/v + i%v*x;
    }

    private static int getLen(int i) {
        int len = 1;
        int val = 10;
        while (i>val-1) {
            len++;
            val*=10;
        }
        return len;
    }
}

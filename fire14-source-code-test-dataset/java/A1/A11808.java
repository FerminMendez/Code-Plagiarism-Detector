package com.google.code.jam2012.problemB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Vahid
 * Date: 4/14/12
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProblemB1 {
    private static final int MAX_SCORE = 30;

    static int[] normalP = new int[MAX_SCORE + 1];
    static int[] maxSP = new int[MAX_SCORE + 1];
    static int[] list;

    public static void main(String[] args) throws IOException {

        setP();

        Scanner scanner = new Scanner(new FileInputStream("data.in"));

        FileOutputStream out = new FileOutputStream("B1.out");

        int lines = scanner.nextInt();
        scanner.nextLine();
        int n, s, p;
        for (int i = 1; i<=lines; i++){
            n = scanner.nextInt();
            s = scanner.nextInt();
            p = scanner.nextInt();
            list = new int[n];
            for (int j=0; j<n; j++)
                list[j] = scanner.nextInt();
            out.write(("Case #"+i+": "+ max(n , s ,p , 0)).getBytes());
            out.write('\r');
            out.write('\n');
            if (scanner.hasNextLine()) scanner.nextLine();
        }
        scanner.close();
        out.close();
    }

    private static int max(int n, int s, int p, int candidate) {
        if (n>0){
            int current = list[n-1];
            if ((current<2) || ((current>28))){
                if (normalP[current]<p) return max(n-1, s , p , candidate);
                else return max(n-1, s , p , candidate) + 1;
            }
            if (maxSP[current]<p) return max(n-1, s , p , candidate);
            if (normalP[current]<p) {
                if (s>0) return Math.max(max(n-1, s-1 , p , candidate)+1,max(n-1, s , p , candidate));
                return max(n-1, s , p , candidate);
            }
            return max(n-1, s , p , candidate+1)+1;
        }
        return 0;
    }

    private static void setP() {
        for (int i = 0; i <= MAX_SCORE; i++) {
            normalP[i] = (int) Math.ceil(i / 3.0);
            if (i % 3 == 0) {
                maxSP[i] = i / 3 + 1;
            } else {
                maxSP[i] = i / 3 + 2;
            }

        }
    }
}

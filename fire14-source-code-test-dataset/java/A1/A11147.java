package com.vlad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        FileWriter writer = new FileWriter("b-out.txt");
        int T = scanner.nextInt();
        for(int i=0;i<T;i++) {
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int P = scanner.nextInt();
            int[] RES = new int[N];
            
            for(int j=0;j<N;j++) {
                RES[j] = scanner.nextInt();
            }

            if(i>0) {
                writer.append("\n");
            }
            writer.append("Case #"+(i+1)+": " + solve(N,S,P,RES));
        }
        writer.flush();
    }

    private static int solve(int n, int s, int p, int[] res) {
        int num = 0;
        int surLeft = s;
        for(int i=0;i<n;i++) {
            if(p+Math.max(0,p-1)*2<=res[i]) {
                num++;
            } else {
                if(surLeft>0) {
                    if(p+Math.max(0,p-2)*2<=res[i]) {
                        surLeft--;
                        num++;
                    }
                }
            }
        }
        return num;
    }
}

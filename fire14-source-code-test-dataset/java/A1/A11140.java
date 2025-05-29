package com.google;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Googlers {
    public static void main(String[] args) throws IOException {
        final Scanner reader = new Scanner(new File("in.txt"));
        final FileWriter writer = new FileWriter(new File("out.txt"));
        
        final int N = reader.nextInt();
        reader.nextLine();
        
        for (int i = 0; i < N; i++) {
            final int n = reader.nextInt();
            final int exceptions = reader.nextInt();
            final int winScore = reader.nextInt();
            
            final int [] participants = new int [n]; 
            for (int j = 0; j < n; j++) {
                participants[j] = reader.nextInt();
            }
            
            writer.write(String.format("Case #%d: %d", (i + 1), howManyCanWin(exceptions, winScore, participants)));
            if (i < N - 1) {
                writer.write("\n");
            }
        }
        
        writer.close();
    }
    
    public static int howManyCanWin(final int exceptions, final int winScore, final int [] participants) {
        int remainException = exceptions;
        int res = 0;
        
        for (int i : participants) {
            final int thirdPart = i / 3;
            final int lastPart = i % 3;

            if ((thirdPart >= winScore) ||
                (lastPart == 1 && thirdPart + 1 >= winScore) ||
                (lastPart == 2 && thirdPart + 1 >= winScore)) {
                res++;
                continue;
            }
            
            if ((lastPart == 0 && thirdPart + 1 >= winScore && thirdPart - 1 >= 0 && remainException > 0) || 
                (lastPart == 2 && thirdPart + 2 >= winScore && remainException > 0)    ){
                remainException --;
                res++;
                continue;
            }
        }
        
        return res;
    }
}

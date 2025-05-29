package com.javanme.gcj.one.b;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dancing {

    public static void main(String args[]) {
                
        String input = "B-small-attempt0";

        Path pathin = FileSystems.getDefault().getPath(input + ".in");
        Path pathout = FileSystems.getDefault().getPath(input + ".out");


        try (PrintWriter pout = new PrintWriter(Files.newOutputStream(pathout, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE))) {
            List<String> lines = Files.readAllLines(pathin, Charset.forName("UTF-8"));

            
            String str = null;
            String[] split = null;
            StringBuffer strb = null;
            int countGooglers = 0;
            int countSurprises = 0;
            int bestResult = 0;
            int countBestGooglers = 0;
            int[] scores = null;
            int total = 0;
            int totalAux = 0;
            int dif = 0;
            boolean surprise = false;
            int countLines = lines.size();
            for (int i = 1; i < countLines; i++) {
                str = lines.get(i);
                split = str.split(" ");
                
                countGooglers = Integer.parseInt(split[0]);
                countSurprises = Integer.parseInt(split[1]);
                bestResult = Integer.parseInt(split[2]);
                countBestGooglers = 0;
                
                scores = new int[3];
                total = 0;
                totalAux = 0;
                for(int j = 0; j< countGooglers; j++)
                {
                    total = Integer.parseInt(split[j+3]);
                    totalAux = total;
                    scores[0] = totalAux/3;
                    totalAux -= scores[0];
                    scores[1] = totalAux>>1;
                    totalAux -= scores[1];
                    scores[2] = totalAux;
                    
                    if(scores[0] >= bestResult || scores[1] >= bestResult || scores[2] >= bestResult)
                    {
                        countBestGooglers++;
                        continue;
                    }
                    
                    if(countSurprises > 0 && total > 0)
                    {
                        for(int k = 0; k < scores.length; k++)
                        {
                            if(scores[k]+1 < bestResult)
                            {
                                continue;
                            }
                            
                            dif = 0;
                            for(int m = 0; m < scores.length; m++)
                            {
                                if( k == m)
                                {
                                    continue;
                                }
                                
                                dif = Math.abs((scores[k] + 1) - (scores[m] -1));
                                
                                if(dif == 2)
                                {
                                    countSurprises--;
                                    surprise = true;
                                    countBestGooglers++;
                                    break;
                                }
                            }
                            
                            if(surprise)
                            {
                                break;
                            }
                        }
                    }
                }
                
                
                pout.printf("Case #%d: %d\n", i, countBestGooglers);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

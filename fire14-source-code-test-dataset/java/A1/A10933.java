/**
 * 
 */
package com.sathish.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author satselva
 *
 */
public class Dancers
{
    
    public void processInput(String fileName) throws IOException
    {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        PrintWriter pw = new PrintWriter(new File("C:/downloads/output_problem_2.txt"));
        String input = br.readLine();
        int testCases = Integer.valueOf(input);
        
        
        for(int i=1; i<=testCases; i++)
        {
            input = br.readLine();
            String[] samples = input.split(" ");
            int googlers = Integer.valueOf(samples[0]);
            int surprising = Integer.valueOf(samples[1]);
            int pointsReq = Integer.valueOf(samples[2]);
            
            int surpriseCnt = 0;
            int normalCnt = 0;
            int surpriseThreshold = (pointsReq - 1) * 3;
            
            for(int j=3; j<samples.length; j++)
            {
                int totalScores = Integer.valueOf(samples[j]);
                
                if( totalScores > surpriseThreshold)
                {
                    normalCnt++;
                }
                else if(totalScores > 0 && totalScores >= (surpriseThreshold - 1))
                {
                    surpriseCnt++;
                }
            }
            int ans = normalCnt + Math.min(surpriseCnt, surprising);
            pw.println(String.format("Case #%d: %d", i, ans));
        }
        pw.flush();
        pw.close();
    }
    
    
    public static void main(String[] args) throws IOException
    {
        Dancers dancers = new Dancers();
        dancers.processInput("C:/downloads/B-small-attempt0.in");
    }
    
}

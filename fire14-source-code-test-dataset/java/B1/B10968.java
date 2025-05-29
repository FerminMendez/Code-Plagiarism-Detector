/**
 * 
 */
package com.sathish.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author satselva
 *
 */
public class Recycle
{
    public void processInput(String fileName) throws IOException
    {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        PrintWriter pw = new PrintWriter(new File("C:/downloads/output_problem_3.txt"));
        String input = br.readLine();
        int testCases = Integer.valueOf(input);
        
        for(int i=1; i<=testCases; i++)
        {
            input = br.readLine();
            String[] samples = input.split(" ");
            int ans = displayRecycleNum(Integer.valueOf(samples[0]), 
                    Integer.valueOf(samples[1]), samples[0].length());
            
            pw.println(String.format("Case #%d: %d", i, ans));
        }
        
        pw.flush();
        pw.close();
        
    }
    
    public int displayRecycleNum(int min, int max, int digits)
    {
        if(digits <= 1)
            return 0;
        
        Set<String> recyclePairSet = new HashSet<String>();
        
        for(int i=min; i<=max; i++)
        {
            String input = String.valueOf(i) + String.valueOf(i);
            for(int index=1; index < digits; index++)
            {
                String num = input.substring(index, index+digits);
                
                int numVal = Integer.valueOf(num);
                
                if(!(numVal > min && numVal < max))
                    continue;
                
                if(num.startsWith("0") || i == numVal)
                    continue;
                
                if(i < Integer.valueOf(num))
                {
                    recyclePairSet.add(String.valueOf(i) + String.valueOf(num));
                }
                else 
                {
                    recyclePairSet.add(String.valueOf(num) + String.valueOf(i));
                }
            }
        }
        return recyclePairSet.size();
    }
    
    public static void main(String[] args) throws IOException
    {
        Recycle recycle = new Recycle();
        recycle.processInput("C:/downloads/C-small-attempt0.in");
        
    }
}

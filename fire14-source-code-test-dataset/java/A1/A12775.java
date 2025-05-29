import java.util.*;
import java.io.*;

public class DancingWithTheGooglers
{
    public DancingWithTheGooglers()
    {
        Scanner inFile = null;
        try
        {
            inFile = new Scanner(new File("inputB.txt"));
        }
        catch(Exception e)
        {
            System.out.println("Problem opening input file. Exiting...");
			System.exit(0);
        }
        int t = inFile.nextInt();
        
        int [] results = new int [t];
        DancingWithTheGooglersMax [] rnc = new DancingWithTheGooglersMax[t];
        
        int i, j;
        int [] scores;
        int s, p;
        for(i = 0; i < t; i++)
        {
            scores = new int [inFile.nextInt()];
            s = inFile.nextInt();
            p = inFile.nextInt();
            for(j = 0; j < scores.length; j++)
                scores[j] = inFile.nextInt();
            
            rnc[i] = new DancingWithTheGooglersMax(i, scores, s, p, results);
            rnc[i].start();
        }
        inFile.close();
        
        boolean done = false;
        
        while(!done)
        {
            done = true;
            for(i = 0; i < t; i++)
                if(rnc[i].isAlive())
                {
                    done = false;
                    break;
                }
        }
        
        PrintWriter outFile = null;
        try
        {
            outFile = new PrintWriter(new File("outputB.txt"));
        }
        catch(Exception e)
        {
            System.out.println("Problem opening output file. Exiting...");
			System.exit(0);
        }
        
        for(i = 0; i < results.length; i++)
            outFile.printf("Case #%d: %d\n", i+1, results[i]);
        outFile.close();
    }
    
    public static void main(String [] args)
    {
        new DancingWithTheGooglers();
    }
    
    private class DancingWithTheGooglersMax extends Thread
    {
        int id;
        int s, p;
        int [] results, scores;
        
        public DancingWithTheGooglersMax(int i, int [] aScores, int aS, int aP,int [] res)
        {
            id = i;
            s = aS;
            p = aP;
            results = res;
            scores = aScores;
        }
        
        public void run()
        {
            int a = 0, b = 0;
            
            if(p == 0)
                results[id] = scores.length;
            else if(p == 1)
            {
                int y;
                y = 3*p - 3;
                
                for(int i = 0; i < scores.length; i++)
                    if(scores[i] > y)
                        a++;
                    else if(scores[i] > 0)
                        b++;
                
                b = Math.min(b, s);
                results[id] = a+b;
            }
            else
            {
                int y, z;
                y = 3*p - 3;
                z = 3*p - 5;
                
                for(int i = 0; i < scores.length; i++)
                    if(scores[i] > y)
                        a++;
                    else if(scores[i] > z)
                        b++;
                
                b = Math.min(b, s);
                results[id] = a+b;
            }
        }
    }
}
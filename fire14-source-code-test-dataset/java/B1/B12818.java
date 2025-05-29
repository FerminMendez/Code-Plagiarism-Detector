import java.util.*;
import java.io.*;

public class RecycledNumbers
{
    public RecycledNumbers()
    {
        Scanner inFile = null;
        try
        {
            inFile = new Scanner(new File("input.txt"));
        }
        catch(Exception e)
        {
            System.out.println("Problem opening input file. Exiting...");
			System.exit(0);
        }
        int t = inFile.nextInt();
        
        int [] results = new int [t];
        RecycledNumbersCounter [] rnc = new RecycledNumbersCounter[t];
        
        int i;
        for(i = 0; i < t; i++)
        {
            rnc[i] = new RecycledNumbersCounter(i, inFile.nextInt(), inFile.nextInt(), results);
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
            outFile = new PrintWriter(new File("output.txt"));
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
        new RecycledNumbers();
    }
    
    public static String intToString(int i)
    {
        String res = "";
        while(i > 0)
        {
            res =(i%10)+res;
            i /= 10;
        }
        
        return res;
    }
    
    private class RecycledNumbersCounter extends Thread
    {
        int id;
        int a, b;
        int [] results;
        
        public RecycledNumbersCounter(int i, int first, int second, int [] res)
        {
            id = i;
            a = first;
            b = second;
            results = res;
        }
        
        public void run()
        {
            int count = 0;
            for(int i = a; i < b; i++)
            {
                for(int j = i+1; j <= b; j++)
                    if(recycled(i, j))
                    {
                        count++;
                    }
            }
            results[id] = count;
        }
        
        public boolean recycled(int a, int b)
        {
            String c = intToString(a);
            String d = intToString(b);
            boolean found = false;
            
            if(c.length() != d.length())
                return false;
            
            int d_index = d.indexOf(c.charAt(0));
            
            while(d_index >= 0)
            {
                found = true;
                for(int i = 1; i < c.length(); i++)
                {
                    if(c.charAt(i) != d.charAt((d_index + i)%d.length()))
                    {
                        found = false;
                        break;
                    }
                }
                if(found)
                    return true;
                d_index = d.indexOf(c.charAt(0), d_index+1);
            }
            
            return false;
        }
    }
}
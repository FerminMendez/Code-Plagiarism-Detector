package com.gcj.recyclednumbers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @original Apr 14, 2012 12:08:21 PM
 * @author lewisju
 */
public class Solve
{
    final Set<RecycledPair> distinct = new HashSet<RecycledPair>();
    final int a;
    final int b;
    
    public Solve(int a, int b)
    {
        this.a = a;
        this.b = b;
        
        for(int i = a; i <= b; i++)
        {
            List<Integer> ints = recycled(i);
            for(int recycled : ints)
            {
                if(recycled <= b && recycled >= a)
                {
                    RecycledPair p = new RecycledPair(i,recycled);
                    distinct.add(p);
                }
            }
        }
    }

    private List<Integer> recycled(int number)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        String s = Integer.toString(number);
        
        for(int i=1; i < s.length(); i++)
        {
            int splitpoint = s.length()-i;
            String begin = s.substring(0, splitpoint);
            String end = s.substring(splitpoint);
            String result = end+begin;
            if(!result.startsWith("0") && !result.equals(s))
                list.add(Integer.parseInt(result));
        }
        
        return list;
    }

    public int count()
    {
        return distinct.size();
    }
    
    class RecycledPair
    {
        private final int a;
        private final int b;

        public RecycledPair(int i, int recycled)
        {
            if(i < recycled)
            {
                a = i;
                b = recycled;
            }
            else
            {
                a = recycled;
                b = i;
            }
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + a;
            result = prime * result + b;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            RecycledPair other = (RecycledPair) obj;
            return a==other.a && b==other.b;
        }

        @Override
        public String toString()
        {
            return ""+a+" "+b;
        }
    }
    
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            
            String T = reader.readLine();
            int t = Integer.parseInt(T);
            
            for(int i=0; i < t; i++)
            {
                String line = reader.readLine();
                String[] inputs = line.split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                
                Solve s = new Solve(a, b);
                StringBuffer sb = new StringBuffer();
                sb.append("Case #");
                sb.append((i+1));
                sb.append(": ");
                sb.append(s.count());
                System.out.println(sb.toString());
            }
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


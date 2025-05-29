package code.jam;

import java.io.*;
import java.util.*;

public class CodeJam {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String name = "test";
        
        Scanner in = new Scanner( new BufferedReader( new FileReader(name + ".in") ) );
        BufferedWriter out = new BufferedWriter( new FileWriter(name + ".out") );
        
        int req_count;
        int seed , count  = 0, factor , temp;
        int c2;
        int i , j , k = 1;
        int[] parts = null;
        boolean[] arr = null;
        
        int N = in.nextInt();
        
        while(in.hasNext())
        {
            int start = in.nextInt();
            int end = in.nextInt();
            req_count = 0;
            
            arr = new boolean[end+1];
            
            filterArray(arr);
            
            for(i=start ; i<end ; i++)
            {
                if(!arr[i])
                {
                    seed = i;
                    count = digitsCount(seed);
                    
                    if(count > 2)
                    {
                        parts = new int[count-1];
                        factor = 10;

                        for(j=(count-2) ; j >= 0 ; j--)
                        {
                            parts[j] = seed/factor;
                            factor = factor*10;
                        }
                        
                        for(j=1 ; j<=parts.length ; j++)
                        {
                            factor = (int)Math.pow(10,count-j);
                            temp = seed%factor;
                            temp = temp*((int)Math.pow(10,j))+parts[j-1];
                            
                            c2 = digitsCount(temp);
                            
                            if(count == c2)
                            {
                                if( (temp >= start) && (temp <= end) )
                                {
                                    if(!arr[seed])
                                        arr[seed] = true;
                                    
                                    if(!arr[temp])
                                        req_count++;
                                }
                            }
                        }
                    }
                    else if(count == 2)
                    {
                        temp = seed%10;
                        temp = (temp*10)+(seed/10);
                        
                        if( (temp >= start) && (temp <= end) )
                        {
                            req_count++;
                            arr[temp] = true;
                            arr[seed] = true;
                        }
                    }
                }
            }
            
            out.write("Case #" + k + ": " + req_count);
            out.newLine();
            k++;
        }
        
        out.close();
    }
    
    //----------------------------------------------------------------------
    
    public static int digitsCount(int num)
    {
        int count = 0;
        
        while(num > 0)
        {
            count++;
            num = num/10;
        }
        
        return count;
    }
    
    //----------------------------------------------------------------------
    
    public static void filterArray(boolean[] arr)
    {
        int length = arr.length;
        
        int i;
        int temp = 0;
        
        
        if( (length >= 10) && (length < 100) )
        {
            temp = 11;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*11;
            }
        }
        
        if( (length >= 100) && (length < 1000) )
        {
            temp = 111;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*111;
            }
        }
        
        if( (length >= 1000) && (length < 10000) )
        {
            temp = 1111;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*1111;
            }
        }
        
        if( (length >= 10000) && (length < 100000) )
        {
            temp = 11111;
            for(i=2 ; i<=10 && temp <= length; i++)
            {
                arr[temp] = true;
                temp = i*11111;
            }
        }
        
        if( (length >= 100000) && (length < 1000000) )
        {
            temp = 111111;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*111111;
            }
        }
        
        if( (length >= 1000000) && (length <= 2000000) )
            arr[1111111] = true;
    }
}

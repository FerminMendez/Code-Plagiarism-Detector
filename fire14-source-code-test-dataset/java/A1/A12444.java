package code.jam;

import java.io.*;
import java.util.*;

public class CodeJam {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String name = "B-small-attempt2";
        
        Scanner in = new Scanner( new BufferedReader( new FileReader(name + ".in") ) );
        BufferedWriter out = new BufferedWriter( new FileWriter(name + ".out") );
        
        int N = in.nextInt();
        
        int num , n_surprise , best_result;
        int surr_count , req_count;
        boolean sol_found , looper;
        int x , y , diff , temp;
        int i,j,k = 1;
        int[] results = null;
        int[] arr = new int[3];
        
        while( in.hasNext() )
        {
            num = in.nextInt();
            n_surprise = in.nextInt();
            best_result = in.nextInt();
            results = new int[num];
            
            for(i=0 ; i<num ; i++)
                results[i] = in.nextInt();
                
            req_count = 0;
            surr_count = 0;
            
            for(i=0 ; i<num ; i++)
            {
                diff = 0;
                sol_found = false;
                looper = true;
                
                if( (results[i]&1) == 0 )
                {
                    //even result
                    if( (best_result&1) == 0 )
                        y = best_result;
                    else
                        y = best_result-1;
                }
                else
                {
                    //odd result
                    if( (best_result&1) != 0 )
                        y = best_result;
                    else
                        y = best_result-1;
                }
                
                while(looper)
                {
                    x = (results[i]-y)/2;
                    diff = Math.abs(x-y);
                    
                    if( (diff == 0) || (diff == 1) )
                    {
                        if( (x >= best_result) || (y >= best_result) )
                        {
                            req_count++;
                            looper = false;
                            sol_found = true;
                        }
                        else
                            y++;
                    }
                    else
                        y++;
                    
                    if( (y >= 10) || (y >= results[i]) )
                        looper = false;
                }
                
                if(!sol_found)
                {
                    y = best_result;
                    temp = results[i]-y;
                    
                    if( (temp&1) == 0 )
                    {
                        x = temp/2;
                        temp /= 2;
                    }
                    else
                    {
                        x = (temp/2)+1;
                        temp = results[i]-x-y;
                    }
                    
                    arr[0] = y;
                    arr[1] = x;
                    arr[2] = temp;
                    
                    Arrays.sort(arr);
                    
                    diff = Math.abs(arr[0]-arr[2]);
                    
                    if (diff == 2)
                    {
                        if(surr_count < n_surprise)
                        {
                            surr_count++;
                            req_count++;
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
        int length = arr.length-1;
        
        int i;
        int temp = 0;
        
        
        if( (length > 10) && (length <= 100) )
        {
            temp = 11;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*11;
            }
        }
        
        if( (length > 100) && (length <= 1000) )
        {
            temp = 111;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*111;
            }
        }
        
        if( (length > 1000) && (length <= 10000) )
        {
            temp = 1111;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*1111;
            }
        }
        
        if( (length > 10000) && (length <= 100000) )
        {
            temp = 11111;
            for(i=2 ; i<=10 && temp <= length; i++)
            {
                arr[temp] = true;
                temp = i*11111;
            }
        }
        
        if( (length > 100000) && (length <= 1000000) )
        {
            temp = 111111;
            for(i=2 ; i<=10 && temp <= length ; i++)
            {
                arr[temp] = true;
                temp = i*111111;
            }
        }
        
        if( (length > 1000000) && (length <= 2000000) )
            arr[1111111] = true;
    }
}

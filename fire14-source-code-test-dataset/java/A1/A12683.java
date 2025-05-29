/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topcoder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ahmet
 */
public class codeJam {
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Scanner scan = new Scanner(System.in);
        
        
        int T = scan.nextInt();
        
        for(int i = 0; i < T; i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int howMany = scan.nextInt();
            int S = scan.nextInt();
            int p = scan.nextInt();
            
            for(int ii = 0; ii < howMany; ii++)
            {
                list.add(scan.nextInt());
            }
            Collections.sort(list);
            System.out.println("Case #" + (i + 1) + ": " + analiz(list, S, p));
        }  
    }
    
    public static String analiz( ArrayList <Integer> a, int S, int p)
    {
        int count = 0;
        for(int i = 0; i < a.size(); i++)
        {
            if(a.get(i)/3 >= p)
            {
                 a.set(i, -1);
                 count++;
            }
        }   
        for(int i = 0; i < a.size(); i++)
        {
            if(a.get(i) == -1)
            {
                 a.remove(i);
                 i=0;
            }
        }
        while(S >= 0 && a.size() > 0 && a.get(a.size() - 1 ) > 0)
        {
            if(a.get(a.size() - 1 )%3 == 0 )
            {
                if(a.get(a.size() - 1)/3 + 1 >= p && S != 0)
                {
                    count++;
                    S--;
                }
                else
                    break;
            }
            else if(a.get(a.size() - 1 ) % 3 == 1)
            {
                if(a.get(a.size() - 1)/3 + 1 >= p)
                {
                    count++;
                }
                else
                    break;

            }
            else if(a.get(a.size() - 1 ) % 3 == 2)
            {
                if(a.get(a.size() - 1) /3 + 1 >= p)
                {
                    count++;
                }      
                else if(a.get(a.size() - 1)/3 + 2 >= p && S != 0)
                {
                    count++;
                    S--;
                }
                else
                    break;
            }     
            a.remove(a.size() - 1 );            
        }
        
        return "" + count;
    }
    
}

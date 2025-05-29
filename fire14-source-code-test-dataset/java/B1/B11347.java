// CHANGE DATA TYPE FOR LONG SUBMISSION

import java.util.*;
import java.io.*;

public class P3
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        
        int cases = Integer.parseInt(sc.nextLine());
        int c = 0;
        
        for (int i = 0; i < cases; i++)
        {
            int l = sc.nextInt(); // lower limit
            int u = sc.nextInt(); // upper limit
            c = 0;
            
            for(int j = l; j<= u; j++)
            {
                c += noOfCombos(j,l,u);
            }
            
            pw.println("Case #" + (i + 1) + ": " + c);
        }
        
        pw.close();
        sc.close();
    }
    
    static int noOfCombos(int x ,int l, int u) throws Exception
    {
        String s = (x+"");
        int n = 0, c = 0;
        int d = s.length();
        
        for(int i = 1; i<d; i++)
        {
            boolean lz = s.charAt(i) == '0';
            if(!lz)
            {
                n = Integer.valueOf(s.substring(i) + s.substring(0,i));
                if(n >= l && n <= u && n > x) c++;
            }
        }
        return c;
        // 120
        // i = 0 n = 201
        // i = 1 n = 
        // i = 2 n = 
    }
        
}

/*
 * charAt 0 != 0 (leading zero)
 * rotate via int -> string ->  int
 * 
 * n = (int)((x%Math.pow(10,i)*Math.pow(10,d-i+1)) + (x/Math.pow(10,i)));
 */
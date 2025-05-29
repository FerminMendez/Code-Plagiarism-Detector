/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Alex
 */
public class ReduceReuseButDont 
{
    
    public static void main(String sArgs[]) throws IOException
    {
        
        Scanner oScan = new Scanner(new File("C-small-attempt0.in"));
        int sets = Integer.parseInt(oScan.nextLine().trim());
        int count = 0;
        while(sets-->0)
        {
            count++;
            int a = oScan.nextInt();
            int b = oScan.nextInt();
            int rec = 0;        
            for(int i = a; i<b; i++)
            {
                for(int j=i+1; j<=b; j++)
                {
                    if(recycled(i,j))rec++;
                }
            }
            System.out.println("Case #"+count+": "+rec);
        }
    }
    
    public static boolean recycled(int a, int b)
    {
        String sA = new String(a+"");
        String sB = new String(b + "");
        if(sA.length()!=sB.length())return false;
        for(int i = 0; i<sA.length(); i++)
        {
            if(sA.indexOf(sB.charAt(i))==-1)return false;
        }
        for(int i = 1; i<sA.length(); i++)
        {
            for(int j = i+1; j<=sA.length(); j++)
            {
                if((sA.substring(i,j)+sA.substring(0,i)).equals(sB))return true;
            }
        }
        return false;
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author karthik
 */
public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    public static int isrotate(String c,int n)
    {
        String c1=new String();
        for(int i=c.length()-n;i<c.length();i++)
        c1+=c.charAt(i);
        c1+=c.substring(0,c.length()-n);
        int a1=Integer.parseInt(c1);
        return a1;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        // TODO code application logic here
        
        FileInputStream f=new FileInputStream("input");
        DataInputStream dis=new DataInputStream(f);
        BufferedReader br=new BufferedReader(new InputStreamReader(dis));
        ArrayList<Integer> al=new ArrayList<Integer>();
        int n=Integer.parseInt(br.readLine());
        int a,b,count=0;
        String s[];
        int temp,temp1;
        for(int i=0;i<n;i++)
        {
            s=br.readLine().split(" ");
            a=Integer.parseInt(s[0]);
            b=Integer.parseInt(s[1]);
            for(int j=a;j<b;j++)
            {
                String str=String.valueOf(j);
                int m=str.length();
                int x=0;
                
                
                for(int k=1;k<m;k++)
                {
                    x=isrotate(String.valueOf(j),k);
                    if(a<=j && j<x && x<=b)
                    {
                        //System.out.println(j+","+x);
                        count++;
                    }
                }
            }
            
            System.out.println("Case #"+(i+1)+": "+count);
            count=0;
        }   
    }
}

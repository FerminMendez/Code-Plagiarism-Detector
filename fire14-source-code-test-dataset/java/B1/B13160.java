

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshuahm
 */
public class codejamC {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader inFile = new FileReader("C-small-attempt0.in");
        Scanner in = new Scanner(inFile);
        FileWriter outFile = new FileWriter("C-small-attempt0.out");
        PrintWriter out = new PrintWriter(outFile);
        //Scanner in = new Scanner(System.in);
        
            ArrayList<String> temp2 = new ArrayList<String>();
            String temp;
            
            for(int i=1;i<10;i++)
                for(int j=0;j<10;j++)
                {
                    temp = "" + i + j; 
                    temp2.add(temp);
                }
            
            for(int i=1;i<10;i++)
                for(int j=0;j<10;j++)
                    for(int k=0;k<10;k++)
                    {
                        temp = "" + i + j + k ; 
                        temp2.add(temp);
                    }
            
            for(int i=1;i<10;i++)
                for(int j=0;j<10;j++)
                    for(int k=0;k<10;k++)
                        for(int l=0;l<10;l++)
                        {
                            temp = "" + i + j + k + l; 
                            temp2.add(temp);
                        }
            
            for(int i=1;i<10;i++)
                for(int j=0;j<10;j++)
                    for(int k=0;k<10;k++)
                        for(int l=0;l<10;l++)
                            for(int m=0;m<10;m++)
                            {
                                temp = "" + i + j + k + l + m; 
                                temp2.add(temp);
                            }
            
            for(int i=1;i<10;i++)
                for(int j=0;j<10;j++)
                    for(int k=0;k<10;k++)
                        for(int l=0;l<10;l++)
                            for(int m=0;m<10;m++)
                                for(int n=0;n<10;n++)
                                {
                                    temp = "" + i + j + k + l + m + n; 
                                    temp2.add(temp);
                                }
                for(int j=0;j<10;j++)
                    for(int k=0;k<10;k++)
                        for(int l=0;l<10;l++)
                            for(int m=0;m<10;m++)
                                for(int n=0;n<10;n++)
                                    for(int p=0;p<10;p++)
                                {
                                    temp = "" + '1' + j + k + l + m + n + p; 
                                    temp2.add(temp);
                                }
           
            String[] perms = new String[temp2.size()];
            temp2.toArray(perms);     
            int total=0;
            int x;
        
        int T= in.nextInt();
        for(int t=0;t<T;t++)
        {
            total=0;
            int A= in.nextInt();
            int B= in.nextInt();    
            HashSet<Integer> distinct = new HashSet<Integer>();
            for(int i=0;i<perms.length;i++)
            {
                if(Integer.parseInt(perms[i])>B)
                    break;
                distinct.clear();
                temp = perms[i];
                if(Integer.parseInt(perms[i])>=A && Integer.parseInt(perms[i])<=B)
                {
                    distinct.add(Integer.parseInt(perms[i]));
                    for(int j=0;j<perms[i].length()-1;j++)
                    {
                        temp=temp.substring(1)+ temp.charAt(0);
                        x = Integer.parseInt(temp);
                        if(x<=B && x>=A && temp.charAt(0) != '0')
                            distinct.add(x);
                    }   
                    total+= distinct.size()-1;
                    //if(distinct.size()>1)
                       // System.out.println(perms[i] + "   " + (distinct.size()-1));
                } 
            }            
            out.println("Case #"+ (t+1) +": " + total/2);
        }
        in.close();
        out.close();
    }
}
